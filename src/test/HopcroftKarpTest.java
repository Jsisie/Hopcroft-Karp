import fr.upem.esipe.algo.graph.AdjGraph;
import fr.upem.esipe.algo.graph.Edge;
import fr.upem.esipe.algo.graph.Graphs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HopcroftKarpTest {
    @Nested
    public class HopcroftKarpTests {

        @Test
        @Tag("Hopcroft-Karp Test")
        public void emptyTestGraphsDFS() {
            var testGraph = new AdjGraph(5, 1, 1);
            Assertions.assertAll(
                    () -> assertThrows(NullPointerException.class, () -> Graphs.hopcroftKarp(null, List.of(1, 2, 4), List.of(1, 2, 3))),
                    () -> assertThrows(NullPointerException.class, () -> Graphs.hopcroftKarp(testGraph, null, List.of(1, 2, 3))),
                    () -> assertThrows(NullPointerException.class, () -> Graphs.hopcroftKarp(testGraph, List.of(1, 2, 4), null))
            );
        }

        @Test
        void graphTest1() throws IOException {
            AdjGraph graph = (AdjGraph) Graphs.createGraphFromPathFile(Path.of("testcase/graphs/g1.gr"));
            var list = new ArrayList<Edge>();
            var nbEdgeSolution = Graphs.fillEdgesListFromPathFileSol(Path.of("testcase/graphs/g1.sol"), list);
            System.out.println("File g1.gr, solution g1.sol");
            var m = Graphs.hopcroftKarp(graph, graph.getV1(), graph.getV2());
            printOutputGraph(m, graph.getV1().size());
            assertEquals(nbEdgeSolution, m.size());
        }

        @Test
        void graphTest2() throws IOException {
            AdjGraph graph = (AdjGraph) Graphs.createGraphFromPathFile(Path.of("testcase/graphs/g2.gr"));
            var list = new ArrayList<Edge>();
            var nbEdgeSolution = Graphs.fillEdgesListFromPathFileSol(Path.of("testcase/graphs/g2.sol"), list);
            System.out.println("File g2.gr, solution g2.sol");
            var m = Graphs.hopcroftKarp(graph, graph.getV1(), graph.getV2());
            printOutputGraph(m, graph.getV1().size());
            assertEquals(nbEdgeSolution, m.size());
        }

        @Test
        void graphTest3() throws IOException {
            AdjGraph graph = (AdjGraph) Graphs.createGraphFromPathFile(Path.of("testcase/graphs/g3.gr"));
            var list = new ArrayList<Edge>();
            var nbEdgeSolution = Graphs.fillEdgesListFromPathFileSol(Path.of("testcase/graphs/g3.sol"), list);
            System.out.println("File g3.gr, solution g3.sol");
            var m = Graphs.hopcroftKarp(graph, graph.getV1(), graph.getV2());
            printOutputGraph(m, graph.getV1().size());
            assertEquals(nbEdgeSolution, m.size());
        }

        @Test
        void graphTest4() throws IOException {
            AdjGraph graph = (AdjGraph) Graphs.createGraphFromPathFile(Path.of("testcase/graphs/g4.gr"));
            var list = new ArrayList<Edge>();
            var nbEdgeSolution = Graphs.fillEdgesListFromPathFileSol(Path.of("testcase/graphs/g4.sol"), list);
            System.out.println("File g4.gr, solution g4.sol");
            var m = Graphs.hopcroftKarp(graph, graph.getV1(), graph.getV2());
            printOutputGraph(m, graph.getV1().size());
            assertEquals(nbEdgeSolution, m.size());
        }

        @Test
        void graphTest5() throws IOException {
            AdjGraph graph = (AdjGraph) Graphs.createGraphFromPathFile(Path.of("testcase/graphs/g5.gr"));
            var list = new ArrayList<Edge>();
            var nbEdgeSolution = Graphs.fillEdgesListFromPathFileSol(Path.of("testcase/graphs/g5.sol"), list);
            System.out.println("File g5.gr, solution g5.sol");
            var m = Graphs.hopcroftKarp(graph, graph.getV1(), graph.getV2());
            printOutputGraph(m, graph.getV1().size());
            assertEquals(nbEdgeSolution, m.size());
        }

        @Test
        void graphTest6() throws IOException {
            AdjGraph graph = (AdjGraph) Graphs.createGraphFromPathFile(Path.of("testcase/graphs/g6.gr"));
            var list = new ArrayList<Edge>();
            var nbEdgeSolution = Graphs.fillEdgesListFromPathFileSol(Path.of("testcase/graphs/g6.sol"), list);
            System.out.println("File g6.gr, solution g6.sol");
            var m = Graphs.hopcroftKarp(graph, graph.getV1(), graph.getV2());
            printOutputGraph(m, graph.getV1().size());
            assertEquals(nbEdgeSolution, m.size());
        }

        @Test
        void graphTest7() throws IOException {
            AdjGraph graph = (AdjGraph) Graphs.createGraphFromPathFile(Path.of("testcase/graphs/g7.gr"));
            var list = new ArrayList<Edge>();
            var nbEdgeSolution = Graphs.fillEdgesListFromPathFileSol(Path.of("testcase/graphs/g7.sol"), list);
            System.out.println("File g7.gr, solution g7.sol");
            var m = Graphs.hopcroftKarp(graph, graph.getV1(), graph.getV2());
            printOutputGraph(m, graph.getV1().size());
            assertEquals(nbEdgeSolution, m.size());
        }

        @Test
        void graphTest8() throws IOException {
            AdjGraph graph = (AdjGraph) Graphs.createGraphFromPathFile(Path.of("testcase/graphs/g8.gr"));
            var list = new ArrayList<Edge>();
            var nbEdgeSolution = Graphs.fillEdgesListFromPathFileSol(Path.of("testcase/graphs/g8.sol"), list);
            System.out.println("File g8.gr, solution g8.sol");
            var m = Graphs.hopcroftKarp(graph, graph.getV1(), graph.getV2());
            printOutputGraph(m, graph.getV1().size());
            assertEquals(nbEdgeSolution, m.size());
        }

        @Test
        void graphTest9() throws IOException {
            AdjGraph graph = (AdjGraph) Graphs.createGraphFromPathFile(Path.of("testcase/graphs/g9.gr"));
            var list = new ArrayList<Edge>();
            var nbEdgeSolution = Graphs.fillEdgesListFromPathFileSol(Path.of("testcase/graphs/g9.sol"), list);
            System.out.println("File g9.gr, solution g9.sol");
            var m = Graphs.hopcroftKarp(graph, graph.getV1(), graph.getV2());
            printOutputGraph(m, graph.getV1().size());
            assertEquals(nbEdgeSolution, m.size());
        }

        @Test
        void graphTest10() throws IOException {
            AdjGraph graph = (AdjGraph) Graphs.createGraphFromPathFile(Path.of("testcase/graphs/g10.gr"));
            var list = new ArrayList<Edge>();
            var nbEdgeSolution = Graphs.fillEdgesListFromPathFileSol(Path.of("testcase/graphs/g10.sol"), list);
            System.out.println("File g10.gr, solution g10.sol");
            var m = Graphs.hopcroftKarp(graph, graph.getV1(), graph.getV2());
            printOutputGraph(m, graph.getV1().size());
            assertEquals(nbEdgeSolution, m.size());
        }

        @Test
        void graphTest11() throws IOException {
            AdjGraph graph = (AdjGraph) Graphs.createGraphFromPathFile(Path.of("testcase/graphs/g11.gr"));
            var list = new ArrayList<Edge>();
            var nbEdgeSolution = Graphs.fillEdgesListFromPathFileSol(Path.of("testcase/graphs/g11.sol"), list);
            System.out.println("File g11.gr, solution g11.sol");
            var m = Graphs.hopcroftKarp(graph, graph.getV1(), graph.getV2());
            printOutputGraph(m, graph.getV1().size());
            assertEquals(nbEdgeSolution, m.size());
        }

        @Test
        void graphTest12() throws IOException {
            AdjGraph graph = (AdjGraph) Graphs.createGraphFromPathFile(Path.of("testcase/graphs/g12.gr"));
            var list = new ArrayList<Edge>();
            var nbEdgeSolution = Graphs.fillEdgesListFromPathFileSol(Path.of("testcase/graphs/g12.sol"), list);
            System.out.println("File g12.gr, solution g12.sol");
            var m = Graphs.hopcroftKarp(graph, graph.getV1(), graph.getV2());
            printOutputGraph(m, graph.getV1().size());
            assertEquals(nbEdgeSolution, m.size());
        }

        @Test
        void graphTest13() throws IOException {
            AdjGraph graph = (AdjGraph) Graphs.createGraphFromPathFile(Path.of("testcase/graphs/g13.gr"));
            var list = new ArrayList<Edge>();
            var nbEdgeSolution = Graphs.fillEdgesListFromPathFileSol(Path.of("testcase/graphs/g13.sol"), list);
            System.out.println("File g13.gr, solution g13.sol");
            var m = Graphs.hopcroftKarp(graph, graph.getV1(), graph.getV2());
            printOutputGraph(m, graph.getV1().size());
            assertEquals(nbEdgeSolution, m.size());
        }

        @Test
        void graphTest14() throws IOException {
            AdjGraph graph = (AdjGraph) Graphs.createGraphFromPathFile(Path.of("testcase/graphs/g14.gr"));
            var list = new ArrayList<Edge>();
            var nbEdgeSolution = Graphs.fillEdgesListFromPathFileSol(Path.of("testcase/graphs/g14.sol"), list);
            System.out.println("File g14.gr, solution g14.sol");
            var m = Graphs.hopcroftKarp(graph, graph.getV1(), graph.getV2());
            printOutputGraph(m, graph.getV1().size());
            assertEquals(nbEdgeSolution, m.size());
        }

        void printOutputGraph(List<Edge> M, int sizeV1) {
            var strBuilder = new StringBuilder();
            strBuilder.append(M.size()).append("\n");
            for (var e : M)
                strBuilder.append(e.getStart()).append(" ").append(e.getEnd() - sizeV1).append("\n");
            System.out.println(strBuilder);
        }
    }
}
