import java.util.Arrays;

class Solution {
    int[] memo;
    public int numDecodings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfs(s, 0);
    }
    public int dfs(String s, int i){
        if(i == s.length()){
            return 1;
        }
        if(s.charAt(i) == '0')return 0;

        if(memo[i]!=-1)return memo[i];

        int res = dfs(s, i + 1);

        if((i + 1) < s.length()){
            int two = Integer.parseInt(s.substring(i, i + 2));
            if(two <= 26)res += dfs(s, i +2);
        }
        
        return memo[i] = res;
    }
}

class SolutionDP {
    
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for(int i = n - 1; i > -1; i--){
            if(s.charAt(i) == '0')dp[i] = 0;
            else{
                dp[i] = dp[i + 1];
                if(i + 1 < n){
                    int two = Integer.parseInt(s.substring(i, i + 2));
                    if(two <= 26)dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }
}