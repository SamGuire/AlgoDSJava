package datastructures.graph;

import java.util.*;

public class GraphAdjancyList implements  IGraph<Integer> {

    public HashMap<Integer, HashSet<Integer>> edges;

    public GraphAdjancyList() {
        this.edges = new HashMap<>();
    }

    @Override
    public void addEdge(Integer src, Integer dst) {
        if (!edges.containsKey(src)) {
            edges.put(src,new HashSet<Integer>());
        }
        if (!edges.containsKey(dst)) {
            edges.put(dst,new HashSet<>());
        }
        edges.get(src).add(dst);
        edges.get(dst).add(src);
    }

    @Override
    public void removeEdge(Integer src, Integer dst) {
        if (edges.containsKey(src)) {
            edges.get(src).remove(dst);
        }
        if (edges.containsKey(dst)) {
            edges.get(dst).remove(src);
        }

    }

    @Override
    public String bfs(Integer src) {
        StringBuilder sb = new StringBuilder();
        if (!edges.containsKey(src)) {
            return sb.toString();
        }
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(src);
        visited.add(src);

        while (!queue.isEmpty()) {
            Integer currentVertex = queue.poll();
            sb.append(currentVertex);
            sb.append(" ");
            for (Integer adj : edges.get(currentVertex)) {
                if (!visited.contains(adj)) {
                    queue.add(adj);
                    visited.add(adj);
                }
            }
        }
        return sb.toString();
    }

    @Override
    public String dfs(Integer src) {
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> visited = new HashSet<>();
        this.dfsHelper(src,visited,sb);
        return sb.toString();
    }

    private void dfsHelper(Integer src,HashSet<Integer> visited, StringBuilder path) {
        if (visited.contains(src)) {
            return;
        }
        path.append(src);
        path.append(" ");
        visited.add(src);
        for (Integer adj : this.edges.get(src)) {
            dfsHelper(adj,visited,path);
        }
    }

    @Override
    public ArrayList<Pair<Integer, Integer>> getAllEdges() {
        return null;
    }

    @Override
    public ArrayList<Integer> getAllVertices() {
        return null;
    }

    @Override
    public int numOfConnectedComponents() {
        int connectedComponents = 0;
        HashSet<Integer> visited = new HashSet<>();
        for (Integer vertex : edges.keySet()) {
            if (!visited.contains(vertex)) {
                this.bfsComponents(vertex,visited);
                connectedComponents++;
            }
        }
        return connectedComponents;
    }

    private void bfsComponents(Integer src,HashSet<Integer> visited) {
        if (!edges.containsKey(src)) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited.add(src);

        while (!queue.isEmpty()) {
            Integer currentVertex = queue.poll();
            for (Integer adj : edges.get(currentVertex)) {
                if (!visited.contains(adj)) {
                    queue.add(adj);
                    visited.add(adj);
                }
            }
        }
    }

}
