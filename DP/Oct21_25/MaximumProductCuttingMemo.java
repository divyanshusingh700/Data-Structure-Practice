package DP.Oct21_25;
import java.util.*;
public class MaximumProductCuttingMemo {
    // 5 -  1*4 -> 4 can go again to divide and get better value;
    //      2*3 -> 3 can go again to divide and get better value;
    //      3*2 -> 2 can go again to divide and get better value;
    //      4*1 -> 1 can go again to divide and get better value;

    int[] dp = new int[1000] ; 
    public int maxProduct(int n) {
        Arrays.fill(dp, -1);
        dp[0] = 0;dp[1] = 1;dp[2] = 1;
        return helper(n);
    }
    public int helper(int n){
        if(dp[n]!=-1)return dp[n];
        int maxi = 0;
        for(int i=1; i<n; i++){
            maxi = Math.max(Math.max(i*(n-i), maxi), Math.max(maxi, i*helper(n-i)));
        }
        dp[n] = maxi;
        return maxi;
    }

    public int maxProductUsingDp(int n) {
        int[] dp = new int[n+1] ; 
        // Arrays.fill(dp, -1);
        dp[0] = 0;dp[1] = 1;
        for(int i=2; i<n+1;i++){
            for(int j=1; j<i; j++){
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
            }
        }
        return dp[n];
    }
};
