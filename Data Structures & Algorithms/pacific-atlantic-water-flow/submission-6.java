class Solution {
    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    class Custom{
        int row;
        int col;
        boolean isPacific;
        boolean isAtlantic;
        Custom(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        Queue<Custom> qP = new LinkedList<>();
        Queue<Custom> qA = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        Custom[][] cells = new Custom[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                cells[i][j] = new Custom(i, j);
                if(i == 0 || j == 0) {
                    cells[i][j].isPacific = true;
                    qP.offer(cells[i][j]);
                }
                if(i == n-1 || j == m-1) {
                    cells[i][j].isAtlantic = true;
                    qA.offer(cells[i][j]);
                }
            }
        }

        bfs(heights, cells, qP, true, false, n, m);
        bfs(heights, cells, qA, false, true, n, m);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(cells[i][j].isPacific && cells[i][j].isAtlantic) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    void bfs(int[][] heights, Custom[][] cells, Queue<Custom> q, boolean pacific, boolean atlantic, int n, int m) {
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Custom cell = q.poll();
                int row = cell.row;
                int col = cell.col;
                for(int[] dir : DIRS) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    // base case --> boundry case
                    if(newRow < 0 || newCol < 0 || newRow >= n || newCol >= m) {
                        continue;
                    }
                    // base caes --> if smaller
                    if(heights[newRow][newCol] < heights[row][col]) {
                        continue;
                    }
                    // marking pacific as visited
                    if(pacific) {
                        if(cells[newRow][newCol].isPacific) {
                            continue;
                        }
                        cells[newRow][newCol].isPacific = true;
                    }

                    // mark atlantic as visited
                    if(atlantic) {
                        if(cells[newRow][newCol].isAtlantic) {
                            continue;
                        }
                        cells[newRow][newCol].isAtlantic = true;
                    }
                    // offer into the q
                    q.offer(cells[newRow][newCol]);
                }
            }
        }
    }
}
