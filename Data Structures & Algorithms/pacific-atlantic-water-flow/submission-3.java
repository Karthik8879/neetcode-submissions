class Solution {
    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        List<List<Integer>> res = new LinkedList<>();
        // 2 visited matrices
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        // start dfs from left boundry and right boundry
        for(int i = 0; i < n; i++) {
            dfs(heights, i, 0, heights[i][0], pacific, n, m);
            dfs(heights, i, m-1, heights[i][m-1], atlantic, n, m);
        }
        for(int j = 0; j < m; j++) {
            dfs(heights, 0, j, heights[0][j], pacific, n, m);
            dfs(heights, n-1, j, heights[n-1][j], atlantic, n, m);
        }
        // finding both are populated for who all
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    void dfs(int[][] heights, int row, int col, int prevHeight, boolean[][] visited , int n, int m) {
        // base case --> boundry check
        if(row < 0 || col < 0 || row >= n || col >= m) {
            return;
        }
        // base case --> already vsisited
        if(visited[row][col]) {
            return;
        }
        // reverse water flow condition
        if(prevHeight > heights[row][col]) {
            return;
        }
        // mark as visited
        visited[row][col] = true;
        // start dfs
        for(int[] dir : DIRS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            dfs(heights, newRow, newCol, heights[row][col], visited, n, m);
        }
    }
}
