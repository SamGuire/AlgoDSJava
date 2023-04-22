package datastructures.trie;

public class Client {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("Issamydobey");
        trie.insertWord("Robler");
        System.out.println(trie.wordExist("Robler"));
    }
}
