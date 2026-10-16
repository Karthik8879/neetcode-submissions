class Solution {

    class Custom{
        int val;
        int idx;
        Custom(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Custom> stack = new Stack<>();
        stack.push(new Custom(temperatures[0], 0));
        int[] res = new int[temperatures.length];

        for(int i = 1; i < temperatures.length; i++) {
            if(!stack.isEmpty() && temperatures[i] <= stack.peek().val) {
                stack.push(new Custom(temperatures[i], i));
            } else {
                while(!stack.isEmpty() && temperatures[i] > stack.peek().val) {
                    Custom popped = stack.pop();
                    res[popped.idx] = i - popped.idx;
                }
                stack.push(new Custom(temperatures[i], i));
            }
        }
        return res;
    }
}
