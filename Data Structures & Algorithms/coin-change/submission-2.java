class Solution {
    public int coinChange(int[] coins, int amount) {
        // Arrays.sort(coins);
        int n = coins.length;
        int start = 0;
        int sum = 0;
        int ans = dp(coins, start, n, sum, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    int dp(int[] coins, int start, int n, int sum, int amount) {
        // base case
        if(start >= n) {
            return Integer.MAX_VALUE;
        }
        if(sum > amount) {
            return Integer.MAX_VALUE;
        }
        if(sum == amount) {
            return 0; // because we require 0 more coins to complete this amount
        }
        int minCoins = Integer.MAX_VALUE;
        for (int i = start; i < n; i++) {
            int nextSum = sum + coins[i];
            // Minimum additional coins needed after this choice
            int remainingCoins = dp(coins, i, n, nextSum, amount);
            if (remainingCoins != Integer.MAX_VALUE) {
                // Count the coin selected now + coins needed later
                int totalCoins = 1 + remainingCoins;
                minCoins = Math.min(minCoins, totalCoins);
            }
        }
        return minCoins;
    }
}
