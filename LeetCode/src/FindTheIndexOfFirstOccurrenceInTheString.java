public class FindTheIndexOfFirstOccurrenceInTheString {
    public int strStr(String haystack, String needle) {
        int m = haystack.length ();
        int n = needle.length ();

        for (int i = 0; i <= m - n; i++) {
            if (haystack.charAt ( i ) == needle.charAt ( 0 )) {
                String subStr = haystack.substring ( i, i + n );
                if (subStr.equals ( needle )) {
                    return i;
                }
            }
        }
        return -1;
    }
}