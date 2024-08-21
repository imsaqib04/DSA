import java.util.*;
class ValidAnagram {
    public boolean isAnagram(String s, String t) {

//        char[] sc = s.toCharArray ();
//        char[] tc = t.toCharArray ();
//        Arrays.sort ( sc );
//        Arrays.sort ( tc );
//
//        if (new String ( sc ).equals ( new String ( tc ) )) {
//            return true;
//        }
//        return false;

        if (s.length () != t.length ()) {
            return false;
        }

        int[] countChar = new int[26];
        for (int i = 0; i < s.length (); i++) {
            countChar[s.charAt ( i ) - 'a']++;
            countChar[t.charAt ( i ) - 'a']--;
        }
        for (int count : countChar) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}