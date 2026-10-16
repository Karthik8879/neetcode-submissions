class MinStack {

    class Custom{
        int value;
        int minSoFar;
        Custom(int value, int minSoFar) {
            this.value = value;
            this.minSoFar = minSoFar;
        }
    }

    Stack<Custom> stack = new Stack<>();
    public MinStack() {
    }
    
    public void push(int val) {
        int min = val;
        if(!stack.isEmpty()) {
            min = Math.min(min, stack.peek().minSoFar);
        }
        stack.push(new Custom(val, min));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().value;
    }
    
    public int getMin() {
        return stack.peek().minSoFar;
    }
}
