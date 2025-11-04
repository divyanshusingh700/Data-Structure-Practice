// Key Idea: Two “worlds” of state

// freeRooms → rooms that are currently available to start a new meeting.

// Ordered by room number → always pick the lowest room ID.

// busyRooms → meetings that are currently running.

// Ordered by end time (and then room number as tie-breaker).

// Tells you which room will be free next, and when.

// So, at any given moment:

// freeRooms = rooms you can start a meeting in immediately.

// busyRooms = rooms that are occupied until busy.peek()[0] time.

import java.util.Arrays;
import java.util.PriorityQueue;

class MeetingRoom3 {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b)-> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        PriorityQueue<Integer> free = new PriorityQueue<>();
        PriorityQueue<long[]> endPq = new PriorityQueue<>((a,b)-> a[0]==b[0]?Long.compare(a[1], b[1]):Long.compare(a[0], b[0]));
        int len = meetings.length;
        int[] count = new int[n];
        for(int i=0; i<n; i++){
            free.offer(i);
        }

        for(int i = 0; i < len; i++){
            long start = meetings[i][0];
            long end = meetings[i][1];
            while(!endPq.isEmpty() && endPq.peek()[0] <= start){
                long[] ende = endPq.poll();
                free.offer((int)ende[1]);
            }
            if(endPq.size()<n){
                int room = free.poll();
                endPq.offer(new long[]{meetings[i][1], room});
                count[room]++;
            }else{
                if(!endPq.isEmpty()){
                    long[] pollMaroEndKo = endPq.poll();
                    count[(int) pollMaroEndKo[1]]++;
                    endPq.offer(new long[]{pollMaroEndKo[0] + (end - start), pollMaroEndKo[1]});
                }else{
                    int rooma = free.poll();
                    count[rooma]++;
                    endPq.offer(new long[]{meetings[i][1], rooma});
                }
            }
        }
        int mx = 1;
        for(int ele:count){
            mx = Math.max(mx, ele);
        }
        for(int i=0; i<n;i++){
            if(count[i] == mx)return i;
        }
        return 0;


    }
}