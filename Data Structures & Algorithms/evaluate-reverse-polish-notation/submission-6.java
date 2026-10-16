class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            String ch = tokens[i];
            if (!ch.equals("+") && !ch.equals("-") && !ch.equals("*") && !ch.equals("/")) {
                stack.push(Integer.parseInt(ch));
            } else {
                int pop1 = stack.pop(); // right
                int pop2 = stack.pop(); // left
                stack.push(operation(ch, pop2, pop1));
            }
        }
        return stack.pop();
    }

    private int operation(String ch, int pop2, int pop1) {
        if (ch.equals("+")) {
            return pop2 + pop1;
        } else if (ch.equals("-")) {
            return pop2 - pop1;
        } else if (ch.equals("*")) {
            return pop2 * pop1;
        } else {
            return pop2 / pop1;
        }
    }
}
