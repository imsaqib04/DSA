import java.util.Arrays;

class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length-1];
        int i = 0;

        while(i<str1.length()){
            if(str1.charAt(i)==str2.charAt(i)){
                i++;
            }
            else{
                break;
            }
        }

        if(i==0){
            return "";
        }
        else{
            return str1.substring(0,i);
        }
    }
}