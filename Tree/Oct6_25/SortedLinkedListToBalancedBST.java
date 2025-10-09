package Oct6_25;
import java.util.*;
class LNode{
    int data;
    LNode next;
    LNode(int d) {
        data = d;
        next = null;
    }
}
class TNode{
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }

}
class Solution {
    public TNode sortedListToBST(LNode head) {

        List<Integer> arr = new ArrayList<>();
        while(head!=null){
            arr.add(head.data);
            head=head.next;
        }
        // return sortedArrToBST(arr, 0, arr.size()-1);
        return build(head, null);
    }
    TNode build(LNode head, LNode tail){
        if(head == tail)return null;
        LNode slow = head;LNode fast = head;
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        TNode root = new TNode(slow.data);
        root.left = build(head, slow);
        root.right = build(slow.next, tail);
        return root;
    }
    TNode sortedArrToBST(List<Integer> arr, int start, int end){
        if(start>end)return null;
        int mid = start + (end - start + 1) / 2;  
        TNode root = new TNode(arr.get(mid));
        root.left = sortedArrToBST(arr, start, mid-1);
        root.right = sortedArrToBST(arr, mid+1, end);
        return root;
    }
}