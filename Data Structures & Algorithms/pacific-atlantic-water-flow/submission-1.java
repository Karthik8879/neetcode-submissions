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
                dfs(heights, i, j, visited, custom, n, m);
                if(custom.isPacific && custom.isAtlantic) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    void dfs(int[][] heights, int row, int col, boolean[][] visited, Custom custom, int n, int m) {
        // mark visited
        visited[row][col] = true;
        // pacific
        if(row == 0 || col == 0) {
            custom.isPacific = true;
        }
        if(row == n-1 || col == m-1) {
            custom.isAtlantic = true;
        }

        // if we have both then we have to return
        if(custom.isPacific && custom.isAtlantic) {
            return;
        }

        // go through all of the directions
        for(int[] dir : DIRS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            // base cases --> boundry check
            if(newRow < 0 || newCol < 0 || newRow >= n || newCol >= m) {
                continue;
            }
            // base case --> visited
            if(visited[newRow][newCol]) {
                continue;
            }
            if(heights[newRow][newCol] > heights[row][col]) {
                continue;
            }
            // call the dfs
            dfs(heights, newRow, newCol, visited, custom, n, m);
            if(custom.isPacific && custom.isAtlantic) {
                return;
            }
        }
    }

}
