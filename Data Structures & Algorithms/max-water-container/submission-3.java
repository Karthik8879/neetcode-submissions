class Solution {

    public int maxArea(int[] heights) {
        int low = 0;
        int high = heights.length-1;
        int lowMax = 0;
        int maxArea = 0;
        while(low < high) {
            int area = (high - low) * Math.min(heights[low], heights[high]);
            if(heights[low] <= heights[high]) {
                low++;
            } else {
                high--;
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }


    
    public int maxArea1(int[] heights) {
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
