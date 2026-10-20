class Solution {
    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
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
        // base case boundry checks
        if(r < 0 || c < 0 || r >= n || c >= m) {
            return 0;
        }

        // base case
        if(grid[r][c] != 1) {
            return 0;
        }

        int cnt = 1;

        // mark as visited
        grid[r][c] = 0;

        for(int[] dir : DIRS) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            cnt += dfs(grid, newRow, newCol, n, m);
        }

        return cnt;
    }
}
