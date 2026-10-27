class Solution {
    class Custom {
        boolean isPacific = false;
        boolean isAtlantic = false;
        Custom() {}
    }
    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                boolean[][] visited = new boolean[n][m];
                Custom custom = new Custom();
                dfs(heights, i, j, visited, custom, n, m, heights[i][j]);
                if(custom.isPacific && custom.isAtlantic) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    void dfs(int[][] heights, int row, int col, boolean[][] visited, Custom custom, int n, int m, int prevHeight) {
        // base case --> boundry case
        if(row < 0 || col < 0 || row >= n || col >= m) {
            return;
        }
        // base case --> already visited case
        if(visited[row][col]) {
            return;
        }
        // base case --> water cannot flow uphill
        if(heights[row][col] > prevHeight) {
            return;
        }
        // base case --> both oceans reached
        if(custom.isPacific && custom.isAtlantic) {
            return;
        }
        // mark as visited
        visited[row][col] = true;

        // Check Pacific boundary
        if (row == 0 || col == 0) {
            custom.isPacific = true;
        }

        // Check Atlantic boundary
        if (row == n - 1 || col == m - 1) {
            custom.isAtlantic = true;
        }

        // start with the dfs
        for(int[] dir : DIRS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            // call the dfs
            dfs(heights, newRow, newCol, visited, custom, n, m, heights[row][col]); // this is just 1 element neighbour prevHeight
        }
    }

}
