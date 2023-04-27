package algorithms.greedy.graph;
import datastructures.disjointset.DisjointSet;

import java.util.*;
public class SpanningTreeAlgo {

    public class SpanningTree {
        int cost;
        List<EdgeNode> edges;

        public SpanningTree(){
            this.cost = 0;
            this.edges = new ArrayList<>();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("##### GRAPH #####\n");
            for (EdgeNode edge : this.edges) {
                String s = String.format("( %d, %d, %d )\n",edge.src,edge.dst,edge.weight);
                sb.append(s);
            }
            sb.append(String.format("Cost: %d\n",this.cost));
            return sb.toString();
        }
    }

    private class EdgeNode {
        int src,dst,weight;
        public EdgeNode(int src,int dst,int weight) {
            this.src = src;
            this.dst = dst;
            this.weight =weight;
        }
    }

    private class PrimPQNode {
        int v,cost;
        EdgeNode edge;
        public PrimPQNode(int v,int cost,EdgeNode edge) {
            this.v = v;
            this.cost = cost;
            this.edge = edge;
        }
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
    public SpanningTreeAlgo(){}

    public void sortEdges(int[][] edges, boolean reversed) {
        Arrays.sort(edges,(a,b) -> reversed ? Integer.compare(b[2],a[2]) : Integer.compare(a[2],b[2]));
    }

    public SpanningTree kruskal(int[][] graph, boolean isMin) {
        Set<Integer> vertices = getAllVertices(graph);
        sortEdges(graph,!isMin);
        DisjointSet ds = new DisjointSet();
        SpanningTree spanningTree = new SpanningTree();
        for (int v: vertices) ds.addNewSet(v);
        int v1,v2,cost;
        for (int[] edge : graph) {
            v1 = edge[0]; v2 = edge[1]; cost=edge[2];
            int p1 = ds.find(v1);
            int p2 = ds.find(v2);
            if (p1 != p2) {
                spanningTree.cost += cost;
                spanningTree.edges.add(new EdgeNode(v1,v2,cost));
                ds.merge(p1,p2);
            }
        }

       return spanningTree;
    }

    public SpanningTree prim(int[][] undirectedGraph, boolean isMin) {
        Set<Integer> vertices = getAllVertices(undirectedGraph);
        Map<Integer,List<EdgeNode>> adjList = new HashMap<>();
        for (int v: vertices) adjList.put(v,new ArrayList<>());
        for (int[] edge : undirectedGraph) {
            adjList.get(edge[0]).add(new EdgeNode(edge[0],edge[1],edge[2]));
            adjList.get(edge[1]).add(new EdgeNode(edge[1],edge[0],edge[2]));
        }
        return primHelper(adjList,vertices,isMin);
    }
    private SpanningTree primHelper(Map<Integer,List<EdgeNode>> graph,Set<Integer> vertices,boolean isMin) {

        int randomIdx = (int)(Math.random()*vertices.size());
        SpanningTree spanningTree = new SpanningTree();
        int src = vertices.toArray(new Integer[0])[randomIdx];
        float initialValue = isMin ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY;
        Map<Integer,Float> dstToSpanningTree = new HashMap<>();
        for (int v : vertices) dstToSpanningTree.put(v,initialValue);

        PriorityQueue<PrimPQNode> pq = new PriorityQueue<>((a,b) -> isMin ? Integer.compare(a.cost,b.cost) : Integer.compare(b.cost,a.cost));
        pq.add(new PrimPQNode(src,0,new EdgeNode(src,src,0)));
        while (!pq.isEmpty()) {
            PrimPQNode curNode = pq.poll();

            // already pulled, meaning v is already part of spanning tree
            if (dstToSpanningTree.get(curNode.v) != initialValue) continue;

            dstToSpanningTree.put(curNode.v,(float)curNode.cost);
            spanningTree.cost += curNode.cost;

            // ignore dummy
            if (curNode.v != src) {
                spanningTree.edges.add(curNode.edge);
            }
            for (EdgeNode edge : graph.get(curNode.v)) {
                pq.add(new PrimPQNode(edge.dst, edge.weight,edge));
            }
        }

        return spanningTree;

    }
}
