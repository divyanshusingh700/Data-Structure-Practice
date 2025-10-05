package Oct5_25;
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
class zigZagTraversal {
    static ArrayList<Integer> zigZagTraversal(Node root) {
        // Key Idea is to just use level order traversal and use 
        // integer array to save revers and normal order of elements
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<Node> st = new LinkedList<>();
        st.offer(root);
        int currLevel = 0;
        while(!st.isEmpty()){
            int n = st.size();
            int[] res = new int[n];
            for(int i=0; i<n; i++){
                Node curr = st.poll();
                if((currLevel&1)!=0){
                    res[n-1-i] = curr.data;
                }else{
                    res[i] = curr.data;
                }
                if(curr.left!=null)st.offer(curr.left);
                if(curr.right!=null)st.offer(curr.right);
            }
            for (int ele : res) {
                ans.add(ele);
            }
            currLevel++;
        }
        return ans;
    }


    // Step by step approach:
        // Initialize a deque dq and push the root of the binary tree into it.
        // Set reverse = false, i.e., we will begin from the front of the deque.
        // While the deque is not empty, repeat the following:
            // Set n = dq.size().
            // If reverse is false, do the following:
                // For n nodes in the deque, pop from the front and push the node's value into result.
                // If the left child exists, push it to the back of the deque.
                // If the right child exists, push it to the back of the deque.
                // After processing the level, set reverse = !reverse.
            // If reverse is true, do the following:
                // For n nodes in the deque, pop from the back and push the node's value into result.
                // If the right child exists, push it to the front of the deque.
                // If the left child exists, push it to the front of the deque.
                // After processing the level, set reverse = !reverse.
    static ArrayList<Integer> zigZagTraversal2(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<Node> dq = new LinkedList<>();
        dq.addLast(root);

        boolean reverse = false;

        while (!dq.isEmpty()) {
            int n = dq.size();

            while (n-- > 0) {
                
                // Push right first if reverse is true
                if (reverse) {
                    Node curr = dq.removeLast();
                    res.add(curr.data);

                    if (curr.right != null) dq.addFirst(curr.right);
                    if (curr.left != null)  dq.addFirst(curr.left);
                }
                
                // Else push left first
                else {
                    Node curr = dq.removeFirst();
                    res.add(curr.data);

                    if (curr.left != null)  dq.addLast(curr.left);
                    if (curr.right != null) dq.addLast(curr.right);
                }
            }

            reverse = !reverse;
        }

        return res;
    }



    public static void main(String[] args) {
        
        // Create a hard coded tree.
        //         20
        //       /   \
        //      8     22
        //    /  \     \
        //   4   12    11
        //      /  \
        //     10   14
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.right.right = new Node(11);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        
        ArrayList<Integer> res = zigZagTraversal(root);
        for (int val : res) System.out.print(val + " ");
        System.out.println();
    }
}
