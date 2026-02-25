package graphs;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(boolean isWeighted, boolean isDirected)
    {
        this.vertices = new ArrayList<>();
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;
    }
    public Vertex addVertex(String data)
    {
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }
    public void addEdge(Vertex v1, Vertex v2, Integer weight)
    {
        if(!this.isWeighted)
        {
            weight = null;
        }
        v1.addEdge(v2, weight);
        if(!this.isDirected)
        {
            v2.addEdge(v1, weight);
        }
    }
    public void removeEdge(Vertex v1, Vertex v2)
    {
        v1.removeEdge(v2);
        if(!this.isDirected)
        {
            v2.removeEdge(v1);
        }
    }
    public void removeVertex(Vertex v)
    {
        vertices.remove(v);
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public boolean isWeighted() {
        return isWeighted;
    }

    public boolean isDirected() {
        return isDirected;
    }
    public Vertex   getVertexByValue(String value)
    {
        for(Vertex v : vertices)
        {
            if(v.getData().equals(value))
                return v;
        }
        return null;
    }
    public void print()
    {
        for(Vertex v: vertices)
        {
            v.print(isWeighted);
        }
    }

    public static void main(String[] args) {
        Graph busNetwork = new Graph(true, false);

        Vertex saravanampatty = busNetwork.addVertex("saravanampatty");
        Vertex ganapathy = busNetwork.addVertex("ganapathy");

        busNetwork.addEdge(saravanampatty, ganapathy, 5);

        busNetwork.print();
    }
}
