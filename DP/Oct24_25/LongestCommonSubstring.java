package DP.Oct24_25;

import java.util.Arrays;

public class LongestCommonSubstring {
    int maxLen = 0;
    int[][] dp;

    public int longestCommonSubstrUsinDP(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        dp = new int[n + 1][m + 1];
        for (int i=0; i<n;i++)dp[i][0]=0; 
        for (int j=0; j<m;j++)dp[0][j]=0; 
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                }else{
                    dp[i][j]=0;
                }
            }
        }
        return maxLen;
        
    }


    public int longestCommonSubstrUsingMemo(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        dp = new int[n + 1][m + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        helper(s1, s2, n, m);
        return maxLen;
    }
    private int helper(String s1, String s2, int n, int m) {
        if(n==0 || m==0){
            return 0;
        }
        
        if(dp[n][m]!=-1){ 
            return dp[n][m]; 
        }
        
        if(s1.charAt(n-1)==s2.charAt(m-1)){ 
            dp[n][m] = 1 + helper(s1, s2, n-1, m-1);
            maxLen = Math.max(dp[n][m], maxLen); 
        }else{
            dp[n][m] = 0; 
        }
        
        helper(s1, s2, n - 1, m);
        helper(s1, s2, n, m - 1);
        
        return dp[n][m];
    }
    
}