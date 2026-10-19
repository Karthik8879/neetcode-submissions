class Solution {
    int[][] DIRS = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}}; // any order is okay
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
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

    void dfs(char[][] grid, int r, int c, int n, int m ) {
        // base case -- > broundry values
        if(r < 0 || c < 0 || r >= n || c >= m || grid[r][c] != '1') {
            return;
        }

        // mark cell as visited
        grid[r][c] = '0';

        // call dfs wrt all directions
        for(int[] dir : DIRS) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            dfs(grid, newRow, newCol, n, m);
        }
    }
}
