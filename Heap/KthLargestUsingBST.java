package Heap;
/// Need to understand this later
class KthLargest {

    class TreeNode {
        int val;
        int count; // number of nodes in this subtree including self
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.count = 1;
        }
    }

    private int k;
    private TreeNode root;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            root = insert(root, num);
        }
    }

    // Adds a new value and returns the kth largest
    public int add(int val) {
        root = insert(root, val);
        return findKthLargest(root, k);
    }

    // Insert into BST and update counts
    private TreeNode insert(TreeNode node, int val) {
        if (node == null) return new TreeNode(val);

        if (val <= node.val) {
            node.left = insert(node.left, val);
        } else {
            node.right = insert(node.right, val);
        }

        node.count = 1 + getCount(node.left) + getCount(node.right);
        return node;
    }

    private int getCount(TreeNode node) {
        return node == null ? 0 : node.count;
    }

    // Find kth largest using counts (right subtree has larger values)
    private int findKthLargest(TreeNode node, int k) {
        if (node == null) throw new IllegalArgumentException("Not enough elements");

        int rightCount = getCount(node.right);

        if (rightCount + 1 == k) {
            return node.val;
        } else if (rightCount >= k) {
            return findKthLargest(node.right, k);
        } else {
            return findKthLargest(node.left, k - rightCount - 1);
        }
    }
}

