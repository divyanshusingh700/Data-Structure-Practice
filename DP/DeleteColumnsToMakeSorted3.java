import java.util.Arrays;

public class DeleteColumnsToMakeSorted3 {
    public int minDeletionSize(String[] strs) {
        int[] dp = new int[strs[0].length()];
        Arrays.fill(dp,1);
        int ans = 1;
        for(int i=1; i<strs[0].length(); i++){
            for(int j=0; j<i; j++){
                boolean isValid = true;
                for(int k = 0; k < strs.length; k++){
                    if(strs[k].charAt(i) < strs[k].charAt(j)){
                        isValid=false;break;
                    }
                }
                if(isValid){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return strs[0].length() - ans;
    }
}
