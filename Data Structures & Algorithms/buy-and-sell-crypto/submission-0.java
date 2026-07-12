class Solution {
    public int maxProfit(int[] prices) {
        int maxAns = 0;
        for(int i = 0; i < prices.length; i++) {
            for(int j = i+1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxAns = Math.max(maxAns, profit);
            }
        }
        return maxAns;
    }
}
