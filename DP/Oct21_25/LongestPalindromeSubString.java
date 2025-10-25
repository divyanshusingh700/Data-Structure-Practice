package DP.Oct21_25;
import java.util.*;
public class LongestPalindromeSubString {
    public String getLongestPal(String s) {
        // code here
        int n = s.length();
        int mx = 1;
        int[][] dp = new int[n][n];
        int ansLeft = 0;
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
            dp[i][i]=1;
        }
        // Initially 2 length string ka fill kr do
        for(int i=0; i<n-1; i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=1;
                if(mx<2){
                    mx = 2;
                    ansLeft = i;
                }
            }else{
                dp[i][i+1]=0;
            }
        }

        // later from 3rd 
        for(int len=3; len<=n;len++){
            for(int i=0; i<=n-len; i++){
                int j=len+i-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1){
                    dp[i][j] = 1;
                    if(mx<(len)){
                        mx = len;
                        ansLeft = i;
                    }
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return s.substring(ansLeft, ansLeft+mx);
    }

    public String getLongestPalCenter(String s) {
        // code here
        int n = s.length();
        int ansLeft = 0;
        int ansRight = 0;
        int mx = Integer.MIN_VALUE;
        for(int center=0; center< (2 * n - 1); center++){
            int left = center/2;
            int right = left+(center%2);    
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            if(mx < (right - left - 1)){
                ansLeft = left+1;
                ansRight = right-1;
                mx = (right - left - 1);
            }
        }
        return s.substring(ansLeft, ansRight+1);
    }
}
