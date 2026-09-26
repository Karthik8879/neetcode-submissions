class Solution {

    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int lMax = 0, rMax = 0;
        int lMaxIdx = 0, rMaxIdx = height.length-1;
        int ans = 0;
        while(left < right) {
            if(height[left] <= height[right]) {
                lMax = Math.max(lMax, height[left]);
                if(height[left] < lMax) {
                    ans += lMax - height[left];
                }
                left++;
            } else {
                rMax = Math.max(rMax, height[right]);
                if(height[right] < rMax) {
                    ans += rMax - height[right];
                }
                right--;
            }
        }
        return ans;
    }

    public int trap2(int[] height) {
        int low = 0;
        int high = height.length-1;
        int lMax = 0;
        int hMax = 0;
        int ans = 0;
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

    public int trap1(int[] height) {
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
