import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NumberOfPartsInConvexPolygon {

        static final long MOD = 1000000007L;

        public static void main(String[] args) throws IOException {
            // Fast I/O
            BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
            PrintWriter out = new PrintWriter (System.out);

            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());

            // Precompute modular inverses for 24 and 2
            long inv24 = modInverse(24);
            long inv2 = modInverse(2);

            while (T-- > 0) {
                st = new StringTokenizer(br.readLine());
                long N = Long.parseLong(st.nextToken());

                // We use the formula: (N choose 4) + (N-1 choose 2)
                // Term 1: (N * (N-1) * (N-2) * (N-3)) / 24
                // Term 2: ((N-1) * (N-2)) / 2

                // Calculate Term 1 with modulo at every step
                long term1 = N % MOD;
                term1 = (term1 * ((N - 1) % MOD)) % MOD;
                term1 = (term1 * ((N - 2) % MOD)) % MOD;
                term1 = (term1 * ((N - 3) % MOD)) % MOD;
                term1 = (term1 * inv24) % MOD;

                // Calculate Term 2
                long term2 = (N - 1) % MOD;
                term2 = (term2 * ((N - 2) % MOD)) % MOD;
                term2 = (term2 * inv2) % MOD;

                // Total result
                long ans = (term1 + term2) % MOD;
                out.println(ans);
            }

            out.flush();
        }

        // Function to calculate (base^exp) % MOD
        static long power(long base, long exp) {
            long res = 1;
            base = base % MOD;
            while (exp > 0) {
                if ((exp & 1) == 1)
                    res = (res * base) % MOD;
                base = (base * base) % MOD;
                exp >>= 1;
            }
            return res;
        }

        // Function to calculate modular inverse using Fermat's Little Theorem
        static long modInverse(long n) {
            return power(n, MOD - 2);
        }
    }
