class Solution {
    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
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

    void bfs(char[][] grid, int row, int col, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        // mark as visited
        grid[row][col] = '0';

        // looping through the queue
        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            // go towards all of the direction
            for(int[] dir : DIRS) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                // base cases - boundry checks
                if(newRow < 0 || newCol < 0 || newRow >= n || newCol >= m) {
                    continue;
                }

                // base case
                if(grid[newRow][newCol] != '1') {
                    continue;
                }

                // mark as read
                grid[newRow][newCol] = '0';
                
                // add into the q
                q.offer(new int[]{newRow, newCol});

                bfs(grid, newRow, newCol, n, m);
            }
        }
    }
}
