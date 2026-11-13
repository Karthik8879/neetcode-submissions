class Solution {
    class Custom{
        int idx;
        int val;
        Custom(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        // monotonic stack
        Stack<Custom> stack = new Stack<>();
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > stack.peek().val) {
                // populate the res
                Custom popped = stack.pop();
                res[popped.idx] = i - popped.idx; 
            }
            stack.push(new Custom(i, temperatures[i]));
        }
        return res;
    }
}
