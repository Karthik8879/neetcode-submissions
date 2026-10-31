class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int sum = 0;
        int start = 0;
        int[][] memo = new int[n][amount+1];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(amount, coins, sum, start, n, memo);
    }

    int dp(int amount, int[] coins, int sum, int start, int n, int[][] memo) {
        // base case
        if(start == n) {
            return 0;
        }
        // base case
        if(sum > amount) {
            return 0;
        }
        // base case
        if(sum == amount) {
            return 1;
        }
        // base case --> memo return
        if(memo[start][sum] != -1) {
            return memo[start][sum];
        }
        // maintain variable to increment
        int cnt = 0;
        for(int i = start; i < n; i++) {
            //store the sum
            int nextSum = sum + coins[i];
            cnt += dp(amount, coins, nextSum, i, n, memo); // we can reuse infinite time so keep i not i+1
        }
        return memo[start][sum] = cnt;
    }
}
