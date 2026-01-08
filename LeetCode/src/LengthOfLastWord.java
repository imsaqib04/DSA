public class LengthOfLastWord {

    int lengthOfLastWord(String s) {

        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) != ' ') {
                count++;
            }
            else {
                // it's a white space instead
                // Did we already started to count a word ?
                // Yes so we found the last word
                if (count > 0)
                    return count;
            }
        }

        return count;
    }

}

//public class LengthOfLastWord {
//    public int lengthOfLastWord(String s) {
//        int i = s.length () - 1;
//        while (i >= 0 && s.charAt ( i ) == ' ') {
//            --i;
//        }
//        int j = i;
//        while (j >= 0 && s.charAt ( j ) != ' ') {
//            --j;
//        }
//        return i - j;
//    }
//}

