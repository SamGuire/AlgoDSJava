package datastructures.graph;

import java.util.ArrayList;

public interface IGraph<V> {

    void addEdge(V src,V dst);

    void removeEdge(V src, V dst);

    String bfs(V src);
    String dfs(V src);

    ArrayList<Pair<V,V>> getAllEdges();

    ArrayList<V> getAllVertices();

    int numOfConnectedComponents();
}
