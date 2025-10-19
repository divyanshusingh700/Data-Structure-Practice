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

            // Keep popping until we find the parent to attach current element as right child
            while (!st.isEmpty() && pre[i] > st.peek().data) {
                temp = st.pop();
            }

            if (temp != null) {
                // If popped, this is the right child
                temp.right = new Node(pre[i]);
                st.push(temp.right);
            } else {
                // Else, this becomes left child of st.peek()
                st.peek().left = new Node(pre[i]);
                st.push(st.peek().left);
            }
        }

        return root;
    }
}
