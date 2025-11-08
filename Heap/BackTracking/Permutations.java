import java.util.*;

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        helper(nums, new ArrayList<>(), new HashSet<>());
        return res;
    }
    public void helper(int[] nums, List<Integer> curr, Set<Integer> st){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));return;
        }
        if(curr.size() > nums.length)return;

        // basically think of a tree diagram where we have to go iterate 
        // over all eles because if we skip someone then we might end up 
        // having small size permutation which is no expected
        for(int i=0; i < nums.length; i++){// here we take first element then we again start from 0 and skip 0 because of set and take others
            if(!st.contains(nums[i])){
                curr.add(nums[i]);st.add(nums[i]);
                helper(nums, curr, st);

                // Backtrack
                curr.remove(curr.size() - 1);st.remove(nums[i]);
                // helper(nums, curr); // we will not call this because we are already using for loop and set to skip those calls
            }
        }
    }
}
//                              []
//             /                 |                  \
//          [1]                 [2]                 [3]
//        /     \              /   \               /   \
//    [1,2]    [1,3]       [2,1]  [2,3]        [3,1]  [3,2]
//     |         |           |       |            |       |
//  [1,2,3]   [1,3,2]    [2,1,3]  [2,3,1]     [3,1,2]  [3,2,1]

