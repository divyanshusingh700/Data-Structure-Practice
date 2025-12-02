// pure recursion
class SolutionRecursion {
    int mn;

    public int coinChange(int[] coins, int amount) {
        mn = Integer.MAX_VALUE;
        // Arrays.sort(coins);
        dfs(coins, amount, 0, coins.length - 1);
        return mn == Integer.MAX_VALUE ? -1 : mn;
    }

    public void dfs(int[] coins, int amount, int coinCnt, int i){
        if (i < 0) return;

        if (amount == 0){
            mn = Math.min(mn, coinCnt);
            return;
        }

        // take
        if (coins[i] <= amount){
            // coinCnt[0]++; // choose coin
            dfs(coins, amount - coins[i], coinCnt + 1, i);
            // coinCnt[0]--;// backtrack             
        }

        // skip
        dfs(coins, amount, coinCnt, i - 1);
    }
}


// top down memoization
class SolutionMemo {
    int mn;
    int[][] memo;
    public int coinChange(int[] coins, int amount) {

        memo = new int[coins.length][amount + 1];

        for(int i = 0; i < coins.length; i++)Arrays.fill(memo[i], -1);

        int ans = dfs(coins, amount, 0, coins.length - 1);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int dfs(int[] coins, int amount, int coinCnt, int i){
        if(amount == 0)return 0;
        if (i < 0) return Integer.MAX_VALUE;

        if(memo[i][amount] != -1)return memo[i][amount];
        // take
        int take = Integer.MAX_VALUE;
        if (coins[i] <= amount){
            int res = dfs(coins, amount - coins[i], coinCnt + 1, i);
            take = res != Integer.MAX_VALUE ? res + 1 : Integer.MAX_VALUE;
        }
        int skip = dfs(coins, amount, coinCnt, i - 1);

        return memo[i][amount] = Math.min(take, skip);
    }
}


// Bottom up dp
class SolutionDP {    
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        int x = Integer.MAX_VALUE/2;
        Arrays.fill(dp, x);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int c: coins){
                if(i - c >= 0)dp[i] = Math.min(dp[i], dp[i - c] + 1);
            } 
        }
        return dp[amount] == x ? -1 : dp[amount];
    }
}