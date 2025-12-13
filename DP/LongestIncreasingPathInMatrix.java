public class LongestIncreasingPathInMatrix {
    int mx;
    public int longestIncreasingPath(int[][] matrix) {
        mx = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        Integer[][] visited = new Integer[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dfs(matrix, i, j, visited);
                // visited[i][j] = val;
            }
        }
        return mx;
    }
    public int dfs(int[][] matrix, int i, int j, Integer[][] visited){
        // if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length )return 0;
        if(visited[i][j] != null)return visited[i][j];

        int n = matrix.length;
        int m = matrix[0].length;
        
        int best = 1;

        // top
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            best = Math.max(best, 1 + dfs(matrix, i - 1, j, visited));
        }

        // bottom
        if (i + 1 < n && matrix[i + 1][j] > matrix[i][j]) {
            best = Math.max(best, 1 + dfs(matrix, i + 1, j, visited));
        }

        // left
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            best = Math.max(best, 1 + dfs(matrix, i, j - 1, visited));
        }

        // right
        if (j + 1 < m && matrix[i][j + 1] > matrix[i][j]) {
            best = Math.max(best, 1 + dfs(matrix, i, j + 1, visited));
        }

        visited[i][j] = best;
        mx = Math.max(mx, best);

        return best;
    }
}
