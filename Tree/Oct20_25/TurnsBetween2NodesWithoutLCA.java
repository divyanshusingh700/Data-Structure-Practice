package Oct20_25;

import java.util.*;
    
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

public class TurnsBetween2NodesWithoutLCA {
    static int NumberOfTurns(Node root, int first, int second) {
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        
        helper(root, first, '-', sb2);
        helper(root, second, '-', sb3);
        int len = Math.min(sb2.length(), sb3.length());
        int idx = 0;
        while(idx<len && sb2.charAt(idx)==sb3.charAt(idx)){
            idx++;
        }
        StringBuilder sb = new StringBuilder(sb2.substring(idx));
        StringBuilder sb1 = new StringBuilder(sb3.substring(idx));
        int x = countTurns(sb)+countTurns(sb1);
        if (sb.length() > 0 && sb1.length() > 0 && sb.charAt(0) != sb1.charAt(0)) {
            x += 1;
        }
        return x==0?-1:x;
    }
    static boolean helper(Node root, int val, char dir, StringBuilder sb){
        if(root == null)return false;
        sb.append(dir);
        if(root.data == val)return true;
        if(helper(root.left, val, 'L', sb) || helper(root.right, val, 'R', sb)){
            return true;
        }
        sb.deleteCharAt(sb.length()-1);
        return false;
    }
    static int countTurns(StringBuilder sb){
        int cnt = 0;
        for(int i=0; i<sb.length()-1; i++){
            if((sb.charAt(i)=='L' && sb.charAt(i+1) == 'R') || (sb.charAt(i)=='R' && sb.charAt(i+1) == 'L')){
                cnt++;
            }
        }
        return cnt;
    }
}