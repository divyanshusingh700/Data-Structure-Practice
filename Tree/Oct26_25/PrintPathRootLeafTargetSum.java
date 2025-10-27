package Oct26_25;

import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int data,TreeNode left, TreeNode right) {
        this.val = data;
        this.left = this.right = null;
    }
}
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int k; 
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.k = targetSum;
        helper(root, 0, new ArrayList<>());
        return res;
    }
    public void helper(TreeNode root, int sum, List<Integer> ans){
        if(root == null)return ;
        ans.add(root.val);
        sum+=root.val;
        if(root.left==null && root.right==null){
            if(sum==this.k){
                this.res.add(new ArrayList<>(ans));
            }
            
        }
        helper(root.left, sum, ans);
        helper(root.right, sum, ans);
        ans.remove(ans.size()-1);
    }
}
