class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int start = 0;
        int prevIdx = -1;
        int[][] memo = new int[n][n+1]; // because prevIdx start at -1 instead of 0
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(nums, start, prevIdx, n, memo);
    }

    int dp(int[] nums, int start, int prevIdx, int n, int[][] memo) {
        // base case
        if(start == n) {
            return 0;
        }

        // base case --> memo return
        if(memo[start][prevIdx+1] != -1) {
            return memo[start][prevIdx+1];
        }

        // skip the current element
        int skip = dp(nums, start+1, prevIdx, n, memo);

        // take the current element
        int pick = 0;
        if(prevIdx == -1 || nums[start] > nums[prevIdx]) {
            pick = 1 + dp(nums, start+1, start, n, memo);
        }
        return memo[start][prevIdx+1] = Math.max(skip, pick);
    }
}
