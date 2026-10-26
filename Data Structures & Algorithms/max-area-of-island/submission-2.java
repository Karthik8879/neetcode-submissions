class Solution {
    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int maxArea = 0;
    int area = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
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

    int dfs(int[][] grid, int row, int col, int n, int m) {
        // base case --> border cases
        if(row < 0 || col < 0 || row >= n || col >= m) {
            return 0;
        }
        // base case
        if(grid[row][col] != 1) {
            return 0;
        }
        int cnt = 1;
        // visited
        grid[row][col] = -1;
        for(int[] dir : DIRS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            cnt += dfs(grid, newRow, newCol, n, m);
        }
        return cnt;
    }
}
