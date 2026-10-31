class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int start = 0;
        int canBuy = 1;
        int[][] memo = new int[n][2];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(prices, start, n, canBuy, memo);
    }

    int dp(int[] prices, int start, int n, int canBuy, int[][] memo) {
        // base case -->
        if(start >= n) {
            return 0;
        }
        // base case --> memo return
        if(memo[start][canBuy] != -1) {
            return memo[start][canBuy];
        }
        // 3 cases
        // 1. buy case
        // 1.a --> custom condition before buying
        if(canBuy == 1) {
            int buy = -prices[start] + dp(prices, start+1, n, 0, memo);
            int skip = dp(prices, start+1, n, 1, memo);
            return memo[start][canBuy] = Math.max(buy, skip);
        } else {
            // 3. hold case
            int hold = dp(prices, start+1, n, 0, memo);
            // 2. sell case
            int sell = prices[start] + dp(prices, start+2, n, 1, memo);
            return memo[start][canBuy] = Math.max(sell, hold);
        }
    }
}
