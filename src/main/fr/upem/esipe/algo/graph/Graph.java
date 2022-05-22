package fr.upem.esipe.algo.graph;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public interface Graph {

    int numberOfVertices();

    void addEdges(int i, int j, int value);

    Iterator<Edge> edgeIterator(int i);

    void forEachEdge(int i, Consumer<Edge> consumer);

    List<Integer> getV1();
}
