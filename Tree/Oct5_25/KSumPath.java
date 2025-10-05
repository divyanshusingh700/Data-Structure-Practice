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


class Solution {
    public int count=0;
    public int sumK(Node root, int k) {
        // Add all path values using preorder in a list
        // If we hit leaf node we start doing backtrack calculation
        // because it rec function automatically do that
        // we just have to pop 1 by 1 from that path after the calculation
        // for those nodes will be already done
        List<Integer> path = new ArrayList<>();
        backTrack(root, path, k);
        return count;
    }


    // Time complexity goes to O(n**2)
    void backTrack(Node root, List<Integer> path, int k){
        if(root==null)return;
        path.add(root.data);
        backTrack(root.left, path, k);
        backTrack(root.right, path, k);
        int sm = 0;
        for(int i=path.size()-1; i>-1; i--){
            sm+=path.get(i);
            if(sm==k)count++;
        }
        path.remove(path.size() - 1);// calculation for the last node is done now we need to remove that
    }


    // Use Prefix Sum + HashMap
    // Keep track of the prefix sum while traversing.
    // At each node, check if currentSum - k exists in the map.
    // This means there's a path (ending at current node) with sum k.
    public int sumK2(Node root, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1); // Base case: one path with sum 0
        dfs(root, 0, k, prefixSumMap);
        return count;
    }

    private void dfs(Node node, int currSum, int k, Map<Integer, Integer> map) {
        if (node == null) return;

        currSum += node.data;

        // Check if there's a prefix sum that would result in sum k
        count += map.getOrDefault(currSum - k, 0);

        // Update the map with the current sum
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        // Recurse
        dfs(node.left, currSum, k, map);
        dfs(node.right, currSum, k, map);

        // Backtrack: remove current sum from the map
        map.put(currSum, map.get(currSum) - 1);
    }
}