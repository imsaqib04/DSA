import java.util.Map;
import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        // Map for Roman numeral values
        Map<Character, Integer> map = new HashMap<> ();
        map.put ( 'I', 1 );
        map.put ( 'V', 5 );
        map.put ( 'X', 10 );
        map.put ( 'L', 50 );
        map.put ( 'C', 100 );
        map.put ( 'D', 500 );
        map.put ( 'M', 1000 );

        int sum = 0;
        int prevValue = 0;

        // Indexed for loop
        for (int i = 0; i < s.length (); i++) {
            char c = s.charAt ( i );
            int value = map.get ( c );

            if (value > prevValue) {
                sum += value - 2 * prevValue;
            } else {
                sum += value;
            }

            prevValue = value;
        }

        return sum;
    }
}
