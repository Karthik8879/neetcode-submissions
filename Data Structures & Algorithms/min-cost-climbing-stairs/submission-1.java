class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length+1];
        Arrays.fill(memo, -1);
        int start0 = dp(cost, 0, memo);
        int start1 = dp(cost, 1, memo);
        return Math.min(start0, start1);
    }

    int dp(int[] cost, int start, int[] memo) {
        // base case --> return case
        if(start >= cost.length) {
            return 0;
        }
        // base case --> memo --> return
        if(memo[start] != -1) {
            return memo[start];
        }
        int nextStep = 0;
        int minCost = Integer.MAX_VALUE;
        for(int step = 1; step <= 2; step++) {
            nextStep = dp(cost, start+step, memo);
            minCost = Math.min(minCost, nextStep);
        }
        return memo[start] = cost[start] + minCost;
    }
}
