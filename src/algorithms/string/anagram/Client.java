package algorithms.string.anagram;

import algorithms.string.anagram.AnagramAlgo;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        AnagramAlgo algo = new AnagramAlgo();
        System.out.println(algo.isAnagram("Issam","sasIm"));
        System.out.println(Arrays.toString(algo.groupAnagram(new String[]{"eat","tea","tan","ate","nat","bat"}).toArray()));
    }
}
