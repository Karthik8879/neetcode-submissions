class Solution {
    public int trap(int[] height) {
        int low = 0, high = height.length-1;
        int lMax = 0, hMax = 0, ans = 0;

        while(low < high) {
            if(height[low] <= height[high]) {
                if(height[low] >= lMax) {
                    lMax = height[low];
                } else {
                    ans += lMax - height[low];
                }
                low++;
            } else {
                if(height[high] >= hMax) {
                    hMax = height[high];
                } else {
                    ans += hMax - height[high];
                }
                high--;
            }
        }
        return ans;
    }
}
