import java.util.Scanner;

public class NumberOfIntersectingDiagonal {
        static final long MOD = 1000000007L;

        static long power(long a, long b) {
            long res = 1;
            a %= MOD;
            while (b > 0) {
                if ((b & 1) == 1) res = (res * a) % MOD;
                a = (a * a) % MOD;
                b >>= 1;
            }
            return res;
        }

        static long inverse(long a) {
            return power(a, MOD - 2);
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner (System.in);

            long inv24 = inverse(24);   // 👈 reuse previous logic

            int T = sc.nextInt();
            while (T-- > 0) {
                long N = sc.nextLong();

                if (N < 4) {
                    System.out.println(0);
                    continue;
                }

                long ans = N % MOD;
                ans = (ans * ((N - 1) % MOD)) % MOD;
                ans = (ans * ((N - 2) % MOD)) % MOD;
                ans = (ans * ((N - 3) % MOD)) % MOD;
                ans = (ans * inv24) % MOD;

                System.out.println(ans);
            }
            sc.close();
        }
    }

