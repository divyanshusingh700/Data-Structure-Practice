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
public class BSTToGreaterSumTree1 {
        static int sum = 0;
    
    public static void transformTree(Node root) {
        sum = 0;
        transformtree(root);
    }
    
    public static void transformtree(Node root) {
        if (root == null) return;
        transformtree(root.right);
        int rootData = root.data;
        root.data = sum;
        sum += rootData;
        transformtree(root.left);
    }

}
