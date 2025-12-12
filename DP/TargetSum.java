import java.util.Arrays;

public class TargetSum {
    int ulti;
    int[][] memo;
    int offset;
    public int findTargetSumWays(int[] nums, int target) {
        offset = 0;
        for(int num: nums)offset += num;

        memo = new int[nums.length][2*offset + 1];

        for(int i = 0; i < nums.length; i++)Arrays.fill(memo[i], -1);

        ulti = target;
        return dfs(nums, 0, 0);
    }
    public int dfs(int[] nums, int target, int idx){
        if(idx > nums.length)return 0;
        if(idx == nums.length){
            if(ulti == target)return 1;
            else return 0;
        }
        if(Math.abs(target) > offset)return 0;
        int tarIndex = offset + target;
        if(memo[idx][tarIndex] != -1)return memo[idx][tarIndex];

        int add = dfs(nums, target + nums[idx], idx + 1);
        int minus = dfs(nums, target - nums[idx], idx + 1);

        return memo[idx][tarIndex] = add + minus;
    }
}
