import java.util.*;
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
class GfG {
    int findDist(Node root, int a, int b) {
        // APPROACH >- We have to calculate the minimum distance so 
        // if we do an observation then we will able to find it out 
        // that the minimum distance b/w two nodes will 
        // always come through the lca of these two nodes.
        // So first of all we just find out the lca of both the nodes and then 
        // we find out the distance b/w first node and lca called it 
        // as dist1 and then find out the dist2 from the second node to lca.
        // We now return our min distance answer as the sum of the dist1 + dist2,
        Node ca = lca(root, a, b);
        return bfs(ca,a)+bfs(ca,b);
    }
    Node lca(Node root, int a, int b){
        if(root == null)return root;
        if(root.data == a || root.data==b)return root;
        Node left = lca(root.left, a, b);
        Node right = lca(root.right, a ,b);
        if(left!=null && right!=null)return root;
        
        if(left==null)return right;
        if(right==null)return left;
        return null;
    }
    int bfs(Node root, int k){
        int level = 0; 
        Queue<Node> st = new LinkedList<>();
        st.offer(root);
        while(!st.isEmpty()){
            int n = st.size();
            for(int i=0; i<n; i++){
                Node curr = st.poll();
                if(curr.data == k)return level;
                if(curr.left!=null)st.offer(curr.left);
                if(curr.right!=null)st.offer(curr.right);
            }
            level++;
        }
        return level;
    }
}