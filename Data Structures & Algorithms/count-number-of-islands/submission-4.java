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
                    bfs(grid, i, j, n, m);
                }
            }
        }
        return cnt;
    }

    void bfs(char[][] grid, int r, int c, int n, int m ) {
        Queue<int[]> q = new LinkedList<>();
        // mark as visited
        grid[r][c] = '0';
        // add into the q
        q.offer(new int[]{r, c});

        // looping through the queue
        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];
            // exploring all of the direction
            for(int[] dir : DIRS) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // boundry check
                if(newRow < 0 || newCol < 0 || newRow >= n || newCol >= m) {
                    continue;
                }

                if(grid[newRow][newCol] != '1') {
                    continue;
                }

                // mark visited - cell
                grid[newRow][newCol] = '0';

                // add into the q
                q.offer(new int[]{newRow, newCol});
            }
        }
    }
}
