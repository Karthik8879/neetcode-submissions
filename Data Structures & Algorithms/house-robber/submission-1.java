class Solution {
    public int rob(int[] nums) {
        int start = 0;
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int ans = dp(nums, start, memo);
        return ans;
    }

    int dp(int[] nums, int start, int[] memo) {
        // base case
        if(start >= nums.length) {
            return 0;
        }
        // base case - memo
        if(memo[start] != -1) {
            return memo[start];
        }
        int max = 0; // becase we can't have robbed money less than 0
        for(int i = start; i < nums.length; i++) {
            // dp call
            int sum = nums[i] + dp(nums, i+2, memo);
            max = Math.max(max, sum);
        }
        return memo[start] = max;
    }
}
