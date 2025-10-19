package Oct19_25;

import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int val)
    {
        data = val;
        left = right = null;
    }
}


public class Merge2BST {


    public ArrayList<Integer> merge(Node root1, Node root2) {
        List<Integer> arr2 = new ArrayList<>();
        List<Integer> arr1 = new ArrayList<>();
        inorder(root1, arr1);
        inorder(root2, arr2);
        int i=0,j=0;
        ArrayList<Integer> finArr = new ArrayList<>();
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i)>arr2.get(j)){
                finArr.add(arr2.get(j));
                j++;
            }else if(arr1.get(i)<=arr2.get(j)){
                finArr.add(arr1.get(i));
                i++;
            }
        }
        for(; i<arr1.size(); i++){
            finArr.add(arr1.get(i));
        }
        for(; j<arr2.size(); j++){
            finArr.add(arr2.get(j));
        }
        return finArr;
    }
    public void inorder(Node root, List<Integer> arr){
        if(root==null){
            return;
        }
        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }

    public ArrayList<Integer> merges(Node root1, Node root2) {
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        ArrayList<Integer> fin = new ArrayList<>();
        while(root1!=null || root2!=null || !st1.empty() || !st2.empty()){
            while(root1!=null){
                st1.push(root1);
                root1 = root1.left;
            }
            while(root2!=null){
                st2.push(root2);
                root2 = root2.left;
            }
            if(st2.isEmpty() || (!st1.empty() && st1.peek().data<=st2.peek().data)){
                root1 = st1.pop();
                fin.add(root1.data);
                root1 = root1.right;
            }else{
                root2 = st2.pop();
                fin.add(root2.data);
                root2 = root2.right;
            }
        }
        return fin;
    }
}
