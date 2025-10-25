package Heap.Oct24_25;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;




// Read editorial for more approaches
// https://leetcode.com/problems/task-scheduler/editorial/



class Pair{
    char ch;
    int freq;
    Pair(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] alpha = new int[26];
        int len = tasks.length;
        for(int i=0; i<len; i++){
            alpha[tasks[i]-65]++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(b.freq, a.freq));
        for(int i=0; i<26; i++){
            if(alpha[i]>0){
                pq.add(new Pair((char)(65+i), alpha[i]));
            }
        }

        Queue<Pair> q = new LinkedList<>();
        int ans = 0;
        while(!pq.isEmpty()){
            int cycle = n+1;
            while(cycle>0 && !pq.isEmpty()){
                Pair p = pq.poll();
                cycle--;
                ans++;
                p.freq--;
                if(p.freq>0)q.offer(p);
            }
            while(!q.isEmpty()){
                Pair temp = q.poll();
                pq.add(temp);
            }
            if(q.isEmpty() && pq.isEmpty())break;
            ans+=cycle;
        }
        return ans;
    }

}
