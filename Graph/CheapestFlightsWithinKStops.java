import java.util.*;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        int[] dist = new int[n];
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for(int[] flight: flights){
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});
        dist[src] = 0;
        int steps = 0;

        while(!q.isEmpty() && steps <= k){
            int N = q.size();
            while(N > 0){
                int[] popped = q.poll();
                for(int[] pair: adj.get(popped[0])){
                    if(pair[1] + popped[1] < dist[pair[0]]){
                        dist[pair[0]] = pair[1] + popped[1];
                        q.offer(new int[]{pair[0], dist[pair[0]]});
                    }
                }
                N--;
            }
            steps++;
        }
        if(dist[dst] == Integer.MAX_VALUE)return -1;
        return dist[dst];
    }
}


class Solution {
    List<List<int[]>> adj;
    int[][] memo;
    int INF = 1_000_000_00;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        adj = new ArrayList<>();
        memo = new int[n][k + 2];    // k stops → k+1 edges
        for (int i = 0; i < n; i++) Arrays.fill(memo[i], -1);

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] f : flights)
            adj.get(f[0]).add(new int[]{f[1], f[2]});

        int ans = dfs(src, dst, k + 1);  // k stops = k+1 edges allowed
        return ans >= INF ? -1 : ans;
    }

    private int dfs(int node, int dst, int stops) {
        if (node == dst) return 0;   // reached destination
        if (stops == 0) return INF;  // no more edges allowed

        if (memo[node][stops] != -1) return memo[node][stops];

        int minCost = INF;

        for (int[] edge : adj.get(node)) {
            int nei = edge[0], price = edge[1];
            int cost = dfs(nei, dst, stops - 1);
            if (cost != INF)
                minCost = Math.min(minCost, price + cost);
        }

        memo[node][stops] = minCost;
        return minCost;
    }
}
