package Oct9_25;

import java.util.*;
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}


class ConstructTreeFromInorderPreorder {
    static int preIndex = 0;
    public static Node buildTree(int inorder[], int preorder[]) {
        // Start from the first element in the preorder array (preILocate the root value in the inorder array.
        // The left part of this value in inorder represents the left subtree.
        // The right part of this value in inorder represents the right subtree.ndex = 0), which is always the root of the tree.
        // If inStart > inEnd, return null (no subtree exists).
        // If inStart == inEnd, return the created node (single node subtree).
        preIndex = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        int len = inorder.length;
        for(int i=0; i<len; i++){
            if (!mp.containsKey(inorder[i])) {
                mp.put(inorder[i], i);
            }
        }
        int start = 0; int end = len-1;
        return helper(mp, preorder, start, end);
    }
    static Node helper(Map<Integer, Integer> mp, int preorder[], int start, int end){
        if(start>end)return null;
        Node root = new Node(preorder[preIndex++]);
        if(start==end)return root;

        int goTill = mp.get(root.data);
        
        root.left = helper(mp, preorder, start, goTill-1);
        root.right = helper(mp, preorder, goTill+1, end);
        return root;
    }
}
