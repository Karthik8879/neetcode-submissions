class Solution {
    // [10,1,5,6,7,1]
    // [10,1,5,6,7,1]
    //      l      h
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int low = 0, high = 1;
        while(high < prices.length) {
            int profit = prices[high] - prices[low];
            while(high < prices.length && prices[high] - prices[low] >= 0) {
                profit = prices[high] - prices[low];
                maxProfit = Math.max(maxProfit, profit);
                high++;
            }
            low = high; high = low+1;
        }
        return maxProfit;
    }
}

