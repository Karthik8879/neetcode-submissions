class Solution {
    class Custom{
        boolean isValid = false;
        int cnt = 0;
        Custom(boolean isValid, int cnt) {
            this.isValid = isValid;
            this.cnt = cnt;
        }
    }
    public int jump(int[] nums) {
        int n = nums.length;
        int start = 0;
        int cnt = 0;
        boolean isValid = false;
        Custom[] memo = new Custom[n];
        Custom ans = helper(nums, start, cnt, isValid, n, memo);
        return ans.cnt;
    }

    Custom helper(int[] nums, int start, int cnt, boolean isValid, int n, Custom[] memo) {
        // base case
        if(start == n-1) {
            return memo[start] = new Custom(true, cnt);
        }
        // base case --> memo return
        if(memo[start] != null) {
            return memo[start];
        }
        int min = Integer.MAX_VALUE;
        int maxJump = nums[start]; // start idx 
        boolean reachable = false;
        // Try every possible jump length from maxJump down to 1
        for (int jump = maxJump; jump >= 1; jump--) {
            int nextJump = start + jump;
            // BECAUSE we must strictly reach n-1 not go beyond it
            if(nextJump < n) {
                Custom ans = helper(nums, nextJump, cnt+1, isValid, n, memo);
                if(ans.isValid) {
                    reachable = true;
                    min = Math.min(min, ans.cnt);
                }
            }
        }
        if(reachable) {
            return memo[start] = new Custom(true, min);
        }
        return memo[start] = new Custom(false, 0); // invalid case
    }
}
