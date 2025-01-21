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

//Second Approach
/*
class Solution {
    public int romanToInt(String s) {
        // Map for Roman numeral values
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // Start with the value of the last Roman numeral
        int result = map.get(s.charAt(s.length() - 1));

        // Traverse the string from the second last character to the first
        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                result -= map.get(s.charAt(i)); // Subtract if smaller value precedes a larger value
            } else {
                result += map.get(s.charAt(i)); // Add otherwise
            }
        }

        return result;
    }
}
*/
