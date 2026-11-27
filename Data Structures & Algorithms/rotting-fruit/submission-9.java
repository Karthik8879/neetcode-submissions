class Solution {
    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int cnt = 0;
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        System.out.println(q.size());
        backtrack(grid, q, n, m);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return cnt;
    }


    void backtrack(int[][] grid, Queue<int[]> q, int n, int m) {
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int row = cell[0];
                int col = cell[1];
                for(int[] dir : DIRS) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    // base case --> boundry case
                    if(newRow < 0 || newCol < 0 || newRow >= n || newCol >= m) {
                        continue;
                    }
                    // base case - other case
                    if(grid[newRow][newCol] == 2 || grid[newRow][newCol] == 0) {
                        continue;
                    }
                    // mark fruit as rotten
                    grid[newRow][newCol] = 2;
                    q.offer(new int[]{newRow, newCol});
                }
            }
            if(q.size() > 0) cnt++;
        }
    }
}
