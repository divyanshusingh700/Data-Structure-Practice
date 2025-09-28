package Sep28_25;

import java.util.HashMap;
import java.util.Map;

class UniqueBST {
    // Function to return the total number of possible unique BST.
    static int numTrees(int n) {
        // num[5] = num[0]*num[4] => same goes for num[4]
        //          num[1]*num[3] => same goes for num[3]
        //          num[2]*num[2] => same goes for num[2]
        //          num[3]*num[1]
        //          num[4]*num[0]
        // Sum(from 0 to n) Ci * C(n-1-i)
        // C0C4+C1C3+C2C2+C3C1+C4C0
        // we can go till mid also
        Map<Integer, Integer>mp = new HashMap<>();
        mp.put(0, 1);mp.put(1, 1);
        return dynamicHelper(n); // DP approach
        // return helper(n, mp); // Memoized approach
    }

    // Which is same as the formula for the Nth Catalan number.
    static int helper(int n, Map<Integer, Integer>mp){
        if (mp.containsKey(n)) return mp.get(n);
        int res = 0;
        for(int i=0; i<n; i++){
            res += helper(i, mp)*helper(n-1-i, mp);
        }
        mp.put(n, res);
        return res;
    }
    static int dynamicHelper(int n){
        // 0, 1, at C2 we will start calculating from 0 to 2 because addition is required
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=0; j<i; j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }

    // Brute force approach, no optimization repeatedly calculation
    // Time Complexity: O(2^n)
    public static int helper(int n){
        if(n <= 1) return 1;
        int ans = 0;
        for(int i = 1; i <= n; i++){
            ans += helper(i - 1) * helper(n - i);
        }
        return ans;
    }
}
