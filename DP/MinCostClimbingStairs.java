class Solution {
    
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] dp = new int[n];

        if(n == 1)return cost[0];
        if(n == 2)return  Math.min(cost[0], cost[1]);

        dp[0] = cost[0];
        dp[1] = cost[1]; 

        for(int i = 2; i < n; i++){
            dp[i] = cost[i] + Math.min(dp[i - 1],  dp[i - 2]);
        }
        
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}



// Memo + recursion
class Solution {
    int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return Math.min(dfs(cost, 0, n), dfs(cost, 1, n));
    }

    public int dfs(int[] cost, int step, int n) {
        if (step == n) return 0;
        if (step > n) return Integer.MAX_VALUE / 2;

        if (memo[step] != -1) return memo[step];

        int take1 = dfs(cost, step + 1, n);
        int take2 = dfs(cost, step + 2, n);

        return memo[step] = cost[step] + Math.min(take1, take2);
    }
}
