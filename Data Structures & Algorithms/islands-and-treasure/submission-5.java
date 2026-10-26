class Solution {
    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void islandsAndTreasure(int[][] grid) {
        // whenever we are given multiple targets and we have to find shortest distance, make sure that you are targetting all of the locations and traversing wrt that --> multi source BFS
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0) {
                    // add into the q if we are the target
                    q.offer(new int[]{i, j});
                }
            }
        }
        // step 2 - > RUN the BFS only 1 time
        bfs(grid, q, n, m);
    }

    void bfs(int[][] grid, Queue<int[]> q, int n, int m) {
        int distance = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];
                for(int[] dir : DIRS) {
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];
                    // base cases --> boundry
                    if(newRow < 0 || newCol < 0 || newRow >= n || newCol >= m) {
                        continue;
                    }
                    // base case --> look only for the inf because we have to populate that only
                    if(grid[newRow][newCol] != Integer.MAX_VALUE) {
                        continue;
                    }
                    grid[newRow][newCol] = distance+1;
                    q.offer(new int[]{newRow, newCol});
                }
            }
            distance++;
        }
    }
}
