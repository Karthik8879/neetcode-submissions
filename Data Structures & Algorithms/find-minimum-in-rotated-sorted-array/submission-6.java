class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = nums.length-1;
        int minArray = Integer.MAX_VALUE;
        while(low < high) {
            int mid = low + (high - low) / 2;
            minArray = nums[mid];
            if(nums[mid] > nums[high]) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return nums[high];
    }
}
