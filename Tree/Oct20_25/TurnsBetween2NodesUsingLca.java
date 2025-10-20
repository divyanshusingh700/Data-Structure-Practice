package Oct20_25;
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

public class TurnsBetween2NodesUsingLca {

    static int NumberOfTurns(Node root, int first, int second) {
        Node lcaNode = lca(root, first, second);

        StringBuilder path1 = new StringBuilder();
        StringBuilder path2 = new StringBuilder();
        helper(lcaNode, first, 'X', path1);  
        helper(lcaNode, second, 'X', path2);

        int turns = countTurns(path1) + countTurns(path2);

        if (path1.length() > 0 && path2.length() > 0 && path1.charAt(0) != path2.charAt(0)) {
            turns += 1;
        }

        return turns == 0 ? -1 : turns;
    }

    static boolean helper(Node root, int val, char dir, StringBuilder sb) {
        if (root == null) return false;

        if (dir == 'L' || dir == 'R') sb.append(dir);

        if (root.data == val) return true;

        if (helper(root.left, val, 'L', sb) || helper(root.right, val, 'R', sb)) {
            return true;
        }

        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        return false;
    }

    static Node lca(Node root, int data1, int data2) {
        if (root == null) return null;
        if (root.data == data1 || root.data == data2) return root;

        Node left = lca(root.left, data1, data2);
        Node right = lca(root.right, data1, data2);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    static int countTurns(StringBuilder sb) {
        int cnt = 0;
        for (int i = 0; i < sb.length() - 1; i++) {
            if ((sb.charAt(i) == 'L' && sb.charAt(i + 1) == 'R') ||
                (sb.charAt(i) == 'R' && sb.charAt(i + 1) == 'L')) {
                cnt++;
            }
        }
        return cnt;
    }
}

