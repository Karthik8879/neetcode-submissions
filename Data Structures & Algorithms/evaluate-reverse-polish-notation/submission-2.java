class Solution {

    public int evalRPN(String[] tokens) {
        HashSet<String> hs = new HashSet<>();
        hs.add("-");
        hs.add("+");
        hs.add("*");
        hs.add("/");
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            if(!hs.contains(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                int ans = helper(token, a, b);
                stack.push(ans);
            }
        }
        return stack.pop();
    }

    private int helper(String token, int a, int b) {
        if(token.equals("-")) return a - b;
        else if(token.equals("+")) return a + b;
        else if(token.equals("/")) return a / b;
        else if(token.equals("*")) return a * b;
        return -1;
    }

    // public int evalRPN1(String[] tokens) {
    //     Stack<Integer> stack = new Stack<>();
    //     for(String token : tokens) {
    //         if(!isOperator(token)) {
    //             stack.push(Integer.parseInt(token));
    //         } else {
    //             int b = stack.pop();
    //             int a = stack.pop();
    //             int res = helper(token, a, b);
    //             stack.push(res);
    //         }
    //         System.out.println(stack.peek());
    //     }
    //     return stack.pop();
    // }

    // private boolean isOperator1(String token) {
    //     return (token.equals("-")) || (token.equals("/")) || (token.equals("+")) || (token.equals("*"));
    // }

    // private int helper1(String token, int a, int b) {
    //     if(token.equals("-")) return a - b;
    //     else if(token.equals("+")) return a + b;
    //     else if(token.equals("/")) return a / b;
    //     else if(token.equals("*")) return a * b;
    //     return -1;
    // }
}
