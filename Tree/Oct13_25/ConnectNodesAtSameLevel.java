package Oct13_25;

import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node nextRight;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
        nextRight = null;
    }
}

public class ConnectNodesAtSameLevel {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList();
        q.offer(root);
        Node prev;
        while(!q.isEmpty()){
            int n = q.size();
            prev = null;
            for(int i=0; i<n; i++){
                Node node = q.poll();
                if(node.left!=null){
                    if(prev!=null)prev.nextRight = node.left;
                    prev = node.left;
                    q.offer(node.left);
                }
                if(node.right!=null){
                    if(prev!=null)prev.nextRight = node.right;
                    prev = node.right;
                    q.offer(node.right);
                }
            }
        }
        return root;
    }
}