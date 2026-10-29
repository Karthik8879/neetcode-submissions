class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int start = 0;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        int ans = dp(nums, 0, n, memo);
        return ans;
    }

    int dp(int[] nums, int start, int n, int[] memo) {
        // base case 
        if(start >= nums.length) {
            return 0;
        }
        // base case --> memo return case
        if(memo[start] != -1) {
            return memo[start];
        }
        int max = 0;
        for(int i = start; i < n; i++) {
            // call dp
            int sum = nums[i] + dp(nums, i+2, n, memo);
            max = Math.max(max, sum);
        }
        return memo[start] = max;
    }
}
