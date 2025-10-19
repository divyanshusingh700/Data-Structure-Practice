package Oct19_25;
//Given the root of a binary tree. Check whether it is a BST or not.

// A BST is defined as follows:

// The left subtree of a node contains only nodes with data less than the node's data.
// The right subtree of a node contains only nodes with data greater than the node's data.
// Both the left and right subtrees must also be binary search trees.
// Note: We are considering that BSTs can not contain duplicate Nodes.

import java.util.*; 
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }

}

public class SpecialMaxHeapFromBST {
    static List<Integer> postorder = new ArrayList<>();
    public static void convertToMaxHeapUtil(Node root) {
        postorder = new ArrayList<>();
        getInorder(root);
        Collections.reverse(postorder);
        helper(root, 0);
    }
    static void getInorder(Node root){
        if(root==null)return ;
        getInorder(root.left);
        postorder.add(root.data);
        getInorder(root.right);
    }
    
    static int helper(Node root, int idx){
        if(root==null)return idx;
        root.data = postorder.get(idx);
        idx = helper(root.right, idx + 1);
        idx = helper(root.left, idx);
        return idx;
    }
}













