package Heap;
import java.util.*;
class KthLargest {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int size = 0;
    public KthLargest(int k, int[] nums) {
        size = k;
        for(int i=0; i<nums.length; i++){
            if(minHeap.size()<k)minHeap.add(nums[i]);
            else{
                if(nums[i]>minHeap.peek()){
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            }
        }
    }
    
    public int add(int val) {
        if(!minHeap.isEmpty() && minHeap.size()==size && minHeap.peek()<val){
            minHeap.poll();
            minHeap.add(val);
        }
        if(minHeap.isEmpty() || minHeap.size()<size){
            minHeap.add(val);
        }
        return minHeap.peek();
    }



    // -----------------------------
    // Binary Search Implementation
    // -----------------------------

    int[] arr;
    int k;
    public void KthLargestUsingBS(int k, int[] nums) {
        this.arr = new int[k];
        Arrays.fill(arr, Integer.MIN_VALUE);
        this.k = k;

        for(int num: nums){
            addUsingBS(num);
        }

    }


    public int addUsingBS(int val) {
        if(val<=arr[0])return arr[0];
        int pos = this.getPosition(val);
        for(int i=0; i<pos; i++){
            arr[i] = arr[i+1];
        }
        arr[pos]=val;
        return arr[0];
    }

    public int getPosition(int val){
        int start = 0;
        int end = k-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid] == val)return mid;
            else if(arr[mid]<val){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return end;
    }


}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
