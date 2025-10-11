package Oct11_25;


import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class BSTToGreaterSumTree {
    static List<Integer> li = new ArrayList<>();
    static Map<Integer, Integer> mp = new HashMap<>();
    public static void transformTree(Node root) {
        li.clear();mp.clear();
        inorder(root);
        int sm = 0;
        for(int i=li.size()-1; i>-1; i--){
            int ele = li.get(i);
            // System.out.print("eles: "+sm);
            sm+=ele;
            if(!mp.containsKey(li.get(i))){
                mp.put(li.get(i), sm-ele);
            }
        }
        transform(root);
        // return root;
    }
    static void inorder(Node root){
        if(root==null)return ;
        inorder(root.left);
        li.add(root.data);
        inorder(root.right);
    }
    static void transform(Node root){
        if(root==null)return ;
        // System.out.print("eles: "+mp.get(root.data));
        root.data = mp.get(root.data);
        transform(root.left);
        transform(root.right);
    }
}