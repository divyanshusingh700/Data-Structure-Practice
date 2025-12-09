package Array;

import java.util.*;

class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        long cnt = 0;
        Map<Integer, Integer> freqPrev = new HashMap<>();
        Map<Integer, Integer> freqNext = new HashMap<>();
        for(int x:nums)freqNext.put(x, freqNext.getOrDefault(x, 0) + 1);

        for(int i = 0; i < n; i++){
            freqNext.put(nums[i], freqNext.get(nums[i]) - 1);
            if(freqNext.get(nums[i]) == 0)freqNext.remove(nums[i]);

            Integer prev = freqPrev.get(nums[i] * 2);
            Integer next = freqNext.get(nums[i] * 2);

            if(prev != null && next != null){
                cnt = (cnt + (long)prev * next) % 1_000_000_007;
            }

            freqPrev.put(nums[i], freqPrev.getOrDefault(nums[i], 0) + 1);
        }
        return (int)(cnt % 1_000_000_007);
    }
}



















        // int n = nums.length;int cnt = 0;
        // for(int i = 0; i < n; i++){
        //     for(int j = i + 1; j < n; j++){
        //         for(int k = j + 1; k < n; k++){
        //             if(nums[i] == nums[j]*2 && nums[k] == nums[j] * 2){
        //                 cnt++;
        //             }
        //         }
        //     }
        // }
        // return cnt%1000000007;
