import java.util.*;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<> ();
        for (String str : strs) {
            char[] charArray = str.toCharArray ();
            Arrays.sort ( charArray );
            String s = new String ( charArray );

            if (!map.containsKey ( s )) {          // if not present in the hash table
                map.put ( s, new ArrayList () );   // then put into hashmap with new key
            }
            map.get ( s ).add ( str );              // else put into same key with new group of value
        }
        return new ArrayList<> ( map.values () );     // return all groups of values
    }
}
