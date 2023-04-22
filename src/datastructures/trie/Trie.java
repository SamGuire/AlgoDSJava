package datastructures.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Trie {

    private class TrieNode {
        public boolean isFinishedWord;
        public HashMap<Character,TrieNode> nodes;

        public TrieNode() {
            nodes = new HashMap<>();
            this.isFinishedWord = false;
        }


    }

    private TrieNode root;
    public Trie() {
        this.root = new TrieNode();

    }

    public void insertWord(String word) {
        char[] chars = word.toCharArray();
        TrieNode currentNode = this.root;
        for (char c : chars) {
            if (!currentNode.nodes.containsKey(c)) {
                currentNode.nodes.put(c,new TrieNode());
            }
            currentNode = currentNode.nodes.get(c);
        }
        currentNode.isFinishedWord = true;
    }

    public boolean prefixExist(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode currentNode = this.root;
        for (char c : chars) {
            if (!currentNode.nodes.containsKey(c)) {
                return false;
            }
            currentNode = currentNode.nodes.get(c);
        }
        return true;
    }

    public boolean wordExist(String word) {
        char[] chars = word.toCharArray();
        TrieNode currentNode = this.root;
        for (char c : chars) {
            if (!currentNode.nodes.containsKey(c)) {
                return false;
            }
            currentNode = currentNode.nodes.get(c);
        }
        return currentNode.isFinishedWord;
    }

}
