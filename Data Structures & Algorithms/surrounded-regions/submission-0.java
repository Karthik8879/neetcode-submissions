class Solution {
    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        // we are going to be keeping a visited to keep track of the 0's which are connected to the boundries
        boolean[][] visited = new boolean[n][m];
        // we are going to be traversing wrt the boundries
        for(int i = 0; i < n; i++) {
            // we have to make sure that it is not visited and also it is a 0
            if(board[i][0] == 'O' && !visited[i][0]) {
                dfs(board, i, 0, visited, n, m); // first column
            }
            if(board[i][m-1] == 'O' && !visited[i][m-1]) {
                dfs(board, i, m-1, visited, n, m); // last colum
            }
        }
        for(int j = 0; j < m; j++) {
            // we have to make sure that it is not visited and also it is a 0
            if(board[0][j] == 'O' && !visited[0][j]) {
                dfs(board, 0, j, visited, n, m); // first row
            }
            if(board[n-1][j] == 'O' && !visited[n-1][j]) {
                dfs(board, n-1, j, visited, n, m); // last row
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j]) {
                    board[i][j] = 'X'; // marking the cells which are O and which are connected to the boundry as X
                }
            }
        }
    }

    void dfs(char[][] board, int row, int col, boolean[][] visited, int n, int m) {
        // base case --> boundry check
        if(row < 0 || col < 0 || row >= n || col >= m) {
            return;
        }
        // base case --> visited check
        if(visited[row][col]) {
            return;
        }
        // base case --> O check
        if(board[row][col] != 'O') {
            return;
        }
        // mark O to X - by doing visited[row][col] as true
        visited[row][col] = true;
        // start dfs
        for(int[] dir : DIRS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            // calling dfs
            dfs(board, newRow, newCol, visited, n, m);
        }
    }
}
