import java.util.Stack;

class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();

        int result = 0;
        int sign = 1;
        int number = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            switch (ch) {
                case ' ':
                    break;

                case '+':
                    result += sign * number;
                    sign = 1;
                    number = 0;
                    break;

                case '-':
                    result += sign * number;
                    sign = -1;
                    number = 0;
                    break;

                case '(':
                    stk.push(result);
                    stk.push(sign);
                    result = 0;
                    sign = 1;
                    break;

                case ')':
                    result += sign * number;
                    number = 0;
                    result *= stk.pop(); // sign
                    result += stk.pop(); // previous result
                    break;

                default:
                    if (Character.isDigit(ch)) {
                        number = number * 10 + (ch - '0');
                    }
                    break;
            }
        }

        result += sign * number;
        return result;
    }
}
