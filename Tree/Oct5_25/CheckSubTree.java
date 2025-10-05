package Oct5_25;

class CheckSubTree {
    //Traverse Tree T:
    // For each node in tree T, check if the subtree rooted at that node is identical to tree S.
    // If root matches:
    // When T.data == S.data, check if the subtrees are structurally identical and have the same values using a helper method checkSame().
    // Recursive check:
    // If current node doesn't match or is not the root of a matching subtree, recursively check T.left and T.right.
    public static boolean isSubtree(Node T, Node S) {
        if(T == null)return false;
        if(T.data == S.data){
            if(checkSame(T, S)) {
                return true;
            }
        }
        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }
    static boolean checkSame(Node T, Node S){
        if(T == null && S==null)return true;
        if(T == null || S==null)return false;
        return T.data == S.data && checkSame(T.left, S.left) && checkSame(T.right, S.right);
    }


    // Solution 2 
    // Serialize both trees into strings using preorder traversal (with null markers to preserve structure).
    // Check if the serialized string of S is a substring of the serialized string of T.
    public static boolean isSubtree2(Node T, Node S) {
        StringBuilder tSerial = new StringBuilder();
        StringBuilder sSerial = new StringBuilder();

        serialize(T, tSerial);
        serialize(S, sSerial);

        return tSerial.toString().contains(sSerial.toString());
    }

    // Serialize with null markers to preserve structure
    private static void serialize(Node node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,"); // special marker for null
            return;
        }
        sb.append(node.data).append(","); // visit root
        serialize(node.left, sb);         // left subtree
        serialize(node.right, sb);        // right subtree
    }
}
