class Solution {

    class Custom{
        int val;
        int idx;
        Custom(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }


    public int largestRectangleArea(int[] heights) {
        int[] left = prevSmalleEle(heights);
        int[] right = nextSmallerEle(heights);
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++) {
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private int[] prevSmalleEle(int[] heights) {
        int[] left = new int[heights.length];
        Stack<Custom> stack = new Stack<>();
        for(int i =0; i < heights.length; i++) {
            left[i] = -1;
            while(!stack.isEmpty() && stack.peek().val >= heights[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                left[i] = stack.peek().idx;
            }
            stack.push(new Custom(heights[i], i));
        }
        return left;
    }

    private int[] nextSmallerEle(int[] heights) {
        int[] right = new int[heights.length];
        Stack<Custom> stack = new Stack<>();
        for(int i = heights.length-1; i >= 0; i--) {
            right[i] = heights.length;
            while(!stack.isEmpty() && stack.peek().val >= heights[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                right[i] = stack.peek().idx;
            }
            stack.push(new Custom(heights[i], i));
        }
        return right;
    }
}
