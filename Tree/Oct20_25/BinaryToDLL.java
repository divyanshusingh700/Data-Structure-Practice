
class Node {
    int data;
    Node left, right;

    Node() {
        this.data = 0;
        this.left = this.right = null;
    }

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class Solution {
    Node head = null;
    Node prev = null;
    Node bToDLL(Node root) {
        helper(root);
        return head;
    }
    void helper(Node root){
        if(root == null)return ;
        helper(root.left);
        if(prev == null)head = root;
        else{
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        helper(root.right);
    }
}