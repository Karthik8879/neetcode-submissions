class Solution {
    public int longestConsecutive(int[] nums) {
        // base case
        if(nums.length == 0) return 0;
        // Populating the HashSet
        HashSet<Integer> hs = new HashSet<>();
        for(int ele : nums) {
            hs.add(ele);
        }

        int maxLen = 0;

        for(int ele : hs) {
            // if not start of sequence
            if(hs.contains(ele-1)) continue;
            else {
                int curr = ele;
                int len = 1;
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
