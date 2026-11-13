class Solution {
    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'O' && (i == 0 || j == 0 || i == n-1 || j == m-1)) {
                    board[i][j] = '#';
                    q.offer(new int[]{i, j});
                }
            }
        }
        bfs(board, q, n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    void bfs(char[][] board, Queue<int[]> q, int n, int m) {
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int row = cell[0];
                int col = cell[1];
                for(int[] dir : DIRS) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    // base case --> boundry cases
                    if(newRow < 0 || newCol < 0 || newRow >= n || newCol >= m) {
                        continue;
                    }
                    // base case --> is != 0 then continue
                    if(board[newRow][newCol] != 'O') {
                        continue;
                    }
                    board[newRow][newCol] = '#';
                    // mark that particular as visited
                    q.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}
