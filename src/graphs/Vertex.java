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

        // Align left in 15 character width
        System.out.printf("%-15s --> ", this.data);

        if (this.edges.size() == 0) {
            System.out.println();
            return;
        }

        for (int i = 0; i < this.edges.size(); i++) {

            System.out.print(this.edges.get(i).getEnd().data);

            if (showWeight) {
                System.out.print(" (" + this.edges.get(i).getWeight() + ")");
            }

            if (i != this.edges.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();
    }
}
