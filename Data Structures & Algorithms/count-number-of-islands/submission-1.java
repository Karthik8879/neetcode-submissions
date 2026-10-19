class Solution {

    int[][] DIRS = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}}; // global level variable

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
        // base case --> bound check
        if(r < 0 || c < 0 || r >= n || c >= m || grid[r][c] != '1') return;

        // marking the cell as visited
        grid[r][c] = '0';

        // explore all of the directions
        for(int[] dir : DIRS) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            dfs(grid, newRow, newCol, n, m);
        }
    }
}
