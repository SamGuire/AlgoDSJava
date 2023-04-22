package algorithms.string.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnagramAlgo {

    public AnagramAlgo(){}

    public boolean isAnagram(String s1,String s2) {
        if (s2.length() != s1.length()) {
            return false;
        }
        HashMap<Character,Integer> counter = new HashMap<>();
        for (char c : s1.toCharArray()) {
            counter.put(c,counter.getOrDefault(c,0)+1);
        }
        for (char c: s2.toCharArray()) {
            counter.put(c,counter.getOrDefault(c,0)-1);
        }
        for (char k : counter.keySet()) {
            if (counter.get(k) != 0)  {
                return false;
            }
        }
        return true;
    }

    public List<ArrayList<String>> groupAnagram(String[] words) {
        HashMap<String,ArrayList<String>> groups = new HashMap<>();
        for (String s : words) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!groups.containsKey(key)) {
                groups.put(key,new ArrayList<>());
            }
            groups.get(key).add(s);
        }
        return new ArrayList<>(groups.values());
    }
}
