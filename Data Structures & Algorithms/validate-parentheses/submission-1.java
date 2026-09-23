class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> hm = new HashMap<>();
        hm.put('}', '{');
        hm.put(']', '[');
        hm.put(')', '(');
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!hm.containsKey(ch)) { // open bracket
                stack.add(ch);
            } else { // closing bracket
                if(stack.isEmpty() || stack.pop() != hm.get(ch)) return false;
            }
        }
        return stack.isEmpty();
    }
}
