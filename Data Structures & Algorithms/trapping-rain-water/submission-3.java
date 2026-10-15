class Solution {
    public int trap(int[] height) {
        int leftIdx = 0;
        int rightIdx = height.length-1;
        int maxLeftIdx = 0;
        int maxRightIdx = height.length-1;
        int maxLeftVal = height[0];
        int maxRightVal = height[height.length-1];
        int water = 0; // this is what we are going to return
        while(leftIdx < rightIdx) {
            int leftVal = height[leftIdx];
            int rightVal = height[rightIdx];
            if(leftVal >= maxLeftVal) {
                maxLeftVal = leftVal;
                maxLeftIdx = leftIdx;
            } else {
                if(leftIdx > maxLeftIdx) {
                    water += (maxLeftVal - leftVal);   
                }
            }
            if(rightVal >= maxRightVal) {
                maxRightVal = rightVal;
                maxRightIdx = rightIdx;
            } else {
                if(rightIdx < maxRightIdx) {
                    water += (maxRightVal - rightVal);
                }
            }
            if(leftVal <= rightVal) {
                leftIdx++;
            } else {
                rightIdx--;
            }
        }
        return water;
    }
}
