import java.util.Stack;

public class SimpliyfyPath {
    public String simplifyPath(String path) {
        String parts[] = path.split ( "/" );

        Stack<String> stk = new Stack<> ();

        for (String part : parts) {
            if (part.equals ( "" ) || part.equals ( "." )) {
                continue;
            } else if (part.equals ( ".." )) {
                if (!stk.isEmpty ()) { // if we can not add this we see a error
                    stk.pop ();
                }
            } else {
                stk.push ( part );
            }
        }

        StringBuilder result = new StringBuilder ();
        for (String dir : stk) {
            result.append ( "/" ).append ( dir );
        }

        return result.length () == 0 ? "/" : result.toString ();
    }
}
