class Solution {
    public int longestConsecutive(int[] nums) {
        // base case
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int cnt = 1, maxCnt = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i-1] == 1) {
                cnt++;
                maxCnt = Math.max(maxCnt, cnt);
            } else if(nums[i] == nums[i-1]) {
                continue;
            } else {
                cnt = 1;
            }
        }
        return maxCnt;
    }
}
