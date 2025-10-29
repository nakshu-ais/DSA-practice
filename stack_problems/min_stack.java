import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        // push to minStack either the new val if it's smaller, or repeat the current min
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        } 
        // Note: using <= ensures duplicates of minimum are tracked correctly
    }
    
    public void pop() {
        if (stack.isEmpty()) return; // or throw exception based on expected behavior
        int popped = stack.pop();
        if (!minStack.isEmpty() && popped == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        if (stack.isEmpty()) throw new RuntimeException("Stack is empty");
        return stack.peek();
    }
    
    public int getMin() {
        if (minStack.isEmpty()) throw new RuntimeException("Stack is empty");
        return minStack.peek();
    }
}
