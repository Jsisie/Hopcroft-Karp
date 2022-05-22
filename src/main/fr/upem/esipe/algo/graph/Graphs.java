package fr.upem.esipe.algo.graph;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Graphs {

    /**
     * Main code of the HopCroft-Karp algorithm,
     * that uses levelBFS and levelDFS algorithms
     *
     * @param g  Graph
     * @param v1 int
     * @return List of Edges
     */
    public static List<Edge> hopcroftKarp(Graph g, List<Integer> v1, List<Integer> v2) {
        Objects.requireNonNull(g);
        Objects.requireNonNull(v1);
        Objects.requireNonNull(v2);

        // create all useful list, arrays and integer values
        var M = new ArrayList<Edge>();
        var size = g.numberOfVertices();
        var level = new int[size];
        var visited = new boolean[size];
        var nbIteration = 0;

        while (levelBFS(g, v1, M, level)) {
            // for unmatched in M
            v1.forEach(v -> {
                if (isVertexInEdgeList(v, M))
                    levelDFS(g, v1, M, level, visited, v);
            });
            // clear arrays of level and visited
            Arrays.fill(visited, false);
            Arrays.fill(level, 0);
            nbIteration++;
        }
        System.out.println("Matching with " + M.size() + " edge(s)");
        System.out.println("Using " + nbIteration + " iteration(s)");
        return M;
    }

    /**
     * Compute a levelBFS on the given Graph
     *
     * @param g     Graph
     * @param v1    List of Integer
     * @param M     List of Edges
     * @param level int[]
     * @return boolean
     */
    public static boolean levelBFS(Graph g, List<Integer> v1, List<Edge> M, int[] level) {
        Objects.requireNonNull(g);
        Objects.requireNonNull(v1);

        // Create a new queue
        var queue = new ArrayList<Integer>();
        // add the vertex in the queue for each vertex's in V1
        // that is unmatched in M (start of end of the edges)
        v1.forEach(v -> {
            if (isVertexInEdgeList(v, M))
                queue.add(v);
        });
        // create a second Queue
        var newQueue = new ArrayList<Integer>();
        // initialize an array of boolean of size (number of vertices)
        var visited = new boolean[g.numberOfVertices()];
        // fill visited array of false value
        Arrays.fill(visited, false);
        // fill level array of 0 value
        Arrays.fill(level, 0);
        // initialize a data "current level" at 0
        int clvl = 0;
        // while the queue is not empty
        while (!queue.isEmpty()) {
            // for each vertex in the queue
            for (var v : queue) {
                // get an iterator for all Edges of vertex v
                var it = g.edgeIterator(v);
                while (it.hasNext()) {
                    // nextEdge is the next Edge of the vertex v
                    var nextEdge = it.next();
                    // vp is the value of the end of the nextEdge of v
                    var vp = nextEdge.getEnd();
                    // if vertex already visited, exit the forEach loop
                    if (!visited[vp]) {
                        // if clvl is even and List M doesn't contain the Edge vp OR if clvl is odd and List M contains the Edge vp
                        if ((isEven(clvl) && !M.contains(nextEdge)) || (!isEven(clvl) && M.contains(nextEdge.reversedEdge()))) {
                            // add the vertex vp to the 2nd Queue
                            newQueue.add(vp);
                            // marks the vertex vp as visited
                            visited[vp] = true;
                            level[vp] = clvl + 1;
                        }
                    }
                }
            }
            // increment by one the value clvl
            clvl++;
            // clear the queue
            queue.clear();
            // if any vertex in newQueue is unmatched and not in V1, return true
            for (var v : newQueue) {
                if (isVertexInEdgeList(v, M) && !v1.contains(v))
                    return true;
            }
            // swaps the data of queue and NewQueue otherwise
            queue.addAll(newQueue);
            newQueue.clear();
        }
        return false;
    }

    /**
     * Compute a level DFS on the given Graph
     *
     * @param g       Graph
     * @param V1      List of Integer
     * @param M       List of Edges
     * @param level   int []
     * @param visited boolean []
     * @param v       int
     * @return boolean
     */
    public static boolean levelDFS(Graph g, List<Integer> V1, List<Edge> M, int[] level, boolean[] visited, int v) {
        // put the vertex position as "visited" in the array
        visited[v] = true;

        // return true if the vertex is id the List of Edge to return and not in V1
        if (!V1.contains(v) && isVertexInEdgeList(v, M))
            return true;
        // get an iterator for all Edges of vertex v
        var it = g.edgeIterator(v);
        while (it.hasNext()) {
            // nextEdge is the next Edge of the vertex v
            var nextEdge = it.next();
            // vp is the value of the end of the nextEdge of v
            var vp = nextEdge.getEnd();
            // if vertex already visited, exit the forEach loop
            if (!visited[vp]) {
                // if clvl is even and List M doesn't contain the Edge vp OR if clvl is odd and List M contains the Edge vp
                if ((isEven(level[v]) && !M.contains(nextEdge)) || (!isEven(level[v]) && M.contains(nextEdge.reversedEdge()))) {
                    // if recursive DFS returns yes and level of neighbors is equals to level of v + 1
                    if (level[vp] == level[v] + 1 && levelDFS(g, V1, M, level, visited, vp)) {
                        if (isEven(level[v])) {
                            if (M.contains(nextEdge))
                                M.remove(nextEdge);
                            else
                                M.add(nextEdge);
                        } else {
                            if (M.contains(nextEdge.reversedEdge()))
                                M.remove(nextEdge.reversedEdge());
                            else
                                M.add(nextEdge.reversedEdge());
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Return <b>true</b> if <i>v</i> is in the list <i>m</i>,
     * whether <i>v</i> is the start or the end of the Edge
     *
     * @param v int
     * @param M List of Edges
     * @return boolean
     */
    private static boolean isVertexInEdgeList(int v, List<Edge> M) {
        for (var e : M)
            if (e.isVertexInEdge(v))
                return false;
        return true;
    }

    /**
     * Return <b>true</b> if <i>v</i> is even <br>
     * Return <b>false</b> otherwise
     *
     * @param v int
     * @return boolean
     */
    private static boolean isEven(int v) {
        // returns true if last bit from v is equals to 0
        return ((v & 1) == 0);
    }

    /**
     * Create and return a Graph from the given <i>lines</i>
     *
     * @param g     Path
     * @param lines List of String
     * @return Graph
     */
    private static Graph createGraphFromLines(Graph g, List<String> lines) {
        var stringEdges = lines.get(1).split(" ");
        var nbEdges = Integer.parseInt(stringEdges[0]);

        for (int i = 2; i < nbEdges + 2; i++) {
            var strLine = lines.get(i).split(" ");
            var start = Integer.parseInt(strLine[0]);
            var end = Integer.parseInt(strLine[1]) + g.getV1().size();
            g.addEdges(start, end, 0);
        }
        return g;
    }

    /**
     * Create and return a Graph from the given <i>file</i>
     *
     * @param file Path
     * @return Graph
     */
    public static Graph createGraphFromPathFile(Path file) throws IOException {
        Objects.requireNonNull(file);

        var lines = Files.readAllLines(file, StandardCharsets.UTF_8);
        var line = lines.get(0).split(" ");

        var sizeV1 = Integer.parseInt(line[0]);
        var sizeV2 = Integer.parseInt(line[1]);

        var g = new AdjGraph(sizeV1 + sizeV2, sizeV1, sizeV2);
        return createGraphFromLines(g, lines);
    }

    /**
     * Fill <i>M</i> with the value from <i>file</i>
     *
     * @param file Path
     * @param M    List of Edges
     * @return int
     */
    public static int fillEdgesListFromPathFileSol(Path file, List<Edge> M) throws IOException {
        Objects.requireNonNull(file);
        var lines = Files.readAllLines(file, StandardCharsets.UTF_8);
        var nbEdges = Integer.parseInt(lines.get(0));
        for (int i = 1; i < nbEdges + 1; i++) {
            var vertices = lines.get(i).split(" ");
            M.add(new Edge(Integer.parseInt(vertices[0]), Integer.parseInt(vertices[1])));
        }
        return nbEdges;
    }

    /**
     * Create in the given path an output file containing the list of Edge <i>M</i>
     *
     * @param file   Path
     * @param M      List of Edges
     * @param sizeV1 int
     */
    public static void createOutputFile(Path file, List<Edge> M, int sizeV1) throws IOException {
        var strBuilder = new StringBuilder();
        strBuilder.append(M.size()).append("\n");
        for (var e : M)
            strBuilder.append(e.getStart()).append(" ").append(e.getEnd() - sizeV1).append("\n");
        Files.writeString(file, strBuilder.toString());
    }
}
