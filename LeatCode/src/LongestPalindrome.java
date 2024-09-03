import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {

    public int longestPalindromeLength(String s) {
                                                                    // Set to track characters
        Set<Character> charSet = new HashSet<>();
        int length = 0;

                                                                    // Iterate through each character in the string
        for (char c : s.toCharArray()) {
                                                                    // If character is already in the set, it can form a pair
            if (charSet.contains(c)) {
                length += 2;                                       // Add 2 for the pair
                charSet.remove(c);                                 // Remove the character from the set
            }
            else {
                                                                    // Add the character to the set
                charSet.add(c);
            }
        }

                                                          // If there are any characters left, one can be the center of the palindrome
        if (charSet.isEmpty()) {
            return length;
        } else {
            return length + 1;
        }
    }
}
