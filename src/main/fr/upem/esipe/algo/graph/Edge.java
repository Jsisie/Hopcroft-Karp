package fr.upem.esipe.algo.graph;

import java.util.Objects;

public class Edge {

    private final int start;
    private final int end;
    private final int value;

    public Edge(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    public Edge(int start, int end) {
        this(start, end, 1);
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    /**
     * Return <b>true</b> if <i>v</i> is a vertex of the Edge <br>
     * Return <b>false</b> otherwise
     *
     * @param v int
     * @return boolean
     */
    public boolean isVertexInEdge(int v) {
        // return true if v is the start or the end of the edge
        return getStart() == v || getEnd() == v;
    }

    public Edge reversedEdge() {
        return new Edge(end, start, value);
    }

    @Override
    public String toString() {
        return start + " " + end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(end, start, value);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Edge other && end == other.end && start == other.start && value == other.value;
    }
}