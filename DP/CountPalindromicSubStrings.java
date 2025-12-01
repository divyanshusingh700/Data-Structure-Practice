class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int center = 2*n - 1;
        int ans = 0;
        for(int i = 0; i < center; i++){
            int left = i/2;
            int right = left + i%2;
            while(left>-1 && right<n && s.charAt(left) == s.charAt(right)){
                left--;right++;ans++;
            }
        }
        return ans;
    }
}