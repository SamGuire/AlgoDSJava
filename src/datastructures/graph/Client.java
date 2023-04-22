package datastructures.graph;

public class Client {

    public static void main(String[] args) {
        IGraph<Integer> graph = new GraphAdjancyList();
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(4,5);
        System.out.println(graph.dfs(1));
    }
}
