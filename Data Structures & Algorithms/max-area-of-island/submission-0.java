class Solution {
    int[][] DIRS = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}}; // any order is okay
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int area = 0;
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    area = dfs(grid, i, j, n, m);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    int dfs(int[][] grid, int r, int c, int n, int m) {
        // base case -- > broundry values
        if(r < 0 || c < 0 || r >= n || c >= m || grid[r][c] != 1) {
            return 0;
        }

        // mark cell as visited
        grid[r][c] = 0;

        // count current cell
        int cnt = 1;

        // call dfs wrt all directions
        for(int[] dir : DIRS) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            cnt += dfs(grid, newRow, newCol, n, m);
        }
        return cnt;
    }
}