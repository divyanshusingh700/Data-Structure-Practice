package Oct19_25;
import java.util.*;
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}

public class ConstructBSTFromPreorder {
    Node bstFromPreorder(int[] pre) {
        if (pre.length == 0) return null;

        Node root = new Node(pre[0]);
        Stack<Node> st = new Stack<>();
        st.push(root);

        for (int i = 1; i < pre.length; i++) {
            Node temp = null;
            while (!st.isEmpty() && pre[i] > st.peek().data) {
                temp = st.pop();
            }

            if (temp != null) {
                temp.right = new Node(pre[i]);
                st.push(temp.right);
            } else {
                st.peek().left = new Node(pre[i]);
                st.push(st.peek().left);
            }
        }

        return root;
    }



    static int idx = 0;
    public static Node constructUtil(List<Integer> pre, 
                                   int min, int max) {
        if (idx >= pre.size())
            return null;
        int key = pre.get(idx);
        if (key <= min || key >= max)
            return null;
        Node root = new Node(key);
        idx++;
        root.left = constructUtil(pre, min, key);
        root.right = constructUtil(pre, key, max);
        return root;
    }



    public static Node insertBST(Node root, int key) {
        if (root == null)return new Node(key);
        if (root.data > key)
            root.left = insertBST(root.left, key);
        else if (root.data < key)
            root.right = insertBST(root.right, key);
        return root;
    }
    public static Node construct(List<Integer> pre) {
        Node root = null;
        for (int key : pre) {
            root = insertBST(root, key);
        }
        return root;
    }

        public static Node constructUtility(List<Integer> pre,
                                     int low, int high) {
        if (low > high)return null;
        Node root = new Node(pre.get(low));

        if (low == high)
            return root;

        int i;
        for (i = low + 1; i <= high; i++) {
            if (pre.get(i) > root.data)
                break;
        }

        root.left = constructUtil(pre, low + 1, i - 1);
        root.right = constructUtil(pre, i, high);

        return root;
    }

    public static Node construction(List<Integer> pre) {
        return constructUtility(pre, 0, pre.size() - 1);
    }
}
