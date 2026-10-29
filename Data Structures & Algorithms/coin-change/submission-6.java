class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int start = 0;
        int sum = 0;
        int[][] memo = new int[n][amount+1];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int ans = dp(coins, start, sum, n, amount, memo);
        return ans != Integer.MAX_VALUE ? ans : -1;
    }

    int dp(int[] coins, int start, int sum, int n, int amount, int[][] memo) {
        // base case --> we have reached the end
        if(start >= n) {
            return Integer.MAX_VALUE;
        }
        // base case
        if(sum == amount) { // we have reached and we do not require another coins for our answer
            return 0;
        }
        if(sum > amount) {
            return Integer.MAX_VALUE;
        }
        // base case --> memo return
        if(memo[start][sum] != -1) {
            return memo[start][sum];
        }
        int minCoins = Integer.MAX_VALUE;
        for(int i = start; i < n; i++) {
            if(coins[i] > amount) {
                continue;
            }
            int nextSum = coins[i] + sum;
            int remainingCoins = dp(coins, i, nextSum, n, amount, memo);
            if(remainingCoins != Integer.MAX_VALUE) {
                int totalCoins = 1 + remainingCoins;
                minCoins = Math.min(minCoins, totalCoins);
            }
        }
        return memo[start][sum] = minCoins;
    }
}
