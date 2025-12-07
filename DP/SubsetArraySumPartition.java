public class SubsetArraySumPartition {
    int sm;
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        sm = 0;
        memo = new Boolean[201][20001];

        for(int num : nums){sm += num;}
        if((sm&1) == 1)return false;
        
        return dfs(nums, 0, 0);
    }
    public boolean dfs(int[] nums, int sum, int idx){

        if(sm/2 == sum)return memo[idx][sum] = true;
        if(idx >= nums.length || sum > sm/2)return memo[idx][sum] = false;

        if(memo[idx][sum] != null)return memo[idx][sum];

        boolean take = dfs(nums, sum + nums[idx], idx + 1);

        if(take)return memo[idx][sum] = take;
        
        return memo[idx][sum] = dfs(nums, sum, idx + 1);
    }
}

class Solution {
    
    public boolean canPartition(int[] nums) {
        int sm = 0;
        for(int num : nums){sm += num;}
        if((sm&1) == 1)return false;

        int target = sm/2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0] = true;
        for(int i = 1; i <= nums.length; i++){
            for(int s = 0; s <= target; s++){
                dp[i][s] = dp[i - 1][s]; // skip
                if(s >= nums[i - 1] && dp[i - 1][s - nums[i - 1]]){ // take
                    dp[i][s] = true;
                }
            }
        }
        
        return dp[nums.length][target];
    }
}
