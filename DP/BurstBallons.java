import java.util.*;

class BurstBallons {
    int[][] memo;
    public int maxCoins(int[] nums) {
        List<Integer> li = new ArrayList();
        memo = new int[nums.length + 2][nums.length + 2];
        for(int i = 0; i < nums.length + 2; i++)Arrays.fill(memo[i], -1); 
        li.add(1);
        for(int num : nums){
            li.add(num);
        }
        li.add(1);
        return dfs(li, 1, nums.length);

    }
    public int dfs(List<Integer> nums, int i, int j){
        if(i > j)return 0;
        int mx = Integer.MIN_VALUE;
        if(memo[i][j] != -1)return memo[i][j];
        for(int idx = i; idx <= j; idx++){
            int cost = nums.get(i - 1) * nums.get(idx) * nums.get(j + 1) + dfs(nums, i, idx - 1) + dfs(nums, idx + 1, j);
            mx = Math.max(mx, cost);
        }
        return memo[i][j] = mx;
    }
}