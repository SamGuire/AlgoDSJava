package datastructures.binarysearchtree;

public class Client {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertNode(1);
        bst.insertNode(-1);
        bst.insertNode(10);
        bst.insertNode(0);
        System.out.println(bst);
        System.out.println(bst);
    }
}
