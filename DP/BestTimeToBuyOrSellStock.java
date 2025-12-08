class Solution {
    Integer[][] memo;
    public int maxProfit(int[] prices) {
        memo = new Integer[prices.length][2];

        return dfs(prices, 0, 1);
    }
    public int dfs(int[] prices, int idx, int buy){
        if(idx >= prices.length)return 0;
        if(memo[idx][buy] != null)return memo[idx][buy];
        if(buy == 1){
            return memo[idx][buy] = Math.max(-prices[idx] + dfs(prices, idx + 1, 0), dfs(prices, idx + 1, 1));// either buy or skip
        }return memo[idx][buy] = Math.max(prices[idx] + dfs(prices, idx + 2, 1), dfs(prices, idx + 1, 0));// either sell or skip
    }
}
// bottom up
class BottomUpDP {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 2][2];
        for(int i = prices.length - 1; i > -1; i--){
            for(int buy = 0; buy < 2; buy++){
                if(buy == 1){
                     dp[i][buy] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);// either buy or skip
                }
                else dp[i][buy] = Math.max(prices[i] + dp[i + 2][1], dp[i + 1][0]);// either sell or skip

            }
        }
        return dp[0][1];
    }
}

// bottom up
class BU {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 2][2];
        for(int i = prices.length - 1; i > -1; i--){
            dp[i][1] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);// either buy or skip
            dp[i][0] = Math.max(prices[i] + dp[i + 2][1], dp[i + 1][0]);// either sell or skip
        }
        return dp[0][1];
    }
}