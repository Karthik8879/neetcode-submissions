class Solution {
    int[][] DIRS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int numIslands(char[][] grid) {
        int cnt = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, i, j, n, m);
                }
            }
        }
        return cnt;
    }

    void dfs(char[][] grid, int row, int col, int n, int m) {
        // base case --> boundry case
        if(row < 0 || col < 0 || row >= n || col >= m) {
            return;
        }
        // base case --> not 1
        if(grid[row][col] != '1') {
            return;
        }

        // mark as visited
        grid[row][col] = '0';

        for(int[] dir : DIRS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            dfs(grid, newRow, newCol, n, m);
        }
    }
}
