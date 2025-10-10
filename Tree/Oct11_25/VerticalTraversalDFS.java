package Oct11_25;

import java.util.*;
import java.util.stream.Collectors;
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
class Pair{
    int val;
    int level;
    Pair(int val, int level){
        this.val = val;
        this.level = level;
    }
}

class Solution {

    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        // Idea is here to get vertical level order sorted data
        // so first we use DFS and then we sorted the keys
        // so that we will get in order data from asc
        // then we sorted on basis of levels
        // TC goes to O(nlog(n)) for Skewed it will go O(n^2)

        Map<Integer, ArrayList<Pair>> mp = new HashMap<>();
        int val = 0, level=0;
        helper(root, val, level);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        List<Integer> sortedKeys = mp.keySet()
                                    .stream()
                                    .sorted()
                                    .collect(Collectors.toList());
        for(int i=0; i<mp.size(); i++){
            ArrayList<Pair> temp = mp.get(sortedKeys.get(i));
            temp.sort(Comparator.comparingInt((Pair p) -> p.level));
            ArrayList<Integer> fin = new ArrayList<>();
            for(int j=0;j<temp.size(); j++){
                fin.add(temp.get(j).val);
            }
            res.add(fin);
        }
        return res;
    }
    void helper(Node root, int val, int level){
        if(root==null)return;
        mp.computeIfAbsent(val, k -> new ArrayList<>()).add(new Pair(root.data, level));
        helper(root.left, val-1, level+1);
        helper(root.right, val+1, level+1);
    }
}