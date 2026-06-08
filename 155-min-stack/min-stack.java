class MinStack {
    Stack<Integer>one ;
    Stack<Integer>two;
    public MinStack() {
        one = new Stack<>();
        two = new Stack<>();
    }
    
    public void push(int value) {
        if(one.isEmpty()){
            one.push(value);
            two.push(value);
            return;
        }
        one.push(value);
        two.push(Math.min(two.peek(),value));
    }
    
    public void pop() {
        if(one.isEmpty()){
            return;
        }
        one.pop();
        two.pop();
    }
    
    public int top() {
       return one.peek();
    }
    
    public int getMin() {
        return two.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */