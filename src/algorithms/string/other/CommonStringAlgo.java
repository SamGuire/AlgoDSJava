package algorithms.string.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class CommonStringAlgo {

    public CommonStringAlgo(){}

    public String longestSubstringWithoutRepeatingCharacter(String text) {
        if (text.length() == 0) {
            return "";
        }

        String longest = "";
        HashMap<Character,Integer> pos = new HashMap<>();
        int leftWindow = 0;
        BiPredicate<Integer,Integer> isUniqueChar = (i, left) -> !pos.containsKey(text.charAt(i)) || pos.get(text.charAt(i)) < left;

        for (int i = 0 ; i < text.length() ; i++) {
            if (!isUniqueChar.test(i,leftWindow)) {
                String candidate = text.substring(leftWindow,i);
                if (candidate.length() > longest.length()) {
                    longest = candidate;
                }
                leftWindow = pos.get(text.charAt(i))+1;
            }
            pos.put(text.charAt(i),i);
        }
        return longest;
    }

    public String longestCommonPrefix(String[] words) {
        Arrays.sort(words);
        String minWord = words[0];
        String  maxWord =  words[words.length-1];
        int i = 0;
        while (i < minWord.length()) {
            if (minWord.charAt(i) != maxWord.charAt(i)) {
                return minWord.substring(0, i);
            }
            i++;
        }
        return minWord;
    }
}
