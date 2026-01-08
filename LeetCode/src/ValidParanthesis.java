import java.util.Stack;

public class ValidParanthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<> ();

        for (int i = 0; i < s.length (); i++) {
            char c = s.charAt ( i );

            // Push opening brackets onto the stack
            if (c == '{' || c == '(' || c == '[') {
                stack.push ( c );
            }
            // Handle closing brackets
            else if (c == '}' || c == ')' || c == ']') {
                // If stack is empty or top doesn't match, return false
                if (stack.isEmpty () || !isMatchingPair ( stack.pop (), c )) {
                    return false;
                }
            }
        }

        // If the stack is empty, all brackets are matched
        return stack.isEmpty ();
    }

    // Helper method to check if a pair of brackets matches
    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}