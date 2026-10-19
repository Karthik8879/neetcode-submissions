class Solution {
    // over here because we are already given a grid we do not have to build an adj matrix
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

    void dfs(char[][] grid, int r, int c, int n, int m) {
        // base cases -> boundry checks
        if(r < 0 || c < 0 || r >= n || c >= m || grid[r][c] != '1') return;

        grid[r][c] = '0'; // marking visited so that we don't see this again

        // go to all the positions and check them
        dfs(grid, r+1, c, n, m);
        dfs(grid, r, c+1, n, m);
        dfs(grid, r-1, c, n, m);
        dfs(grid, r, c-1, n, m);

        // here we do not have to backtrack because we are never going to be considering that cell again
    }
}
