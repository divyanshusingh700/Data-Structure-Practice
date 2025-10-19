package Oct19_25;
import java.util.*;
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}
class Solution {
    static int canRepresentBST(int arr[], int n) {
        return bstFromPreorder(arr)==true?1:0 ;
    }
    
    static boolean bstFromPreorder(int[] pre) {
        if (pre.length == 0) return true;
        int lowerBound = Integer.MIN_VALUE;
        Node root = new Node(pre[0]);
        Stack<Node> st = new Stack<>();
        st.push(root);
        int prev = root.data;
        for (int i = 1; i < pre.length; i++) {
            while (!st.isEmpty() && pre[i] > st.peek().data) {
                lowerBound = st.pop().data;
            }
            if(pre[i]<lowerBound)return false;
            st.push(new Node(pre[i]));
        }
        return true;
    }
}
