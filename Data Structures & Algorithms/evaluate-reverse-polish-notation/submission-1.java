class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            if(!isOperator(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                int res = helper(token, a, b);
                stack.push(res);
            }
            System.out.println(stack.peek());
        }
        return stack.pop();
    }

    private boolean isOperator(String token) {
        return (token.equals("-")) || (token.equals("/")) || (token.equals("+")) || (token.equals("*"));
    }

    private int helper(String token, int a, int b) {
        if(token.equals("-")) return a - b;
        else if(token.equals("+")) return a + b;
        else if(token.equals("/")) return a / b;
        else if(token.equals("*")) return a * b;
        return -1;
    }
}
