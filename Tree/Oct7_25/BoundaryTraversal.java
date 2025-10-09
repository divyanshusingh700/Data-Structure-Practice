package Oct7_25;
import java.util.*;
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = null;
        right = null;
    }
}
class Solution {
    ArrayList<Integer> res = new ArrayList<>();

    ArrayList<Integer> boundaryTraversal(Node root) {
        // Idea is here to just do boundary traversal
        // for left side of node we will just track boundary
        // If we will not have left then we will look for right
        // null case is already handled and we will make sure not add leaves
        // same scenario will go for right boundary traversal just that we will do in bottom up
        // approach because we want in that order itself
        // leaves we can fetch directly
        
        if (root == null) return res;

        if (!isLeaf(root)) res.add(root.data);

        addLeftBoundary(root.left);
        addLeaves(root);
        addRightBoundary(root.right);

        return res;
    }

    boolean isLeaf(Node node) {
        return node != null && node.left == null && node.right == null;
    }

    void addLeftBoundary(Node node) {
        if (node == null || isLeaf(node)) return;
        // Add node during (top-down) recursion
        res.add(node.data);
    
        if (node.left != null) addLeftBoundary(node.left);
        else if(node.right != null) addLeftBoundary(node.right);
    }

    void addRightBoundary(Node node) {
        if (node == null || isLeaf(node)) return;
    
        // Recurse first to go to the bottom-most right boundary
        if (node.right != null) {
            addRightBoundary(node.right);
        } else if (node.left != null) {
            addRightBoundary(node.left);
        }
    
        // Add node after recursion (bottom-up)
        res.add(node.data);
    }
    void addLeaves(Node node) {
        if (node == null) return;
        if (isLeaf(node)) {
            res.add(node.data);
            return;
        }
        addLeaves(node.left);
        addLeaves(node.right);
    }
}
