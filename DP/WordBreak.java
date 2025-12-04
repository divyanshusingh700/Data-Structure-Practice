import java.util.*;

class Solution {
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        memo = new Boolean[s.length()];
        return dfs(s, 0, dict);
    }
    public boolean dfs(String s, int idx, Set<String> dict){
        if(idx == s.length()){
            return true;
        }
        if(memo[idx]!=null)return memo[idx];
        if(dict.contains(s))return memo[idx] = true;

        for(int i = idx; i <= s.length(); i++){
            String sub = s.substring(idx, i);
            if(dict.contains(sub) && dfs(s, i, dict))return memo[idx] = true;
        }
        return memo[idx] = false;

    }

}


// Sliding window Approach using memo recursion dp
class SolutionSW {
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        memo = new Boolean[s.length()];
        return dfs(s, 0, dict);
    }
    public boolean dfs(String s, int idx, Set<String> dict){
        if(idx >= s.length()){
            return true;
        }
        if(memo[idx]!=null)return memo[idx];

        for(String w: dict){// for each word list goes one by one and tries to find
            int len = w.length();
            if(((idx + len) <= s.length()) && s.startsWith(w, idx) && dfs(s, idx + len, dict))return memo[idx] = true; // sliding window check 
        }
        return memo[idx] = false;
    }

}
// bottom up
class SolutionDP {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 0; i < s.length(); i++){
            if(!dp[i])continue;
            for(String word: dict){
                if(dp[i] && s.startsWith(word, i)){
                    dp[i + word.length()] = true;
                }
            }
        }
        return dp[s.length()];
    }
}

