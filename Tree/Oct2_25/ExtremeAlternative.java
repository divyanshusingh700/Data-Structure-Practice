class Solution {
    public ArrayList<Integer> extremeNodes(Node root) {
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> st = new LinkedList<>();
        st.offer(root);
        
        int currLevel = 0;
        while(!st.isEmpty()){
            int n = st.size();
            boolean dir = true;
            for(int i=0; i<n; i++){
                Node curr = st.poll();
                if((currLevel&1)==0){
                    if(i==n-1 && dir){ans.add(curr.data);
                    dir=false;}
                }else{
                    if(i==0  && dir){ans.add(curr.data);
                    dir = false;}
                }
                if(curr.left!=null)st.offer(curr.left);
                if(curr.right!=null)st.offer(curr.right);
            }
            currLevel++;
        }
        return ans;
    }
}