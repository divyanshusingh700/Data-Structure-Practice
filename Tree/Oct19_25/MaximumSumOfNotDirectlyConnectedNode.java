package Oct19_25;

class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Pair{
    int add;
    int notAdd;
    Pair(int add, int notAdd){
        this.add = add;
        this.notAdd = notAdd;
    }
}
public class MaximumSumOfNotDirectlyConnectedNode {   
    public int getMaxSum(Node root) {
        Pair ans = helper(root);
        return Math.max(ans.add, ans.notAdd);
    }
    public Pair helper(Node root){
        if(root == null)return new Pair(0, 0);
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        return new Pair(root.data+left.notAdd+right.notAdd, Math.max(left.add, left.notAdd) + Math.max(right.add, right.notAdd));
    }
}










