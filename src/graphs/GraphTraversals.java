package graphs;

import java.util.ArrayList;

public class GraphTraversals {
    public static void depthFirstTraversal(Vertex start, ArrayList<Vertex> visited)
    {
        System.out.println(start.getData() + " ");

        for(Edge e: start.getEdges()) {
            Vertex neighbour = e.getEnd();

            if (!visited.contains(neighbour))
            {
                visited.add(neighbour);
                GraphTraversals.depthFirstTraversal(neighbour, visited);
            }
        }
    }

}
