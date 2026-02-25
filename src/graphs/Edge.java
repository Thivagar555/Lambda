package graphs;

public class Edge {
    private Vertex start;
    private Vertex end;
    //Non primitive can store null value
    private Integer weight;

    public Edge(Vertex s, Vertex e, Integer w)
    {
        this.start = s;
        this.end = s;
        this.weight = w;
    }

    public Vertex getStart() {
        return start;
    }

    public void setStart(Vertex start) {
        this.start = start;
    }

    public Vertex getEnd() {
        return end;
    }

    public void setEnd(Vertex end) {
        this.end = end;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
