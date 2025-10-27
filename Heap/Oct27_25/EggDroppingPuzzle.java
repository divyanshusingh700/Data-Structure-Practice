import java.util.Arrays;

class EggDroppingPuzzle {
    static int[][] memo;
    static int eggDrop(int n, int k){
        memo = new int[n+1][k+1];
        for(int[] row:memo)Arrays.fill(row, -1);
        return eggDrops(n, k);
    }
    static int eggDrops(int n, int k) {
        if(n==1 || k==1 || k==0)return k;
        if(memo[n][k]!=-1)return memo[n][k];
        int mn =Integer.MAX_VALUE;
        int low = 1; int high = k;
        while(low<=high){
            int mid = low + (high-low)/2;
            int breakCase = memo[n-1][mid-1]!=-1?memo[n-1][mid-1]:eggDrops(n-1, mid-1);
            int notBreakCase = memo[n][k-mid]!=-1?memo[n][k-mid]:eggDrops(n, k-mid);
            
            int temp = 1+Math.max(breakCase, notBreakCase);
            mn = Math.min(mn, temp);
            

            if (breakCase > notBreakCase) {
                // Too many floors below -> go down
                high = mid - 1;
            } else {
                // Too many floors above -> go up
                low = mid + 1;
            }
        }
        
        return memo[n][k]=mn;
    }
}