class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int start = 0;
        int target = 0;
        for(int i = 0; i < nums.length; i++) {
            target += nums[i];
        }
        if(target % 2 != 0) return false;
        target = target / 2;
        int sum = 0;
        return dp(nums, start, sum, target, n);
    }

    boolean dp(int[] nums, int start, int sum, int target, int n) {
        // base case
        if(sum > target) {
            return false;
        }
        if(sum == target) {
            return true;
        }
        for(int i = start; i < n; i++) {
            int currSum = sum + nums[i];
            if(dp(nums, i+1, currSum, target, n)) {
                return true;
            }
        }
        return false;
    }
}
