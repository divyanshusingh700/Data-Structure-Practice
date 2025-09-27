package Sep27_25;

// https://www.geeksforgeeks.org/problems/postorder-traversal-iterative/1?page=1&sortBy=submissions
// User function Template for Java
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
class Pair{
    Node node;
    boolean visited;
    Pair(Node node, boolean visited){
        this.node = node;
        this.visited = visited;
    }
}
class PostOrderTree {
    static ArrayList<Integer> postOrder(Node node) {
        // The idea was use to left node traversal always
        // Use pair(Node node, Boolean visited) 
        // fill the stack opposite of (left, right, root) 
        // If we pop initially then we must process right and left node for popped node
        // it also means that popped node will be pushed with visited true
        // if the visited is true then we will add it to answer list
        // continue pop and make visited true
        //base check if popped node is null
        ArrayList<Integer> res = new ArrayList<>();
        if (node == null) return res;
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, false));
        while(!st.isEmpty()){
            Pair curr = st.pop();
            if(curr.visited){
                res.add(curr.node.data);
            }else{
                st.push(new Pair(curr.node, true));
                if(curr.node.right != null)st.push(new Pair(curr.node.right, false));
                if(curr.node.left != null)st.push(new Pair(curr.node.left, false));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        ArrayList<Integer> postOrderList = postOrder(root);
        for (int it : postOrderList)
            System.out.print(it + " ");
    }
}