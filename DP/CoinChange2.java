import java.util.Arrays;

public class CoinChange2 {
    int[][] memo;
    public int change(int amount, int[] coins) {
        memo = new int[coins.length][amount + 1];

        for(int i = 0; i < coins.length; i++)Arrays.fill(memo[i], -1);

        return dfs(amount, coins, coins.length - 1);
    }
    public int dfs(int amount, int[] coins, int idx){
        if(idx < 0 || amount < 0)return 0;
        if(amount == 0){
            return 1;
        }
        if(memo[idx][amount] != -1)return memo[idx][amount];
        // take
        int take = dfs(amount - coins[idx], coins, idx);

        // skip
        int skip = dfs(amount, coins, idx - 1);
        return memo[idx][amount] = take + skip;
    }
}