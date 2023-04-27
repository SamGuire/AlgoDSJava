package algorithms.graph;
import java.util.*;
public class GraphAlgo {

    public GraphAlgo() {}

    public List<Integer> topSort(int[][] graph) {
        return null;
    }

    private Set<Integer> getAllVertices (int[][] graph) {
        int v1,v2;
        Set<Integer> vertices = new HashSet<>();
        for (int[] edge : graph) {
            v1= edge[0]; v2 = edge[1];
            vertices.add(v1);
            vertices.add(v2);
        }
        return vertices;
    }

    private void addIncomingEdge(Map<Integer,Set<Integer>> incomingEdges,int dst, int src) {
        if (!incomingEdges.containsKey(dst)) {
            incomingEdges.put(dst,new HashSet<>());
        }
        incomingEdges.get(dst).add(src);
    }

    private void addOutgoingEdge(Map<Integer,Set<Integer>> outgoingEdges,int src, int dst) {
        if (!outgoingEdges.containsKey(src)) {
            outgoingEdges.put(src,new HashSet<>());
        }
        outgoingEdges.get(src).add(dst);
    }
    private List<Integer> bfsTopSort(int[][] graph) {
        Set<Integer> vertices = getAllVertices(graph);
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer,Set<Integer>> incomingEdges = new HashMap<>();
        HashMap<Integer,Set<Integer>> outgoingEdges = new HashMap<>();
        List<Integer> topSortedGraph = new ArrayList<>();

        // Initialize both edge maps
        for (int v: vertices) {
            incomingEdges.put(v,new HashSet<>());
            outgoingEdges.put(v,new HashSet<>());
        }

        int src,dst;
        for (int[] edge : graph) {
            src= edge[0]; dst = edge[1];
            addIncomingEdge(incomingEdges,dst,src);
            addOutgoingEdge(outgoingEdges,src,dst);

        }

        // Initialize initial queue which contains vertices with no incoming edges
        for (int v : incomingEdges.keySet()) {
            int numOfIncomingEdges = incomingEdges.get(v).size();
            if (numOfIncomingEdges == 0) {
                queue.add(v);
            }
        }

        int n , curVertex, curNumOfIncomingEdges;
        while (!queue.isEmpty()) {
            n = queue.size();
            for (int i = 0 ; i < n; i++) {
                curVertex = queue.poll();
                for (int adj : outgoingEdges.get(curVertex)) {
                    incomingEdges.get(adj).remove(curVertex);
                    curNumOfIncomingEdges = incomingEdges.get(adj).size();
                    if (curNumOfIncomingEdges == 0) {
                        queue.add(adj);
                    }
                }
                topSortedGraph.add(curVertex);
            }
        }
        return topSortedGraph;
    }

    private boolean dfsContainsCycle(Map<Integer,Set<Integer>> edges, int src, Set<Integer> visited, Set<Integer> inProcess) {
        visited.add(src);
        inProcess.add(src);
        boolean foundCycle = false;
        for (int adj : edges.get(src)) {
            if (inProcess.contains(adj)) {
                return true;
            } else if (!visited.contains(adj)){
                foundCycle = dfsContainsCycle(edges,adj,visited,inProcess);
                if (foundCycle) return true;
            }
        }
        inProcess.remove(src);
        return false;
    }
    public boolean containsCycle(int[][] graph) {
        Set<Integer> vertices = getAllVertices(graph);
        Map<Integer,Set<Integer>>  edges = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for (int v: vertices) edges.put(v,new HashSet<>());
        for (int[] edge: graph) edges.get(edge[0]).add(edge[1]);

        boolean foundCycle = false;
        for (int v: edges.keySet()) {
            if (!visited.contains(v)) {
                foundCycle = dfsContainsCycle(edges,v,visited,new HashSet<>());
                if (foundCycle) return true;
            }
        }
        return false;
    }

    public void transpose(int[][] graph) {
        for (int[] edge: graph) {
            int tmp = edge[0];
            edge[0] = edge[1];
            edge[1] = tmp;
        }
    }

