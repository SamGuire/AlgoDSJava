package datastructures.binarysearchtree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class BinarySearchTree {
    public class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode parent;

        public TreeNode(int v) {
            this.value = v;
        }

        @Override
        public String toString() {
            return String.format("TreeNode with value = %d",value);
        }
    }

    public TreeNode root;
    public BinarySearchTree() {}

    public void insertNode(int v) {
        if (this.root == null) {
            this.root = new TreeNode(v);
            return;
        }

        TreeNode newNode = new TreeNode(v);
        TreeNode currentNode = this.root;
        TreeNode prevNode = null;

        while (currentNode != null) {
            if (currentNode.value > v) {
                prevNode = currentNode;
                currentNode = currentNode.left;
            } else if (currentNode.value < v) {
                prevNode = currentNode;
                currentNode = currentNode.right;
            } else {
                return;
            }
        }

        if (prevNode.value > v) {
            prevNode.left = newNode;
        } else {
            prevNode.right = newNode;
        }

        newNode.parent = prevNode;

    }

    public boolean exist(int v) {
        if (this.root == null) {
            return false;
        }
        TreeNode currentNode = this.root;
        while (currentNode != null) {
            if (currentNode.value == v) {
                return true;
            } else if (currentNode.value > v) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return false;
    }

    public void delete(int v) {
        this.root = this.deleteHelper(this.root,v);
    }

    private TreeNode deleteHelper(TreeNode startNode,int target) {
        if (startNode == null) {
            return null;
        }
        if (startNode.value > target) {
            startNode.left = this.deleteHelper(startNode.left,target);
            return startNode;
        } else if (startNode.value < target) {
            startNode.right = this.deleteHelper(startNode.right,target);
            return startNode;
        } else {
            if (startNode.left == null) {
                return startNode.right;
            } else if (startNode.right == null) {
                return startNode.left;
            } else {
                TreeNode successor = this.getSuccessor(startNode);
                startNode.value = successor.value;
                startNode.right = this.deleteHelper(startNode.right,successor.value);
                return startNode;
            }
        }

    }

    public TreeNode getNode(int v) {
        if (this.root == null) {
            return null;
        }
        TreeNode currentNode = this.root;
        while (currentNode != null) {
            if (currentNode.value == v) {
                return currentNode;
            } else if (currentNode.value > v) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return null;
    }

    public TreeNode getMin(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode currentNode = node;
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    public TreeNode getMax(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode currentNode = node;
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }
        return currentNode;
    }

    public TreeNode getSuccessor(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return this.getMin(node.right);
        } else {
            TreeNode currentNode = node;
            TreeNode parent = node.parent;
            while (parent != null && parent.left != currentNode) {
                currentNode = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    public TreeNode getPredecessor(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            return this.getMax(node.left);
        } else {
            TreeNode currentNode = node;
            TreeNode parent = node.parent;
            while (parent != null && parent.right != currentNode) {
                currentNode = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    public ArrayList<Integer> inorder() {
        ArrayList<Integer> inorderValues = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = this.root;
        while (currentNode != null || !stack.empty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            TreeNode tmp = stack.pop();
            inorderValues.add(tmp.value);
            currentNode = tmp.right;
        }
        return inorderValues;
    }

    public ArrayList<Integer> preorder() {
        if (this.root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> preorderValue = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(this.root);
        while (!stack.empty()) {
            TreeNode tmp = stack.pop();
            preorderValue.add(tmp.value);
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null){
                stack.push(tmp.left);
            }
        }
        return preorderValue;
    }

    public ArrayList<Integer> postorder() {
        if (this.root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> postorderValues = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(this.root);
        while (!stack.empty()) {
            TreeNode tmp = stack.pop();
            postorderValues.add(tmp.value);
            if (tmp.left != null) {
                stack.push(tmp.right);
            }
            if (tmp.right != null){
                stack.push(tmp.left);
            }
        }
        Collections.reverse(postorderValues);
        return postorderValues;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> tree = this.inorder();
        sb.append("BST: ");
        for (int v : tree) {
            sb.append(v);
            sb.append(" ");
        }
        return sb.toString();
    }
}
