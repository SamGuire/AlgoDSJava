package datastructures.disjointset;
import java.util.*;
public class DisjointSet {
    private Map<Integer,Integer> setSize = new HashMap<>();
    private Map<Integer,Integer> parent = new HashMap<>();
    public DisjointSet(){}

    public int find(int nodeId){
        int currentId = nodeId;
        while (parent.get(currentId) != currentId) {
            currentId = parent.get(currentId);
        }
        return currentId;
    }

    public void merge(int node1,int node2){
        int parent1 = this.find(node1);
        int parent2 = this.find(node2);
        int size1 = this.setSize.get(parent1);
        int size2 = this.setSize.get(parent2);
        if (this.setSize.get(parent1) > this.setSize.get(parent2)) {
            this.parent.put(parent2,parent1);
            this.setSize.put(parent2,size1+size2);
        } else {
            this.parent.put(parent1,parent2);
            this.setSize.put(parent1,size1+size2);
        }
    }

    public void addNewSet(int newNode){
        if (parent.containsKey(newNode)) return;
        parent.put(newNode,newNode);
        setSize.put(newNode,1);
    }
}
