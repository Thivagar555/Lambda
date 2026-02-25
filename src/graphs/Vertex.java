package graphs;

import java.util.ArrayList;

public class Vertex {
    private String data;
    private ArrayList<Edge> edges;
    public Vertex(String data)
    {
        this.data = data;
        edges = new ArrayList<>();
    }
    public void addEdge(Vertex endVertex, Integer weight)
    {
        edges.add(new Edge(this, endVertex, weight));
    }
    public void removeEdge(Vertex endVertex)
    {
        edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    }

    public String getData() {
        return data;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }
    public void print(boolean showWeight) {

        String message = this.data + " --> ";

        // If no edges exist
        if (this.edges.size() == 0) {
            System.out.println(message);
            return;
        }

        for (int i = 0; i < this.edges.size(); i++) {

            message += this.edges.get(i).getEnd().data;

            // Show weight if required
            if (showWeight) {
                message += " (" + this.edges.get(i).getWeight() + ")";
            }

            // Add comma if not last edge
            if (i != this.edges.size() - 1) {
                message += ", ";
            }
        }

        System.out.println(message);
    }
}
