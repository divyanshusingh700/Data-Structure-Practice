class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int l = grid[0][0];
        int r = n*n - 1;
        
        int ans = r;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (canReachBFS(grid, mid)) {
                ans = mid;
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public boolean canReachBFS(int[][] grid, int t){
        int rows = grid.length;
        int cols = rows;
        if (grid[0][0] > t) return false;
        boolean[][] vis = new boolean[rows][cols];

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        vis[0][0] = true;

        while(!q.isEmpty()){
            int[] popped = q.poll();
            int r = popped[0], c = popped[1];
            if(r == rows - 1 && c == cols - 1)return true;

            for(int[] dir: dirs){
                int nr = r + dir[0], nc = c + dir[1];
                if(nr < 0 || nc < 0 || nr >= rows || nc >= cols || vis[nr][nc] || grid[nr][nc] > t)continue;
                vis[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }
        return false;
    }
}


// DFS TLE
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int l = grid[0][0];
        int r = n*n - 1;
        
        int ans = r;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (canReachBFS(grid, mid)) {
                ans = mid;
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public boolean canReachBFS(int[][] grid, int t){
        int rows = grid.length;
        int cols = rows;
        if (grid[0][0] > t) return false;
        boolean[][] vis = new boolean[rows][cols];

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        vis[0][0] = true;

        while(!q.isEmpty()){
            int[] popped = q.poll();
            int r = popped[0], c = popped[1];
            if(r == rows - 1 && c == cols - 1)return true;

            for(int[] dir: dirs){
                int nr = r + dir[0], nc = c + dir[1];
                if(nr < 0 || nc < 0 || nr >= rows || nc >= cols || vis[nr][nc] || grid[nr][nc] > t)continue;
                vis[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }
        return false;
    }
}

// Dijkstra Algorithm
class Solution {
    public int swimInWater(int[][] grid) {
        int rows = grid.length;
        int cols = rows;
        boolean[][] vis = new boolean[rows][cols];

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        q.offer(new int[]{grid[0][0], 0,0});
        vis[0][0] = true;

        while(!q.isEmpty()){
            int[] popped = q.poll();
            int t = popped[0];
            int r = popped[1], c = popped[2];
            if(r == rows - 1 && c == cols - 1)return t;

            for(int[] dir: dirs){
                int nr = r + dir[0], nc = c + dir[1];
                if(nr < 0 || nc < 0 || nr >= rows || nc >= cols || vis[nr][nc])continue;
                vis[nr][nc] = true;
                q.offer(new int[]{Math.max(t, grid[nr][nc]), nr, nc});
            }
        }
        return -1;
    }
}
