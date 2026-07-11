class Solution {
    public int maxArea(int[] heights) {
        int low = 0, high = heights.length-1;
        int maxArea = 0, area = 0;
        while(low < high) {
            area = Math.min(heights[low], heights[high]) * (high - low);
            System.out.println(area);
            maxArea = Math.max(maxArea, area);
            if(heights[low] <= heights[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxArea;
    }
}
