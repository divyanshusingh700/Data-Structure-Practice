package Oct24_25;

import java.util.HashMap;
import java.util.Map;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


 // so basically approach will be i will define root from preorder
 // then I will search the root position in inorder
 // after finding the idx
 // i will recursively call left portion of inorder array in root.left
 // and right posrtion of inorder array in root.right
 // and they are having unique values
 // so let's start implementing the solution
public class ConstructBTFromInorderAndPostorder {
    int idx = 0;
    Map<Integer, Integer> mp = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            mp.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length-1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        if(start>end)return null;
        int val = preorder[idx++];
        TreeNode root = new TreeNode(val);
        int idxIn = findIndex(inorder, val);

        root.left = helper(preorder, inorder, start, idxIn-1);
        root.right = helper(preorder, inorder, idxIn+1, end);
        return root;

    }
    public int findIndex(int[] arr, int val){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == val)return i;
        }
        return 0;
    }
}
