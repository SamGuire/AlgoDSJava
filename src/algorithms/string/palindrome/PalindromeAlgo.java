package algorithms.string.palindrome;

import java.util.ArrayList;
import java.util.List;

public class PalindromeAlgo {

    public PalindromeAlgo(){}

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public String longestPalindrome(String text) {
        String longestPalindrome = "";
        for (int i = 0 ; i < text.length(); i++) {
            String candidate1 = expandFromMiddle(text,i,i);
            String candidate2 = expandFromMiddle(text,i,i+1);
            if (longestPalindrome.length() < candidate1.length()) {
                longestPalindrome = candidate1;
            }
            if (longestPalindrome.length() < candidate2.length()) {
                longestPalindrome = candidate2;
            }
        }
        return longestPalindrome;
    }

    private String expandFromMiddle(String s,int mid1,int mid2) {
        while (mid1 >= 0 && mid2 < s.length() && s.charAt(mid1) == s.charAt(mid2)) {
            mid1--;
            mid2++;
        }
        mid1++;
        mid2--;
        return s.substring(mid1,mid2+1);
    }

    public List<List<String>> palindromePartition(String text) {
        if (text.length() == 0) {
            return new ArrayList<>();
        }
        List<List<String>> solutions = new ArrayList<>();
        dfsHelper(text,0,new ArrayList<>(),solutions);
        return solutions;
    }

    private void dfsHelper(String text,int leftWindow,List<String> partitions,List<List<String>> solutions) {
        if (leftWindow >= text.length()) {
            solutions.add(new ArrayList<>(partitions));
            return;
        }
        for (int i = leftWindow; i < text.length(); i++) {
            String candidate = text.substring(0,i+1);
            if (isPalindrome(candidate)) {
                partitions.add(candidate);
                dfsHelper(text,leftWindow+1,partitions,solutions);
                partitions.remove(partitions.size()-1);
            }
        }
    }
}
