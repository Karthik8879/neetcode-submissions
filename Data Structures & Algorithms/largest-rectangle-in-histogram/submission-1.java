class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] nextSmallerEle = nextSmallerEle(heights);
        int[] prevSmallerEle = prevSmallerEle(heights);
        for(int i = 0; i < heights.length; i++) {
            int width = nextSmallerEle[i] - prevSmallerEle[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private int[] nextSmallerEle(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[heights.length];
        for(int i = heights.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                res[i] = heights.length;
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }

    private int[] prevSmallerEle(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[heights.length];
        for(int i = 0; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }
}
