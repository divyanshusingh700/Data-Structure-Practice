class Pair{
    int data;
    boolean same;
    Pair(int data, boolean same){
        this.data = data;
        this.same=same;
    }
}

class Solution {
    int cnt=0;
    public int singlevaluedApproach1(Node root) {
        /* IDEA:
        1) Main ek pair type return krunga, jo do value contain krega, ek int aur dusra bool.
        2) jaise hr ek root node ke liye main dekhunga ki uske left side se kya value aa rhi hai
        aur uske right side se kya value aa rhi hai.
        3) bool batayega ki kya hme kabhi aisa emncounter ki uske left aur right se different 
        values mili hain */
        if(root==null)return 0;
        helper(root);
        return cnt;
    }
    Pair helper(Node root){
        if(root==null)return new Pair(-1, true);
        if(root.left==null && root.right==null){
            cnt++;
            return new Pair(root.data, true);
        }
        Pair lefter = helper(root.left);
        Pair righter = helper(root.right);
        if((lefter.data==righter.data && 
           righter.data==root.data && 
           lefter.same==true && righter.same==true) || 
           (lefter.data == -1 && righter.data==root.data && righter.same==true) ||
           (righter.data == -1 && lefter.data==root.data && lefter.same==true)){
            cnt++;
            return new Pair(root.data, true);
        }else{
            return new Pair(root.data, false);
        }
    }
    public int singlevaluedApproach2(Node root) {
        /* IDEA:
        1) Main ek pair type return krunga, jo do value contain krega, ek int aur dusra bool.
        2) jaise hr ek root node ke liye main dekhunga ki uske left side se kya value aa rhi hai
        aur uske right side se kya value aa rhi hai.
        3) bool batayega ki kya hme kabhi aisa emncounter ki uske left aur right se different 
        values mili hain */
        if(root==null)return 0;
        helperA2(root);
        return cnt;
    }
    boolean helperA2(Node root){
        if(root==null)return true;
        boolean left = helperA2(root.left);
        boolean right = helperA2(root.right);
        if(!left || !right){
            return false;
        }
        if(root.left!=null && root.data!=root.left.data){
            return false;
        }
        if(root.right!=null && root.data!=root.right.data){
            return false;
        }
        cnt++;
        return true;
    }
}