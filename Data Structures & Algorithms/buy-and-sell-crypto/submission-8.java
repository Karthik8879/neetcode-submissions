class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int n = prices.length;
        int low = 0, high = 1;
        while(high < n) {
            int profit = prices[high] - prices[low];
            if(profit < 0) {
                low = high;
            } 
            maxProfit = Math.max(maxProfit, profit);
            high++;
        }
        return maxProfit < 0 ? 0 : maxProfit;
    }
}
