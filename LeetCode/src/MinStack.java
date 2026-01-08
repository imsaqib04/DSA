import java.util.Stack;

class MinStack {
    Stack<Integer> stack;     // Main stack to store all values
    Stack<Integer> minStack;  // Auxiliary stack to store minimum values

    // Constructor to initialize the stacks
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push method to add a value to the stack
    public void push(int val) {
        stack.push(val);  // Push the value to the main stack

        // If minStack is empty or val is less than or equal to the current minimum, push it to minStack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // Pop method to remove the top element from the stack
    public void pop() {
        // If the top of the main stack is the current minimum, pop from minStack as well
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    // Returns the top element of the main stack without removing it
    public int top() {
        return stack.peek();
    }

    // Returns the minimum element in the stack in constant time
    public int getMin() {
        return minStack.peek();
    }

    // Main method for testing the MinStack class
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(10);
        obj.push(5);
        obj.push(20);
        obj.push(5);

        System.out.println("Top element: " + obj.top());        // Should print the top element
        System.out.println("Minimum element: " + obj.getMin()); // Should print the minimum element

        obj.pop(); // Removes top element (which is also minimum in this case)
        System.out.println("After one pop, new minimum: " + obj.getMin()); // Should print the new minimum
    }
}
