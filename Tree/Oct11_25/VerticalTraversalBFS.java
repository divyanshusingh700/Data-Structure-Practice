package Oct11_25;
import java.util.*;
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
class Pair{
    Node node;
    int level;
    Pair(Node node, int level){
        this.node = node;
        this.level = level;
    }
}

class Solution {
    
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        // idea is here we wanted sorted in level order along with vertical order
        // so if we just have to print vertical order in any order we could have use DFS
        // but here we need data in ascending level order
        // so instead sorting the resultant map
        // just traverse in level order we will autmatically get sorted level order data
        // TC goes to O(n) Let n = number of nodes, k = number of vertical columns.
        // TreeMap (sorted columns)	O(n log k)
        if (root == null) return new ArrayList<>();
        Map<Integer, ArrayList<Integer>> mp = new TreeMap<>();
        Queue<Pair> q  = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            Node node = curr.node;
            int level = curr.level;
            mp.computeIfAbsent(level, k->new ArrayList<>()).add(node.data);
            if(node.left!=null)q.offer(new Pair(node.left, level-1));
            if(node.right!=null)q.offer(new Pair(node.right, level+1));
        }
        return new ArrayList<>(mp.values());
    }

}