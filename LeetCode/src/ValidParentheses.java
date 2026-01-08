import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class ValidParentheses {
    public boolean isValid(String s) {

        Stack<Character> Stack = new Stack<>();
        Map<Character,Character> m = new HashMap<> ();
        m.put (')','(');
        m.put ('}','{');
        m.put (']','[');

        int n = s.length();

        for (int i=0;  i<n; i++){
            char c = s.charAt(i);

            if (m.values().contains(c)){
                Stack.push(c);
            }
            else if (!m.keySet().contains(c)){
                return false;
            }

            else if(Stack.size()!=0){
                Character temp = Stack.pop();

                if (temp == null || temp != m.get(c)){
                    return false;
                }
            }
        }
        if(Stack.size()!=0){
            return false;
        }
        return true;
    }
}