public class CoinChange2Tabulation {
    
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int i = 0; i < n; i++)dp[i][0] = 1;

        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < n; j++){
                int include = i - coins[j] >= 0 ? dp[j][i - coins[j]]:0;
                int exclude = j > 0 ? dp[j - 1][i]:0;
                dp[j][i] = include + exclude;
            }
        }


        return dp[n - 1][amount];
    }
}