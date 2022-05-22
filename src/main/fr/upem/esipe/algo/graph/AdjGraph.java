package fr.upem.esipe.algo.graph;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class AdjGraph implements Graph {
    private final ArrayList<LinkedList<Edge>> adj;
    private final int n; // number of vertices
    private final List<Integer> v1;
    private final List<Integer> v2;

    public AdjGraph(int n, int sizeV1, int sizeV2) {
        if (n <= 0)
            throw new IllegalArgumentException();
        this.n = n;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new LinkedList<>());

        v1 = IntStream.range(0, sizeV1).boxed().toList();
        v2 = IntStream.range(sizeV1, sizeV1 + sizeV2).boxed().toList();
    }

    public List<Integer> getV1() { return v1; }
    public List<Integer> getV2() {
        return v2;
    }

    @Override
    public int numberOfVertices() {
        return n;
    }

    public void checkTwoIndex(int i, int j) {
        Objects.checkIndex(i, n);
        Objects.checkIndex(j, n);
    }

    @Override
    public void addEdges(int i, int j, int value) {
        checkTwoIndex(i, j);
        var row = adj.get(i);
        row.add(new Edge(i, j, value));
        row = adj.get(j);
        row.add(new Edge(j, i, value));
    }

    @Override
    public Iterator<Edge> edgeIterator(int i) {
        return adj.get(i).iterator();
    }

    @Override
    public void forEachEdge(int i, Consumer<Edge> consumer) {
        Objects.checkIndex(i, n);
        edgeIterator(i).forEachRemaining(consumer);
    }

@Override
    public String toString() {
        var str = new StringBuilder();
        for(int i = 0; i < numberOfVertices(); i++) {
            forEachEdge(i, e -> str.append(e).append("\n"));
            str.append("\n");
        }
        return str.toString();
    }

}
