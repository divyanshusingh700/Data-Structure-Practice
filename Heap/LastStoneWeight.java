package Heap;
import java.util.*;
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> mxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int val: stones){
            mxHeap.add(val);
        }
        while(mxHeap.size()>1){
            int mx1 = mxHeap.poll();
            int mx2 = mxHeap.poll();
            if(mx2-mx1 !=0)mxHeap.add(Math.abs(mx2-mx1));
        }
        return mxHeap.size()>0?mxHeap.poll():0;
    }
}
