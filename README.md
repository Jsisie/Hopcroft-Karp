# Hopcroft-Karp Algorithm
by : Léo Barroux - INFO2 - Gr.1


## Intro :

The main method processing the algorithm is in the file Graphs.java, and is implemented at the top of the file.
The file Graphs.java also contains the two algorithms levelBFS and levelDFS, and some others methods.
All these methods are tested in the file HopcroftKarpTest.java
The methods created for the previous TPs in AdjGraph, Graphs and Edge useless for this algorithm have all been removed.


## I/O Files :

There are two type of files used in this project, ".gr" and ".sol".
The ".gr" files are the files put in entrance of the program, the type of file provided by the user.
The ".sol" files are the one in exit of the program, containing one of the best solution to the provided file.
The program does not accept other types of file than ".gr".


## How to use the program ?

To use it, you need to launch the program with the ".gr" file as the only parameter.
The ".sol" file with the solution will be place in the same directory as the ".gr" file, given in parameter.

example of used with 'g1.gr' file :
"java -classpath .\out\production\Hopcroft_Karp fr.upem.esipe.algo.Main testcase/graphs/g1.gr"

Notes that it's easier to use the program in an IDE such as IntelliJ IDEA, but it's obviously not required.


## Mean times :

Here's the mean time processed for some graphs example :
(the mean time has been processed on 10 launches of the program)

g1.gr : 15.1 ms
g14.gr : 14.5 s
g15.gr : 14.7 s
