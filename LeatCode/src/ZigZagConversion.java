import java.util.Arrays;

public class ZigZagConversion {
    public String convert(String s, int numRows) {

        String[] ans = new String[numRows];

        Arrays.fill ( ans, "" );

        int i = 0;
        while (i < s.length ()) {
            for (int index = 0; index < numRows && i < s.length (); index++) {
                ans[index] = ans[index] + s.charAt ( i++ );
            }

            for (int index = numRows - 2; index > 0 && i < s.length (); index--) {
                ans[index] = ans[index] + s.charAt ( i++ );
            }
        }
        String res = "";
        for (String str : ans) {
            res = res + str;
        }
        return res;
    }
}