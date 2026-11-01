class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(i > maxReach) {
                return false;
            }
            int nextReach = i + nums[i];
            maxReach = Math.max(maxReach, nextReach);
            // if we have reached or passed the end return
            if(maxReach >= n-1) {
                return true;
            }
        }
        return true;
    }
}
