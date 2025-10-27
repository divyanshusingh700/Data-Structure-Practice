package Oct25_25;
import java.util.*;
public class PrintLeafToLeafPath {

    public List<List<Integer>> leafToLeafPaths(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        getLeafPaths(root, res);
        return res;
    }
    
    private List<List<Integer>> getLeafPaths(TreeNode node, List<List<Integer>> res) {
        if (node == null)
            return new ArrayList<>();

        if (node.left == null && node.right == null) {
            List<Integer> leafList = new ArrayList<>();
            leafList.add(node.val);
            List<List<Integer>> base = new ArrayList<>();
            base.add(leafList);
            return base;
        }

        List<List<Integer>> leftPaths = getLeafPaths(node.left, res);
        List<List<Integer>> rightPaths = getLeafPaths(node.right, res);
        List<List<Integer>> upwardPaths = new ArrayList<>();

        if (!leftPaths.isEmpty() && !rightPaths.isEmpty()) {
            for (List<Integer> l : leftPaths) {
                for (List<Integer> r : rightPaths) {
                    List<Integer> combined = new ArrayList<>(l.size() + 1 + r.size());
                    combined.addAll(l);
                    combined.add(node.val);
                    combined.addAll(r);
                    res.add(combined);
                }
            }
        }

        for (List<Integer> l : leftPaths) {
            List<Integer> temp = new ArrayList<>(l.size() + 1);
            temp.addAll(l);
            temp.add(node.val);
            upwardPaths.add(temp);
        }

        for (List<Integer> r : rightPaths) {
            List<Integer> temp = new ArrayList<>(1 + r.size());
            temp.add(node.val);
            temp.addAll(r);
            upwardPaths.add(temp);
        }

        return upwardPaths;
    }
}
