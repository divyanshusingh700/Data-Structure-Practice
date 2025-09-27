package Sep25_25;

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
class InOrderTree {
    static ArrayList<Integer> inOrder(Node root) {
        // Will definitely go left until we hit null
        // will meanwhile push into stack the left ones
        // after getting out from while loop
        // pop element and enter popped one in result
        // add now right into stack
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while(curr!=null || !st.isEmpty()){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            if(curr == null){
                curr = st.pop();
                res.add(curr.data);
                curr = curr.right;
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

        ArrayList<Integer> inOrderList = inOrder(root);
        for (int it : inOrderList)
            System.out.print(it + " ");
    }
}