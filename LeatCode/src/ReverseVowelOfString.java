public class ReverseVowelOfString {
    public String reverseVowels(String s) {

        char[] arr = s.toCharArray ();
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            if (isVowel ( arr[l] ) && isVowel ( arr[r] )) {
                swap ( arr, l, r );
                l++;
                r--;
            } else if (isVowel ( arr[l] )) {
                r--;
            } else {
                l++;
            }
        }
        return new String ( arr );
    }

    Boolean isVowel(char c) {
        return (c == 'a' || c == 'A' || c == 'e'
                || c == 'E' || c == 'i' || c == 'I'
                || c == 'o' || c == 'O' || c == 'u'
                || c == 'U');
    }

    void swap(char[] brr, int start, int end) {
        char temp = brr[start];
        brr[start] = brr[end];
        brr[end] = temp;

    }
}
