import java.util.Stack;

public class BasicCalculator2 {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<> ();
        int number = 0;
        char sign = '+'; // default sign

        for (int i = 0; i < s.length (); i++) {
            char ch = s.charAt ( i );

            if (Character.isDigit ( ch )) {
                number = number * 10 + (ch - '0');
            }

            if ((!Character.isDigit ( ch ) && ch != ' ') || i == s.length () - 1) {
                switch (sign) {
                    case '+':
                        stk.push ( number );
                        break;
                    case '-':
                        stk.push ( -number );
                        break;
                    case '*':
                        stk.push ( stk.pop () * number );
                        break;
                    case '/':
                        stk.push ( stk.pop () / number );
                        break;
                }
                sign = ch;    // update the operator for next iteration
                number = 0;   // reset the number
            }
        }

        int result = 0;
        for (int i : stk) {
            result += i;
        }
        return result;
    }
}