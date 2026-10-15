class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int start = 0, end = 1;
        while(end < prices.length) {
            int profit = prices[end] - prices[start];
            while(end < prices.length && profit >= 0) {
                profit = prices[end] - prices[start];
                maxProfit = Math.max(maxProfit, profit);
                end++;
            }
            start++;
            end = start+1;
        }
        return maxProfit;
    }
}