    public boolean isStronglyConnected(int[][] graph) {
        Set<Integer> vertices = getAllVertices(graph);
        Integer[] verticesArray = vertices.toArray(new Integer[0]);

        int randomIdx = (int)(Math.random()* vertices.size());

        int src = verticesArray[randomIdx];
        boolean canReachAllOtherVertices = canReachAll(graph,src);
        transpose(graph);
        boolean allOtherVerticesCanReachThis = canReachAll(graph,src);

        // to bring back to initial graph
        transpose(graph);

        return canReachAllOtherVertices && allOtherVerticesCanReachThis;

    }

    public boolean isBipartite(int[][] graph,int src) {
        int frm,to;
        Map<Integer,Set<Integer>> edges = new HashMap<>();

        Set<Integer> vertices = getAllVertices(graph);
        for (int v: vertices) {
            edges.put(v,new HashSet<>());
        }
        for (int[] edge: graph) {
            frm = edge[0]; to = edge[1];
            edges.get(frm).add(to);
        }

        return bfsBipartiteChecker(src,edges);
    }

    private boolean bfsBipartiteChecker(int src,Map<Integer,Set<Integer>> edges) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer,Set<Integer>> bfsLevel = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(src);
        queue.add(src);

        int curLevel = 0;
        int queueSize;
        while (!queue.isEmpty()) {
            queueSize = queue.size();
            if (!bfsLevel.containsKey(curLevel)) {
                bfsLevel.put(curLevel,new HashSet<>());
            }
            for (int i = 0; i < queueSize ; i++) {
                int curVertex = queue.poll();
                bfsLevel.get(curLevel).add(curVertex);
                for (int adjVertex : edges.get(curVertex)) {
                    boolean isSameLevel = bfsLevel.get(curLevel).contains(adjVertex) && bfsLevel.get(curLevel).contains(curVertex);
                    if (isSameLevel) {
                        return false ;
                    } else if (!visited.contains(adjVertex)) {
                        queue.add(adjVertex);
                        visited.add(adjVertex);
                    }
                }
            }
            curLevel++;
        }
        return true;
    }

    public boolean canReachAll(int[][] graph, int src) {
        Set<Integer> vertices = getAllVertices(graph);
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        HashMap<Integer,Set<Integer>> edges = new HashMap<>();
        for (int v : vertices ) edges.put(v,new HashSet<>());
        for (int[] edge : graph) edges.get(edge[0]).add(edge[1]);

        queue.add(src);
        visited.add(src);

        int n,curVertex;
        while (!queue.isEmpty()) {
            n = queue.size();
            for (int i = 0; i < n; i++) {
                curVertex = queue.poll();
                for (int adj: edges.get(curVertex)) {
                    if (!visited.contains(adj)) {
                        queue.add(adj);
                        visited.add(adj);
                    }
                }
            }
        }
        return visited.size() == vertices.size();

    }

    private void bfsConnectedComponents(int src,Map<Integer,Set<Integer>> edges,Set<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited.add(src);
        queue.add(src);
        while (!queue.isEmpty()) {
            int curVertex = queue.poll();
            for (int adj : edges.get(curVertex)) {
                if (!visited.contains(adj)) {
                    queue.add(adj);
                    visited.add(adj);
                }
            }
        }
    }

    public int numOfConnectedComponents(int[][] graph) {
        Map<Integer,Set<Integer>> edges = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int connectedComponents = 0;
        int v1,v2;
        for (int[] edge : graph) {
            v1 = edge[0]; v2 = edge[1];
            if (!edges.containsKey(v1)) {
                edges.put(v1,new HashSet<>());
            }
            if (!edges.containsKey(v2)) {
                edges.put(v2,new HashSet<>());
            }
            edges.get(v1).add(v2);
            edges.get(v2).add(v1);
        }
        for (int v : edges.keySet()) {
            if (!visited.contains(v)) {
                bfsConnectedComponents(v,edges,visited);
                connectedComponents++;
            }
        }
        return connectedComponents;

    }
}
