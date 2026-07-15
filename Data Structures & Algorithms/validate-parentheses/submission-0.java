class Solution {
    // "([{}])"
    //  
    public boolean isValid(String s) {
        HashMap<Character, Character> hm = new HashMap<>();
        // populate hm
        hm.put(')', '(');
        hm.put(']', '[');
        hm.put('}', '{');

        Stack<Character> stack = new Stack<>();

        // looping
        for (char ch : s.toCharArray()) {

            if (hm.containsKey(ch)) { // closing bracket

                if (stack.isEmpty() || stack.peek() != hm.get(ch)) {
                    return false;
                }

                stack.pop();
            } else { // opening bracket
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
