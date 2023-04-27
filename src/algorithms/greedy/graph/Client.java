package algorithms.greedy.graph;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        int[][] undirectedGraph = {
                {1,2,1},
                {1,3,4},
                {1,4,3},
                {2,4,2},
                {3,4,5}

        };
        SpanningTreeAlgo algo = new SpanningTreeAlgo();
        SpanningTreeAlgo.SpanningTree tree = algo.prim(undirectedGraph,true);
        System.out.println(tree);
        tree = algo.kruskal(undirectedGraph,true);
        System.out.println(tree);
    }
}
