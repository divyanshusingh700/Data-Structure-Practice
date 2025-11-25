class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int[] dis = new int[n + 1];
        List<List<int[]>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        for(int i = 1; i < n + 1; i++){
            dis[i] = Integer.MAX_VALUE;
            adj.add(new ArrayList<>());
        }
        dis[k] = 0;
        for(int i = 0; i < times.length; i++){
            int u = times[i][0];
            int v = times[i][1];
            int wt = times[i][2];
            adj.get(u).add(new int[]{v, wt});
        }

        pq.offer(new int[]{k, 0});

        while(!pq.isEmpty()){
            int[] popped = pq.poll();
            int poppedWt = popped[1];
            int poppedNode = popped[0];
            for(int[] node: adj.get(poppedNode)){
                int adjNode = node[0];
                int adjWt = node[1];
                if(poppedWt + adjWt < dis[adjNode]){
                    dis[adjNode] = poppedWt + adjWt;
                    pq.offer(new int[]{adjNode, dis[adjNode]});
                }
            }
        }
        int ans = -1;
        for(int i = 1; i < n + 1; i++){
            ans = Math.max(ans, dis[i]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}