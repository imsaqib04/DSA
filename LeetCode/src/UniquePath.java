//  DP 2D

class UniquePath {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        // First row
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // First column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // Fill rest of grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}



// use if input large

//class UniquePath {
//
//    static long mod = 1000000007L;
//
//    public int uniquePaths(int m, int n) {
//
//        long N = m + n - 2;   // total moves
//        long R = m - 1;       // choose downs
//
//        long ans = ncr((int)N, (int)R);
//        return (int) ans;   // LeetCode expects int
//    }
//
//    // Fast Power
//    static long binpow(long a, long b) {
//
//        if (b == 0) return 1;
//
//        if (b % 2 == 1)
//            return (a * binpow(a, b - 1)) % mod;
//        else {
//            long x = binpow(a, b / 2);
//            return (x * x) % mod;
//        }
//    }
//
//    // Modular inverse
//    static long inverse(long x) {
//        return binpow(x, mod - 2);
//    }
//
//    // Factorial
//    static long fact(int x) {
//        long ans = 1;
//        for (int i = 2; i <= x; i++) {
//            ans = (ans * i) % mod;
//        }
//        return ans;
//    }
//
//    // nCr
//    static long ncr(int n, int r) {
//        if (r > n) return 0;
//
//        long num = fact(n);
//        long den = (fact(r) * fact(n - r)) % mod;
//
//        return (num * inverse(den)) % mod;
//    }
//}
//


 // NCR easy small Test cased for small inputs
// class Solution {
//     public int uniquePaths(int m, int n) {

//         long res = 1;
//         int k = Math.min(m-1, n-1);

//         for (int i = 1; i <= k; i++) {
//             res = res * (m + n - 2 - k + i) / i;
//         }

//         return (int) res;
//     }
// }

