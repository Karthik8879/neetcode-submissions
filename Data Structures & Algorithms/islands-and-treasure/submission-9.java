class Solution {
    int[][] DIRS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        int distance = 0;
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
                    // base case --> if not inf 
                    if(grid[newRow][newCol] != Integer.MAX_VALUE) {
                        continue;
                    }
                    grid[newRow][newCol] = distance + 1;
                    q.offer(new int[]{newRow, newCol});
                }
            }
            distance++;
        }
    }
}
