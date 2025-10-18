package Oct18_25;

import java.util.*;
class Node{
    Node left;
    Node right;
    int data;
    Node(Node left, Node right, int data){
        this.left = null;
        this.right=null;
        this.data = data;
    }
}
class BurningTree {
    public int minTime(Node root, int target) {
        // First map parent in hashmap
        Map<Node, Node> mp = new HashMap<>();
        Node start = mapParent(root, target, mp);
        return bfsBurn(start, mp);
        
    }
    public Node mapParent(Node root, int target, Map<Node, Node> mp){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Node res= new Node(-1);
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp.data == target)res = temp;
            if(temp.left!=null){
                if(!mp.containsKey(temp.left)){
                    mp.put(temp.left, temp);
                }
                q.offer(temp.left);
            }
            if(temp.right!=null){
                if(!mp.containsKey(temp.right)){
                    mp.put(temp.right, temp);
                }
                q.offer(temp.right);
            }
        }
        return res;
    }
    
    public int bfsBurn(Node root, Map<Node, Node> parent){
        int minTime = 0;
        Map<Node, Integer> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        // if(!visited.containsKey(root)){
        visited.put(root, 1);
        // }
        while(!q.isEmpty()){
            int size = q.size();
            int f = 0;
            for(int i=0; i<size; i++){
                Node temp = q.poll();
                if(temp.left!=null && visited.get(temp.left)==null){
                    visited.put(temp.left, 1);
                    f=1;
                    q.offer(temp.left);
                }
                if(temp.right!=null && visited.get(temp.right)==null){
                    visited.put(temp.right, 1);
                    f=1;
                    q.offer(temp.right);
                }
                if(parent.get(temp)!=null && visited.get(parent.get(temp)) == null){
                    visited.put(parent.get(temp), 1);
                    f=1;
                    q.offer(parent.get(temp));
                }
            }
            if(f==1){
                minTime++;
            }
        }
        return minTime;
    }

}







