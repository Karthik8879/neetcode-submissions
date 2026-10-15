class Solution {
    public int maxArea(int[] heights) {
        int low = 0;
        int high = heights.length-1;
        int maxWater = Integer.MIN_VALUE;
        while(low < high) {
            int water = Math.min(heights[low], heights[high]) * (high - low);
            maxWater = Math.max(maxWater, water);
            if(heights[low] <= heights[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxWater;
    }
}
