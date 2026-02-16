import java.util.Scanner;
public class NumberOfWaysToReachB {
        static final long MOD = 1000000007L;
        static final int MAX = 200000;

        static long[] fact = new long[MAX + 1];
        static long[] invFact = new long[MAX + 1];

        // Fast power: base^expo % MOD
        static long power(long base, long expo) {
            long res = 1;
            base %= MOD;

            while (expo > 0) {
                if ((expo & 1) == 1) {
                    res = (res * base) % MOD;
                }
                base = (base * base) % MOD;
                expo >>= 1;
            }
            return res;
        }

        // Modular inverse using Fermat's theorem
        static long inverse(long a) {
            return power(a, MOD - 2);
        }

        // Precompute factorials and inverse factorials
        static void preCompute() {
            fact[0] = 1;
            for (int i = 1; i <= MAX; i++) {
                fact[i] = (fact[i - 1] * i) % MOD;
            }

            invFact[MAX] = inverse(fact[MAX]);
            for (int i = MAX; i > 0; i--) {
                invFact[i - 1] = (invFact[i] * i) % MOD;
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            preCompute();

            int T = sc.nextInt();
            while (T-- > 0) {
                int N = sc.nextInt();
                int M = sc.nextInt();

                long ans = fact[N + M];
                ans = (ans * invFact[N]) % MOD;
                ans = (ans * invFact[M]) % MOD;

                System.out.println(ans);
            }
            sc.close();
        }
    }
