import java.util.*;

public class DistinctSubsequencesMemo {
    int[][] memo;
    public int numDistinct(String s, String t) {
        memo = new int[s.length() + 1][t.length() + 1];

        for(int i = 0 ; i < s.length(); i++)Arrays.fill(memo[i], -1);

        return dfs(s, t, 0, 0);
    }
    public int dfs(String s, String t, int whichIdx, int idx){
        if(idx == s.length()){
            if(whichIdx == t.length())return 1;
            return 0;
        }

        if(memo[idx][whichIdx] != -1)return memo[idx][whichIdx];

        int take = 0; int skip = 0;

        if(whichIdx < t.length() && s.charAt(idx) == t.charAt(whichIdx)){
            // take
            take = dfs(s, t, whichIdx + 1, idx + 1);
            // skip
            skip = dfs(s, t, whichIdx, idx + 1);
            return memo[idx][whichIdx] = take + skip;
        }
        return memo[idx][whichIdx] = dfs(s, t, whichIdx, idx + 1);
    }
}

// bottom up dp

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        
        for(int i = 0; i <= n; i++)dp[i][m] = 1;

        for(int i = n - 1; i > -1; i--){
            for(int j = m - 1; j > -1; j--){
                if(j < m && s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                }else{
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        
        return dp[0][0];
    }
}
