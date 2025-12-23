import java.util.Arrays;

public class TwoBestNonOverlappingEvents {
    int[][] memo;
    int[] starts;
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        memo = new int[n][2];
        starts = new int[n];
        
        for(int i = 0; i < n; i++)Arrays.fill(memo[i], -1);
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        for(int i = 0; i < n; i++){
            starts[i] = events[i][0];
        }


        return dfs(events, 0, 0);
    }
    public int dfs(int[][] events, int idx, int cnt){
        if(idx == events.length)return 0;
        if(cnt == 2){
            return 0; //idx - 1
        }
        if(memo[idx][cnt] != -1)return memo[idx][cnt];

        int skip = dfs(events, idx + 1, cnt);
        int nextIdx = upperBound(starts, events[idx][1]);
        // int nextIdx = Arrays.binarySearch(starts, events[idx][1] + 1); // inbuilt Binray search method
        // if(nextIdx < 0)nextIdx = -nextIdx - 1;
        // while(nextIdx < events.length && (events[idx][1] >= events[nextIdx][0])){ // this was taking O(n) time 
        //     nextIdx++;
        // }
        int take = events[idx][2] + dfs(events, nextIdx, cnt + 1);
        return memo[idx][cnt] = Math.max(take, skip);
    }

    public int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
