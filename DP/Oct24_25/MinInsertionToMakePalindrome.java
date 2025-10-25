package DP.Oct24_25;
// Idea is to return n - LPS
public class MinInsertionToMakePalindrome {
        int findMinInsertions(String s) {
        // code here
        int n = s.length();
        String t = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n+1][n+1];
        int mx = 0;
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    mx = Math.max(mx,dp[i][j]);
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return n-mx;
    }
}