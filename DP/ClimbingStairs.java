package DP;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n <= 2)return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;dp[1] = 1; dp[2] = 2;
        for(int i = 3; i < n + 1; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

class Solution {
    int[] memo;
    public int climbStairs(int n) {
        memo = new int[n];
        return dfs(0, n);
    }
    public int dfs(int steps, int n){
        if(steps > n)return 0;
        if(steps == n){
            return 1;
        }
        if(memo[steps] != 0)return memo[steps];
        
        return memo[steps] = dfs(steps + 1, n) + dfs(steps + 2, n);
    }
}
