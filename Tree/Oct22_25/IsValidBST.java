package Oct22_25;

//  * Definition for a binary tree node.
public class IsValidBST {
    int val;
    IsValidBST left;
    IsValidBST right;

    IsValidBST() {
    }

    IsValidBST(int val) {
        this.val = val;
    }

    IsValidBST(int val, IsValidBST left, IsValidBST right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Pair {
    long min;
    long max;
    boolean isBst;

    Pair() {
        this.min = Long.MAX_VALUE;
        this.max = Long.MIN_VALUE;
        this.isBst = true;
    }
}

class CheckBST {
    public boolean isValidBST(IsValidBST root) {
        Pair ans = helper(root);
        return ans.isBst;
    }

    public Pair helper(IsValidBST root) {
        if (root == null)
            return new Pair();
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        Pair res = new Pair();
        if (!left.isBst || !right.isBst || (left.max >= root.val) || (right.min <= root.val)) {
            res.isBst = false;
        }
        res.min = Math.min(left.min, root.val);
        res.max = Math.max(root.val, right.max);
        return res;
    }
}
