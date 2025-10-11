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
public class BSTToGreaterSumTree2 {
    public static void transformTree(Node root) {
        transformtree(root, 0);
    }

    public static int transformtree(Node root, int sm) {
        if (root == null) return sm;

        // First process right subtree and get the updated sum
        sm = transformtree(root.right, sm);

        int rootData = root.data;
        root.data = sm;   // replace with greater sum
        sm += rootData;   // update sum

        // Process left subtree and return final sum
        return transformtree(root.left, sm);
    }
}
