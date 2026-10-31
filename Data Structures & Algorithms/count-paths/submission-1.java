class Solution {
    int[][] DIRS = {{0, 1}, {1, 0}}; // only right and down are allowed
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(0, 0, m, n, memo);
    }

    int dp(int row, int col, int m, int n, int[][] memo) {
        // base case --> boundry cases
        if(row >= m || col >= n) {
            return 0;
        }
        // base case --> success case
        if(row == m-1 && col == n-1) {
            return 1;
        }
        // base case --> memoization return case
        if(memo[row][col] != -1) {
            return memo[row][col];
        }

        // storing ans
        int ans = 0;
        // dp
        for(int[] dir : DIRS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            // dp call
            ans += dp(newRow, newCol, m, n, memo);
        }
        return memo[row][col] = ans;
    }
}
