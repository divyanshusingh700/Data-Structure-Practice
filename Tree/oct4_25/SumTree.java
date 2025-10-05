/*
Given a Binary Tree. Check for the Sum Tree for every node except the leaf node. Return true if it is a Sum Tree otherwise, return false.
A SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes present in its left subtree and right subtree. 
An empty tree is also a Sum Tree as the sum of an empty tree can be considered to be 0. A leaf node is also considered a Sum Tree.
*/
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
    boolean ans = true;
    boolean isSumTree(Node root) {
        // Idea is to keep global variable to track if every node
        // is following the sum tree or not
        // helper function will return the sum of left and right subtree
        // data values and at the end it will return root +left+right value
        // Maintaining another variable will make the calculation top - down
        // but here we need to calculate for each node and if any node will 
        // not follow we will get answer as false
        helper(root);
        return ans;
    }
    int helper(Node root){
        if(root== null)return 0;
        if(root.left==null && root.right == null)return root.data;

        int left = helper(root.left);
        int right = helper(root.right);
        if(left+right != root.data)ans = false;
        return left+right+root.data;
    }
}