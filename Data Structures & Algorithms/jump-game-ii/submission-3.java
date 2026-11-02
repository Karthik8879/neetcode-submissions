class Solution {
    class Custom{
        boolean isValid = false;
        int cnt;
        Custom(boolean isValid, int cnt) {
            this.isValid = isValid;
            this.cnt = cnt;
        }
    }
    public int jump(int[] nums) {
        int n = nums.length;
        int start = 0;
        boolean isValid = false;
        int cnt = 0;
        Custom[] memo = new Custom[n];
        Custom ans = helper(nums, start, isValid, cnt, n, memo);
        return ans.cnt;
    }

    Custom helper(int[] nums, int start, boolean isValid, int cnt, int n, Custom[] memo) {
        // base case
        if(start == n-1) {
            return memo[start] = new Custom(true, cnt);
        }

        // base case --> memo return
        if(memo[start] != null) {
            return memo[start];
        }

        boolean reachable = false;
        int minCnt = Integer.MAX_VALUE;
        int maxJump = nums[start];

        for(int i = maxJump; i >= 1; i--) {
            // most important part of the jump is nextJump because we are going to be having the valid case based on this value 
            int nextJump = start + i;
            // if we have jump with n then we process it
            if(nextJump < n) {
                Custom ans = helper(nums, nextJump, isValid, cnt + 1, n, memo);
                // if we are able to get correct answer
                if(ans.isValid) {
                    reachable = true;
                    minCnt = Math.min(minCnt, ans.cnt);
                }
            }
        }
        if(reachable) {
            return memo[start] = new Custom(true, minCnt);
        }
        // not possible
        return memo[start] = new Custom(false, 0);
    }
}
