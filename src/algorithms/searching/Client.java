package algorithms.searching;
import java.util.*;
public class Client {
    public static void main(String[] args){
        SearchAlgo algo = new SearchAlgo();
        int[] a = new int[20];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random()*10);
        }
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(algo.binarySearch(a,3));
        System.out.println(algo.prevNumber(a,3));
        System.out.println(Arrays.toString(algo.bounds(a,3)));
    }
}
