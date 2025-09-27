package Sep26_25;

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
class PreOrderTree {
    static ArrayList<Integer> preOrder(Node root) {
        // Will go again Left traversal using while loop until we face null
        // Add curr element in result in while loop because as per root, left, right(root goes first)
        // After while we just pop 1 element and push 1 right element 
        // loop it over
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while(curr!=null || !st.isEmpty()){
            while(curr != null){
                st.push(curr);
                res.add(curr.data);
                curr = curr.left;
            }
            curr = st.pop();
            curr = curr.right;
        }
        return res;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        ArrayList<Integer> postOrderList = preOrder(root);
        for (int it : postOrderList)
            System.out.print(it + " ");
    }
}