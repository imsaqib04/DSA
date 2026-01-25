import java.util.Scanner;

public class NumberOfDiagonals {

        static final long MOD = 1000000007L;
        static final long INV2 = 500000004L; // modular inverse of 2

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();

            while (T-- > 0) {
                long N = sc.nextLong();

                long ans = (N % MOD) * ((N - 3 + MOD) % MOD) % MOD;
                ans = (ans * INV2) % MOD;

                System.out.println(ans);
            }
            sc.close();
        }
    }

//
//class Main {
//    static final long MOD = 1000000007L;
//
//    static long power(long a, long b) {
//        long res = 1;
//        a %= MOD;
//        while (b > 0) {
//            if ((b & 1) == 1) res = (res * a) % MOD;
//            a = (a * a) % MOD;
//            b >>= 1;
//        }
//        return res;
//    }
//
//    static long inverse(long a) {
//        return power(a, MOD - 2);
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        long inv2 = inverse(2);   // 👈 previous code reused
//
//        int T = sc.nextInt();
//        while (T-- > 0) {
//            long N = sc.nextLong();
//
//            long ans = (N % MOD) * ((N - 3 + MOD) % MOD) % MOD;
//            ans = (ans * inv2) % MOD;
//
//            System.out.println(ans);
//        }
//        sc.close();
//    }
//}
