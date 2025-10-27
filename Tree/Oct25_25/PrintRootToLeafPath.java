package Oct25_25;

import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode() {
        this.val = 0;
        this.left = this.right = null;
    }

    TreeNode(int data) {
        this.val = data;
        this.left = this.right = null;
    }
}
public class PrintRootToLeafPath {
    public List<String> rootToLeafPathsSB(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        backtrack(root, new StringBuilder(), res);
        return res;
    }

    private void backtrack(TreeNode node, StringBuilder sb, List<String> res) {
        if (node == null) return;

        int len = sb.length();
        if (len != 0) sb.append("->");
        sb.append(node.val);

        if (node.left == null && node.right == null) {
            res.add(sb.toString());
        } else {
            backtrack(node.left, sb, res);
            backtrack(node.right, sb, res);
        }
        sb.setLength(len); // backtrack efficiently
    }


    // Using array list 
    public List<List<Integer>> rootToLeafPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode node, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        path.add(node.val);

        // leaf node
        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));
        } else {
            dfs(node.left, path, result);
            dfs(node.right, path, result);
        }

        path.remove(path.size() - 1); // backtrack
    }

}
