public class InterleavingStrings {
    Boolean[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(s1, s2, s3, 0, 0, new StringBuilder());
    }

    public boolean dfs(String s1, String s2, String s3, int i, int j, StringBuilder sb) {

        if (i == s1.length() && j == s2.length()) {
            return sb.toString().equals(s3);
        }

        if (memo[i][j] != null) return memo[i][j];

        // take from s1
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            sb.append(s1.charAt(i));
            if (dfs(s1, s2, s3, i + 1, j, sb))
                return memo[i][j] = true;
            sb.deleteCharAt(sb.length() - 1);
        }

        // take from s2
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            sb.append(s2.charAt(j));
            if (dfs(s1, s2, s3, i, j + 1, sb))
                return memo[i][j] = true;
            sb.deleteCharAt(sb.length() - 1);
        }

        return memo[i][j] = false; 
    }
}

// bottom up
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];

        dp[0][0] = true;

        for(int i = 0; i <= s1.length(); i++){
            for(int j = 0; j <= s2.length(); j++){  
                if(dp[i][j] == null)  dp[i][j] = false;

                if(i < s1.length() && dp[i][j] && s1.charAt(i) == s3.charAt(i + j)){
                    dp[i + 1][j] = true;
                } 

                if(j < s2.length() && dp[i][j] && s2.charAt(j) == s3.charAt(i + j)){
                    dp[i][j + 1] = true;
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}


