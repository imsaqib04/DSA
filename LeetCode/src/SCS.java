public class SCS {

    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length ();
        int n = str2.length ();
        int dp[][] = new int[m + 1][n + 1];

        // Fill DP table for LCS length
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt ( i - 1 ) == str2.charAt ( j - 1 )) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max ( dp[i - 1][j], dp[i][j - 1] );
                }
            }
        }

        // Construct SCS using DP table
        int i = m, j = n;
        StringBuilder scs = new StringBuilder ();

        while (i > 0 && j > 0) {
            if (str1.charAt ( i - 1 ) == str2.charAt ( j - 1 )) {
                scs.append ( str1.charAt ( i - 1 ) ); // Append LCS character
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                scs.append ( str1.charAt ( i - 1 ) ); // Append from str1
                i--;
            } else {
                scs.append ( str2.charAt ( j - 1 ) ); // Append from str2
                j--;
            }
        }

        // Add remaining characters if any
        while (i > 0) {
            scs.append ( str1.charAt ( i - 1 ) );
            i--;
        }
        while (j > 0) {
            scs.append ( str2.charAt ( j - 1 ) );
            j--;
        }

        return scs.reverse ().toString ();
    }
}