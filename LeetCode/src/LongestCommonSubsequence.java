public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length ();
        int n = text2.length ();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;  // Explicit base case initialization
                } else if (text1.charAt ( i - 1 ) == text2.charAt ( j - 1 )) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max ( dp[i - 1][j], dp[i][j - 1] );
                }
            }
        }

        return dp[m][n];
    }
}


//to much time
/*class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return LCS(text1, text2, text1.length(), text2.length());
    }

    private int LCS(String text1, String text2, int i, int j) {
        if (i == 0 || j == 0) return 0; // Base case

        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
            return 1 + LCS(text1, text2, i - 1, j - 1);
        } else {
            return Math.max(LCS(text1, text2, i - 1, j), LCS(text1, text2, i, j - 1));
        }
    }
}*/
