import java.util.HashMap;
import java.util.Map;

public class IsoMorphicString {
    public boolean isIsomorphic(String s, String t) {
        if (s.length () != t.length ()) {
            return false; // Strings must be of the same length
        }

        Map<Character, Character> map1 = new HashMap<> ();
        Map<Character, Character> map2 = new HashMap<> ();

        for (int i = 0; i < s.length (); i++) {
            char c1 = s.charAt ( i );
            char c2 = t.charAt ( i );

            if (map1.containsKey ( c1 ) && map1.get ( c1 ) != c2) {
                return false; // Inconsistent mapping
            }
            if (map2.containsKey ( c2 ) && map2.get ( c2 ) != c1) {
                return false; // Reverse mapping must also be valid
            }

            map1.put ( c1, c2 );
            map2.put ( c2, c1 );
        }

        return true;
    }
}