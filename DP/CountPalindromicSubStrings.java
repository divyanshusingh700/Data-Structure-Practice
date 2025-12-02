class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int center = 2*n - 1;
        int ans = 0;
        for(int i = 0; i < center; i++){
            int left = i/2;
            int right = left + i%2;
            while(left>-1 && right<n && s.charAt(left) == s.charAt(right)){
                left--;right++;ans++;
            }
        }
        return ans;
    }
}

// recursion + memo
class SolutionRecursionMemo {
    boolean[][] memo;
    public int countSubstrings(String s) {
        int n = s.length();
        memo = new boolean[n][n];
        for(int i = 0; i < n; i++)Arrays.fill(memo[i], false);
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(check(s, i, j)){
                    
                    count++;
                }
            }
        }
        return count;
    }
    public boolean check(String s, int i, int j){
        if(i > j)return true;

        if(memo[i][j]!=false)return memo[i][j];

        if(s.charAt(i) == s.charAt(j)){
            return memo[i][j] = check(s, i + 1, j - 1);
        }

        return memo[i][j] = false;
    }
}



// Dynamic programming
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++)Arrays.fill(dp[i], false);
        int count = 0;
        for(int len = 1; len <= n; len++){
            for(int i = 0; i + len - 1 < n; i++){
                int j = i + len - 1;
                if(i == j){// length 1
                    dp[i][j] = true;
                }else if(i + 1 == j){// length 2
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? true : false;
                }else{
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] ? true : false;
                }
                if(dp[i][j])count++;
            }
        }
        return count;
    }
}