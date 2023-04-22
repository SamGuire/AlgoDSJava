package algorithms.sorting;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        SortingAlgo algo = new SortingAlgo();
        int[] a = new int[]{5,4,1,2,-1};
        algo.mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
