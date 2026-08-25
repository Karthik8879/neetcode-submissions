class Solution {
    public boolean hasDuplicate(int[] nums) {
        //  nums = [1, 2, 3, 3]
        // loop and keep adding into hs and chec if already present in hs
        // base case
        if(nums.length == 0) return false;
        HashSet<Integer> hs = new HashSet<>();
        hs.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            if(hs.contains(nums[i])) return true;
            hs.add(nums[i]);
        }
        return false;

        // sort and find consecutive elements are same or not
        
        // xor we can find the duplicate element but not if it exists or not
    }
}