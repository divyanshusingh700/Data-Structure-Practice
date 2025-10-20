package Oct20_25;


    
class MinMax {
    boolean isBst;
    Node min;
    Node max;

    MinMax() {
        this.isBst = true;
        this.min = new Node(Integer.MAX_VALUE);
        this.max = new Node(Integer.MIN_VALUE);
    }
}

public class Fix2Nodes {
    Node value1 = null;
    Node value2 = null;
    Node prev = null;
    void correctBST(Node root) {
        // findInorder(root);
        findHelper(root);
        if (value1 != null && value2 != null) {
            int temp = value1.data;
            value1.data = value2.data;
            value2.data = temp;
        }
        return;
    }
    void findInorder(Node root){
        if(root == null)return;
        findInorder(root.left);
        if(prev!=null && prev.data>root.data){
            if(value1 == null){
                value1 = prev;
            }
            value2 = root;
        }
        prev = root;
        findInorder(root.right);
        
    }

    public MinMax findHelper(Node root) {
        if (root == null) return new MinMax();

        MinMax left = findHelper(root.left);
        MinMax right = findHelper(root.right);

        MinMax res = new MinMax();

        if (!left.isBst || !right.isBst || root.data < left.max.data || root.data > right.min.data) {
            res.isBst = false;

            if (root.data < left.max.data && value1 == null)
                value1 = left.max;

            if (root.data > right.min.data)
                value2 = right.min;

            return res;
        }

        res.min = (root.left != null) ? left.min : root;
        res.max = (root.right != null) ? right.max : root;

        return res;
    }
}
