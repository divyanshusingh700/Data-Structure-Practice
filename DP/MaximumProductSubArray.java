// naive
class SolutionNSquare {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int mx = nums[0];
        for(int i = 0; i < n; i++){
            int sm = 1;
            for(int j = i; j < n; j++){
                sm *= nums[j];
                mx = Math.max(sm, mx);
            }
        }
        return mx;
    }
}

// prefix and suffix approach O(n)
class SolutionPrefSuff {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int mx = nums[0];
        int pref = 1;
        int suff = 1;
        for(int i = 0; i < n; i++){
            if(pref == 0)pref = 1;
            if(suff == 0)suff = 1;
            pref *= nums[i];suff *= nums[n - 1 - i];
            mx = Math.max(mx, pref);
            mx = Math.max(mx, suff);
        }
        return mx;
    }
}