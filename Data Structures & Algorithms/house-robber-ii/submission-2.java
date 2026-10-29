class Solution {
    public int rob(int[] nums) {
        // base case --> when we have only 1 or less # elements
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        int skipFirst = dp(nums, 0, n-1, memo);
        // we will have to populate the memo again wrt -1 so that we can start fresh for the new problem
        Arrays.fill(memo, -1);
        int skipLast = dp(nums, 1, n, memo);
        return Math.max(skipFirst, skipLast);
    }

    int dp(int[] nums, int start, int end, int[] memo) {
        // base case
        if(start >= end) {
            return 0;
        }
        // base case --> memo return case
        if(memo[start] != -1) {
            return memo[start];
        }
        int max = 0;
        for(int i = start; i < end; i++) {
            // dp call
            int sum = nums[i] + dp(nums, i+2, end, memo);
            max = Math.max(max, sum);
        }
        return memo[start] = max;
    }
}
