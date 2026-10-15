class Solution {
    public int longestConsecutive(int[] nums) {
        // base case
        if(nums.length == 0) return 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }

        int maxLen = 0;
        for(int ele : hs) {
            if(hs.contains(ele-1)) continue; // not the start of the sequence
            else {
                int len = 1;
                int curr = ele;
                while(hs.contains(curr+1)) {
                    curr++;
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
