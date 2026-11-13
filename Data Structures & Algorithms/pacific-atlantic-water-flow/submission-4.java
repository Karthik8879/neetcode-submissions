class Solution {
    int[][] DIRS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    class Custom {
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
        Custom[][] cells = new Custom[n][m];
        Queue<Custom> qP = new LinkedList<>();
        Queue<Custom> qA = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                Custom cell = new Custom(i, j);
                cells[i][j] = cell;

                if(i == 0 || j == 0) {
                    cell.isPacific = true;
                    qP.offer(cell);
                }

                if(i == n-1 || j == m-1) {
                    cell.isAtlantic = true;
                    qA.offer(cell);
                }
            }
        }

        bfs(heights, cells, qP, true, n, m);
        bfs(heights, cells, qA, false, n, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cells[i][j].isPacific && cells[i][j].isAtlantic) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    void bfs(int[][] heights, Custom[][] cells, Queue<Custom> q, boolean pacific, int n, int m) {
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
                    // base case --> smaller then we can't reach so skip
                    if(heights[newRow][newCol] < heights[row][col]) {
                        continue;
                    }
                    Custom next = cells[newRow][newCol];
                    if(pacific) {
                        if(next.isPacific) {
                            continue; // already visited
                        }
                        next.isPacific = true;
                    } else {
                        if(next.isAtlantic) {
                            continue; // already visited
                        }
                        next.isAtlantic = true;
                    }
                    q.offer(next);
                }
            }
        }
    }
}
