package algorithms.combinatorics;


import java.util.*;

public class Client {

    public static void main(String[] args) {
        Combinatorics algo = new Combinatorics();
        int[] a = new int[]{1,2,2,3};
        List<List<Integer>> combs = algo.combinations(a);
        List<List<Integer>> perm = algo.permutations(a);
        perm.forEach((l) -> System.out.println(Arrays.toString(l.toArray())));

    }
}
