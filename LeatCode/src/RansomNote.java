import java.util.HashMap;
class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0;i<magazine.length();i++){
            char c = magazine.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,1);
            }
            else{
                map.put(c,map.get(c)+1);
            }
        }

        for(int i =0;i<ransomNote.length();i++){
            char c = ransomNote.charAt(i);
            if(!map.containsKey(c)){
                return false;
            }
            else{
                map.put(c,map.get(c)-1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote r = new RansomNote ();
        Boolean b = r.canConstruct ( "ab","aab" );
        System.out.println (b);
    }
}