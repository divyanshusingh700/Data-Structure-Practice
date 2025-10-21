package DP.Oct21_25;
import java.util.*;

class Solution {
    // int cnt = 0;
    int[] dp;
    int[] coins= {1,2,5,10};
    // Memoized approach
    public int findMin(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n);
    }
    public int helper(int n){
        if(n==0)return 0;
        if(dp[n]!=-1)return dp[n];
        int mini = Integer.MAX_VALUE;
        for(int coin: coins){
            if(coin<=n)mini = Math.min(mini, 1+helper(n-coin));
        }
        dp[n] = mini;
        return dp[n];
    }



    public int findMinDP(int n) {
        int[] dp = new int[n+1];
        int[] coins= {1,2,5,10};

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1; i<=n; i++){
            for(int j=0;j<4;j++){
                if(coins[j]<=i){
                    dp[i] = Math.min(dp[i], 1+dp[i- coins[j]] );
                }
            }
        }
        return dp[n];
    }
}
