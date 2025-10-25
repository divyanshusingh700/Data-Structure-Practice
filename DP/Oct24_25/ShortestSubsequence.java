import java.util.Arrays;

class Solution {
    public static int shortestCommonSupersequence(String s1, String s2) {
        int mxLen = 0;
        int n=s1.length(), m = s2.length();
        int[][] dp=new int[n+1][m+1];
        for(int[] row:dp)Arrays.fill(row, -1);
        for(int i=0; i<n+1;i++)dp[i][0]=0;
        for(int i=0; i<m+1;i++)dp[0][i]=0;
        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    mxLen = Math.max(mxLen, dp[i][j]);
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        // System.out.println("lcs: "+mxLen);
        return n+m - mxLen;
    }
}