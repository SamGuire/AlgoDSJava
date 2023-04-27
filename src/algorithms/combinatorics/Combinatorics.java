package algorithms.combinatorics;
import java.util.*;
public class Combinatorics {
    public Combinatorics(){}

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] =a[j];
        a[j] = tmp;
    }

    private void swap(List<Integer> a, int i, int j) {
        int tmp = a.get(i);
        a.set(i,a.get(j));
        a.set(j,tmp);
    }

    private void dfsPerm(int[] a, HashMap<Integer,Integer> counter, List<Integer> candidate, List<List<Integer>> solutions) {
        if (candidate.size() == a.length) {
            solutions.add(new ArrayList<>(candidate));
            return;
        }
        for (int k: counter.keySet()) {
            if (counter.get(k) != 0) {
                candidate.add(k);
                counter.put(k,counter.get(k)-1);
                dfsPerm(a,counter,candidate,solutions);
                candidate.remove(candidate.size()-1);
                counter.put(k,counter.get(k)+1);
            }
        }
    }
    private void dfsComb(int[] a, int i, List<Integer> candidate, List<List<Integer>> solutions) {
        solutions.add(new ArrayList<>(candidate));
        for (int j = i ; j < a.length; j++) {
            if (j != i && a[j] == a[j-1]) continue;
            candidate.add(a[j]);
            dfsComb(a,j+1,candidate,solutions);
            candidate.remove(candidate.size()-1);
        }
    }
    public List<List<Integer>> combinations(int[] a) {
        List<List<Integer>> solutions = new ArrayList<>();
        dfsComb(a,0,new ArrayList<>(),solutions);
        return solutions;
    }

    public List<List<Integer>> permutations(int[] a) {
        List<List<Integer>> solutions = new ArrayList<>();
        HashMap<Integer,Integer> counter = new HashMap<>();
        for (int v: a) counter.put(v,counter.getOrDefault(v,0)+1);
        dfsPerm(a,counter,new ArrayList<>(),solutions);
        return solutions;
    }
}
