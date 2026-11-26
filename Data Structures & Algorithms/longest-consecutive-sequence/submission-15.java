class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }
        if(hs.size() == 1) {
            return 1;
        }
        int maxCnt = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int cnt = 0;    
            int ele = nums[i];
            if(hs.contains(ele-1)) {
                continue;
            }
            while(hs.contains(ele)) {
                cnt++;
                ele++;
            }
            maxCnt = Math.max(maxCnt, cnt);
        }   
        return maxCnt;
    }
}
