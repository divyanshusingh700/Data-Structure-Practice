import java.util.*;
class Solution {
    HashSet<Integer> set = new HashSet<>();
    boolean findTarget(Node root, int target) {
        if(root==null)return false;
        if(set.contains(target-root.data))return true;
        set.add(root.data);
        return findTarget(root.right, target) || findTarget(root.left, target);
    }
}

class Solution2 {
    void getInorder(Node root, ArrayList<Integer> list){
        if(root==null) return;
        getInorder(root.left, list);
        list.add(root.data);
        getInorder(root.right, list);
    }
    boolean findTarget(Node root, int target) {
        
        ArrayList<Integer> list = new ArrayList<>();
        getInorder(root, list);  // store inorder sorted sequence in list

        int s = 0;
        int e = list.size()-1;
        while(s<e){  // now using 2-pointers find two-sum (as like in array)
            if(list.get(s)+list.get(e)==target) return true;
            else if(list.get(s)+list.get(e)<target) s++;
            else e--;
        }
        return false;
        
    }
}