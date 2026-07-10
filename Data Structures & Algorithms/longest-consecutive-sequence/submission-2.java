class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        for(int ele : nums) {
            System.out.println(ele);
        }
        int currLen = 1, maxLen = 1;    
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i-1] == 1) {
                currLen++;
                maxLen = Math.max(maxLen, currLen); 
            } else if(nums[i] - nums[i-1] == 0) {
                continue;
            } else {
                currLen = 1;
            }
        }
        return maxLen;
    }
}
