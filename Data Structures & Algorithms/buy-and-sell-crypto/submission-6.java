class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int n = prices.length;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit < 0 ? 0 : maxProfit;
    }
}
