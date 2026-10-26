class Solution {
    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshOrangeCnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if(grid[i][j] == 1) {
                    freshOrangeCnt++;
                }
            }
        }
        int minOperations =  bfs(grid, q, freshOrangeCnt, n, m); 
        return minOperations;
    }

    int bfs(int[][] grid, Queue<int[]> q, int freshOrangeCnt, int n, int m) {
        int cnt = 0;
        while(!q.isEmpty() && freshOrangeCnt > 0) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];
                // visit all of the directions because we do not have anything to calculate
                for(int[] dir : DIRS) {
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];
                    // base cases -> boundry
                    if(newRow < 0 || newCol < 0 || newRow >= n || newCol >= m) {
                        continue;
                    }
                    // base case -> if anything we do not want to consider into q
                    if(grid[newRow][newCol] != 1) {
                        continue;
                    }
                    // we are going to be appending into the queue
                    q.offer(new int[]{newRow, newCol});
                    // we are also going to be marking them as rotten
                    grid[newRow][newCol] = 2;
                    // when we do this we are also going to be reducing the freshCnt at the same time
                    freshOrangeCnt--;
                }
            }
            // storing the cnt
            cnt++;
        }
        return freshOrangeCnt == 0 ? cnt : -1;
    }
}
