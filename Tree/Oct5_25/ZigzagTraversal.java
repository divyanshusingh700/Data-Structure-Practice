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
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        ArrayList<Integer> postOrderList = zigZagTraversal(root);
        for (int it : postOrderList)
            System.out.print(it + " ");
    }
}
