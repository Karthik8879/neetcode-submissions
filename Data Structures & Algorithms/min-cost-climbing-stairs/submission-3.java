class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length+1];
        Arrays.fill(memo, -1);
        int start0 = dp(cost, 0, memo);
        int start1 = dp(cost, 1, memo);
        return Math.min(start0, start1);
    }

    int dp(int[] cost, int start, int[] memo) {
        // base case
        if(start >= cost.length) {
            return 0;
        }
        // base case --> memo case
        if(memo[start] != -1) {
            return memo[start];
        }
        int minCost = Integer.MAX_VALUE;
        for(int i = 1; i <= 2; i++) {
            // dp call
            int nextStep = dp(cost, start+i, memo);
            minCost = Math.min(minCost, nextStep);
        }
        return memo[start] = minCost + cost[start];
    }
}
