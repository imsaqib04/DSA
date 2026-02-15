class longestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;

        // Instead of saving the string, just remember where it starts and how long it is!
        int start = 0;
        int maxLen = 1;

        for (int i = 0; i < s.length(); i++) {

            // Odd length
            int left = i;
            int right = i;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                // Check if the current length is bigger than our recorded max
                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1; // Update max length
                    start = left;              // Update starting position
                }
                left--;
                right++;
            }

            // Even length
            left = i;
            right = i + 1;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                // Check if the current length is bigger than our recorded max
                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1; // Update max length
                    start = left;              // Update starting position
                }
                left--;
                right++;
            }
        }

        // Only do the expensive substring operation ONCE at the very end
        return s.substring(start, start + maxLen);
    }
}