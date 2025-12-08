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