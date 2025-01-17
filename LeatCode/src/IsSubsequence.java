public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty ()) return true;
        char[] charS = s.toCharArray ();
        char[] charT = t.toCharArray ();
        int j = 0;
        for (int i = 0; i < charT.length; i++) {
            if (charT[i] == charS[j]) {
                ++j;
            }
            if (j == charS.length) {
                return true;
            }
        }
        return false;
    }
}

/*class Solution {
    public boolean isSubsequence(String s, String t) {

        int i = 0;
        int j = 0;

        while(i<s.length()  && j<t.length()){

            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}*/

