class Node{
    Node left;
    Node right;
    int data;
    Node(Node left, Node right, int data){
        this.left=null;
        this.right=null;
        this.data=data;
    }
}
//Given a Binary Tree, find the maximum sum path from a leaf to root.
class MaxLeafPath {
    static int mx = Integer.MIN_VALUE;
    public static int maxPathSum(Node root) {
        mx = Integer.MIN_VALUE;
        helper(root, 0);
        return mx;
    }
    static void helper(Node root, int sm){
        if(root == null)return ;
        if(root.left==null && root.right==null){
            mx = Math.max(mx, sm+root.data);
            return ;
        }
        helper(root.left, sm+root.data);
        helper(root.right, sm+root.data);
    }
}