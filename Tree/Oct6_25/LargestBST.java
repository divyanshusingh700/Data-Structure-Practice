package Oct6_25;
/**
 * Given a binary tree, find size of largest binary search subtree in this
 * binary tree.
 * 
 * Traverse tree in post order fashion. Left and right nodes return 4 piece
 * of information to root which isBST, size of max BST, min and max in those
 * subtree. 
 * If both left and right subtree are BST and this node data is greater than max
 * of left and less than min of right then it returns to above level left size +
 * right size + 1 and new min will be min of left side and new max will be max of
 * right side.
 */
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
class LargestBST {
    static class Info {
        int size;   // size of subtree
        int min;    // min value in subtree
        int max;    // max value in subtree
        boolean isBst;

        Info(int size, int min, int max, boolean isBst) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBst = isBst;
        }
    }
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        return helper(root).size;
    }
    static Info helper(Node root){
        if(root == null)return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        Info left = helper(root.left);
        Info right = helper(root.right);
        if(left.isBst && right.isBst && root.data>left.max && root.data<right.min){
            int size = left.size+right.size+1;
            return new Info(size, Math.min(left.min, root.data), Math.max(right.max, root.data), true);
        }
        return new Info(Math.max(left.size, right.size),0,0, false);
    }
}
