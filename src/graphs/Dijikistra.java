package graphs;

import java.util.*;

public class Dijikistra {
    public static Dictionary[] dijkstra(Graph g, Vertex startingVertex)
    {
        Dictionary<String, Integer> distances = new Hashtable<>();
        Dictionary<String, Vertex > previous = new Hashtable<>();

    PriorityQueue<QueueObject> queue = new PriorityQueue<>();

    queue.add(new QueueObject(startingVertex, 0));

    for(Vertex v: g.getVertices()){
        if(v != startingVertex)
            distances.put(v.getData(), Integer.MAX_VALUE);

        previous.put(v.getData(), new Vertex("Null"));
    }
    distances.put(startingVertex.getData(), 0);

    while(queue.size() != 0)
    {
        Vertex current = queue.poll().vertex;
        for(Edge e : current.getEdges())
        {
            Integer alternative = distances.get(current.getData()) + e.getWeight();
            String neighborValue = e.getEnd().getData();
            if(alternative < distances.get(neighborValue))
            {
                distances.put(neighborValue, alternative);
                previous.put(neighborValue, current);
                queue.add(new QueueObject(e.getEnd(), distances.get(neighborValue)));
            }
        }
    }
    return new Dictionary[] { distances, previous};
    }
    public static void shortestPathBetween(Graph g, Vertex start, Vertex target)
    {
        Dictionary[] dijkstraDictonaries = dijkstra(g, start);
        Dictionary distances = dijkstraDictonaries[0];
        Dictionary previous = dijkstraDictonaries[1];

        Integer distance = (Integer) distances.get(target.getData());
        System.out.println("Shortest Distance Between " + start.getData() + " and " + target.getData());
        System.out.println(distance);

        ArrayList<Vertex> path = new ArrayList<>();
        Vertex v = target;

        while(v.getData() != "Null")
        {
            path.add(0, v);
            v=(Vertex) previous.get(v.getData());
        }
        System.out.println("shortest path");
        for(Vertex pathVertex : path)
        {
            System.out.println(pathVertex.getData());
        }
    }
    public static void dijkstraResultPrinter(Dictionary[] d) {

        System.out.println("Distances:\n");

        Enumeration keys = d[0].keys();
        while (keys.hasMoreElements()) {
            String nextKey = keys.nextElement().toString();
            System.out.println(nextKey + " : " + d[0].get(nextKey));
        }

        System.out.println("\nPrevious:\n");

        Enumeration keys2 = d[1].keys();
        while (keys2.hasMoreElements()) {
            String nextKey = keys2.nextElement().toString();
            Vertex nextVertex = (Vertex) d[1].get(nextKey);

            if (nextVertex != null) {
                System.out.println(nextKey + " : " + nextVertex.getData());
            } else {
                System.out.println(nextKey + " : null");
            }
        }
    }
    public static void main(String[] args) {
        Graph testGraph = new Graph(true, true);
        Vertex a = testGraph.addVertex("A");
        Vertex b = testGraph.addVertex("B");
        Vertex c = testGraph.addVertex("C");
        Vertex d = testGraph.addVertex("D");
        Vertex e = testGraph.addVertex("E");
        Vertex f = testGraph.addVertex("F");
        Vertex g = testGraph.addVertex("G");

        testGraph.addEdge(a, c, 100);
        testGraph.addEdge(a, b, 3);
        testGraph.addEdge(a, d, 4);
        testGraph.addEdge(d, c, 3);
        testGraph.addEdge(d, e, 8);
        testGraph.addEdge(e, b, -2);
        testGraph.addEdge(e, f, 10);
        testGraph.addEdge(b, g, 9);
        testGraph.addEdge(e, g, -50);

        Dijikistra.dijkstraResultPrinter(dijkstra(testGraph, a));
        shortestPathBetween(testGraph, a, g);
    }

}
