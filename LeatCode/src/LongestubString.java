import java.util.HashMap;

class LongestSubString {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character,Integer> hm = new HashMap<> ();

        int len =0;
        int start=0;
        for(int i =0; i<s.length ();i++){

            char c = s.charAt ( i );

            if(hm.containsKey ( c )){
                start = Math.max(hm.get(c)+1,start);   // We update start to skip past the last occurrence of this character.
                                                       // start = Math.max(hm.get(c) + 1, start) ensures start never moves backward.
            }
            else{
                hm.put(c,i);

                len = Math.max(len,i-start+1);
            }
        }
        return len;
    }
}