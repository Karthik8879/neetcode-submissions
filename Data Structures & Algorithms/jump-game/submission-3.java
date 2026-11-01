class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int start = 0;
        Boolean[] memo = new Boolean[n];
        return helper(nums, start, n, memo);
    }

    private boolean helper(int[] nums, int start, int n, Boolean[] memo) {
        // Reached or passed the last index
        if (start >= n-1) {
            return true;
        }
        // base case --> memo return
        if(memo[start] != null) {
            return memo[start];
        }

        int maxJump = nums[start]; // start idx 
        // Try every possible jump length from maxJump down to 1
        for (int jump = maxJump; jump >= 1; jump--) {
            int nextJump = start + jump;
            if (helper(nums, nextJump, n, memo)) {
                return memo[start] = true;
            }
        }

        return memo[start] = false;
    }
}