package algorithms.graph;

public class Client {
    public static void main(String[] args) {
        GraphAlgo algo = new GraphAlgo();
        int[][] graph = {
                {1, 2},
                {1, 3},
                {2,1}
        };

        System.out.println(algo.containsCycle(graph));
    }
}
