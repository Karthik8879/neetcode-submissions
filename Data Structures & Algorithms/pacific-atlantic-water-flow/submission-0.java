class Solution {
    class Custom {
        boolean pacific = false;
        boolean atlantic = false;
        Custom() {}
    }
    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        List<List<Integer>> res = new ArrayList<>(); // res that we have to return
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                boolean[][] visited = new boolean[n][m];
                Custom custom = new Custom();
                dfs(heights, i, j, visited, custom, n, m);
                if(custom.pacific && custom.atlantic) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    void dfs(int[][] heights, int row, int col, boolean[][] visited, Custom custom, int n, int m) {
        // marking current cell as visited
        visited[row][col] = true;

        // pacific --> top or left boundry
        if(row == 0 || col == 0) {
            custom.pacific = true;
        }

        // atlantic --> bottom or right boundry
        if(row == n-1 || col == m-1) {
            custom.atlantic = true;
        }

        // base case --> already reachable
        if(custom.pacific && custom.atlantic) {
            return;
        }

        // go through all of the directions
        for(int[] dir : DIRS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            

            // look for base cases wrt this
            // base case --> boundry check
            if(newRow < 0 || newCol < 0 || newRow >= n || newCol >= m) {
                continue;
            }

            // base case --> visited case
            if(visited[newRow][newCol]) {
                continue;
            }

            if(heights[newRow][newCol] > heights[row][col]) {
                continue;
            }

            // do dfs
            dfs(heights, newRow, newCol, visited, custom, n, m);

            // stop early if both are reachable
            if(custom.pacific && custom.atlantic) {
                return;
            }
        }
    }
}
