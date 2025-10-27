import java.util.*;

class Solution {
    Set<String> st;
    Boolean[] memo;
    public boolean wordBreak(String s, String[] dictionary) {
        memo = new Boolean[s.length()+1];
        
        st = new HashSet<>(Arrays.asList(dictionary));
        Arrays.fill(dictionary, null);
        return helper(0, s, s.length());
    }
    public boolean helper(int idx, String s, int n){
        if(idx >= n)return true;
        if(memo[idx]!=null)return memo[idx];
        if(st.contains(s)){
            memo[idx]=true;
            return memo[idx];
        }
        for(int len = idx; len<=n; len++){
            String temp = s.substring(idx, len);
            if(st.contains(temp) && helper(len, s, n)){
                memo[idx]=true;
                return memo[idx];
            }
        }
        memo[idx]=false;
        return false;
    }

}