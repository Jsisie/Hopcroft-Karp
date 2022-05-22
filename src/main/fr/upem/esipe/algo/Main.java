package fr.upem.esipe.algo;

import fr.upem.esipe.algo.graph.AdjGraph;
import fr.upem.esipe.algo.graph.Graphs;

import java.io.IOException;
import java.nio.file.Path;

public class Main {

    /**
     * Main method of the algorithm "Hopcroft-Karp" <br>
     * Takes the path+name of the file in parameter
     *
     * @param args String []
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("ERROR: The name of the file should be passed in argument");
            return;
        }

        // get and print name of the given file and the ouput file with the solution
        var path = Path.of(args[0]);
        var inputFileName = path.getFileName().toString();
        var outputFileName = inputFileName.substring(0, inputFileName.length() - 2) + "sol";
        System.out.println("File " + inputFileName + ", solution " + outputFileName);

        // generate the graph from the file and execute the algorithm on it
        AdjGraph graph = (AdjGraph) Graphs.createGraphFromPathFile(Path.of(args[0]));
        var M = Graphs.hopcroftKarp(graph, graph.getV1(), graph.getV2());

        //create the output file with the same path as the given file
        var pathName = path.toString().substring(0, path.toString().length() - 5) + outputFileName;
        Graphs.createOutputFile(Path.of(pathName), M, graph.getV1().size());
    }
}
