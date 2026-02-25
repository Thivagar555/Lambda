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

}
