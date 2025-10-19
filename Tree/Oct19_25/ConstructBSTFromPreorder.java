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
}
