class Solution {
    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxCnt = 0;
        int cnt = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    cnt = dfs(grid, i, j, n, m);
                    maxCnt = Math.max(maxCnt, cnt);
                }
            }
        }
        return maxCnt;
    }

    int dfs(int[][] grid, int row, int col, int n, int m) {
        // base case --> boundry case
        if(row < 0 || col < 0 || row >= n || col >= m) {
            return 0;
        }
        // base case --> visited
        if(grid[row][col] != 1) {
            return 0;
        }
        // mark as visited
        grid[row][col] = 0;
        int cnt = 1;
        for(int[] dir : DIRS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            cnt += dfs(grid, newRow, newCol, n, m);
        }
        return cnt;
    }
}
