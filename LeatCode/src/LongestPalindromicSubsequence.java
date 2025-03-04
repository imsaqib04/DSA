public class LongestPalindromicSubsequence {
    public static int longestPalindromeSubseq(String s) {
        String revS = new StringBuilder(s).reverse().toString();
        return longestCommonSubsequence(s, revS);
    }

    private static int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println("Longest Palindromic Subsequence Length: " + longestPalindromeSubseq(s));
    }
}
//
//class Solution {
//    public int longestPalindromeSubseq(String s) {
//        int n = s.length();
//        int[][] dp = new int[n][n];
//
//        // Base case: single characters are palindromes of length 1
//        for (int i = 0; i < n; i++) {
//            dp[i][i] = 1;
//        }
//
//        // Fill the table bottom-up
//        for (int len = 2; len <= n; len++) { // length of substring
//            for (int i = 0; i <= n - len; i++) {
//                int j = i + len - 1; // endpoint of substring
//                if (s.charAt(i) == s.charAt(j)) {
//                    dp[i][j] = dp[i + 1][j - 1] + 2;
//                } else {
//                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//        return dp[0][n - 1];
//    }
//}


