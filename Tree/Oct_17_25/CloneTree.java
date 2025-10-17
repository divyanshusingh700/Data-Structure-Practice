package Oct_17_25;

class Tree{
    int data;
    Tree left,right,random;
    Tree(int d){
        data=d;
        left=null;
        right=null;
        random=null;
    }
}

class CloneTree {
    public Tree cloneTree(Tree root) {
        return helper(root);
    }
    
    public Tree helper(Tree original){
        if(original == null)return null;
        Tree clone = new Tree(original.data);
        clone.random = original.random;
        clone.left  = helper(original.left);
        clone.right = helper(original.right);
        return clone;
    }
} 
