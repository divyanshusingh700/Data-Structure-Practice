package Graph;

import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)adj.add(new ArrayList<>());
        for(int i = 0;  i< n; i++){
            for(int j = i + 1; j < n; j++){
                int x1 = points[i][0], y1 = points[i][1], x2 = points[j][0], y2 = points[j][1];
                int cost = Math.abs(x2 - x1) + Math.abs(y2 - y1);
                adj.get(i).add(new int[]{j, cost});
                adj.get(j).add(new int[]{i, cost});

            }
        }

        // Prims algo

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        minHeap.add(new int[]{0, 0});
        int[] vis = new int[n];
        int ans = 0;
        while(!minHeap.isEmpty()){
            int[] node = minHeap.poll();
            int v = node[0];
            int wt = node[1];
            if(vis[v] == 1)continue;
            ans+=wt;vis[v] = 1;
            for(int[] p: adj.get(v)){
                if(vis[p[0]] == 0){
                    minHeap.offer(p);
                }
            }
        }
        return ans;
    }
}