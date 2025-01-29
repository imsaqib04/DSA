import java.util.HashMap;
class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> map = new HashMap<> ();

        for (int i = 0; i < magazine.length (); i++) {
            char c = magazine.charAt ( i );
            if (!map.containsKey ( c )) {
                map.put ( c, 1 );
            } else {
                map.put ( c, map.get ( c ) + 1 );
            }
        }

        int count = 0;
        for (int i = 0; i < ransomNote.length (); i++) {
            char c = ransomNote.charAt ( i );
            if (map.containsKey ( c ) && map.get ( c ) > 0) {
                count++;
                map.put ( c, map.get ( c ) - 1 );
            } else {
                break;
            }
        }
        if (count == ransomNote.length ()) {

            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        RansomNote r = new RansomNote ();
        Boolean b = r.canConstruct ( "aa","ab" );
        System.out.println (b);
    }
}