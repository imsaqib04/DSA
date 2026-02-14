import java.io.*;

public class Exponentiation {

    static final long MOD = 1000000007L;

    static long modPow(long a, long b) {
        // Special case as per problem
        if (a == 0 && b == 0) return 1;

        long result = 1;
        a %= MOD;

        while (b > 0) {
            if ((b & 1) == 1) {          // if b is odd
                result = (result * a) % MOD;
            }
            a = (a * a) % MOD;          // square base
            b >>= 1;                    // b = b / 2
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int n = fs.nextInt();
        while (n-- > 0) {
            long a = fs.nextLong();
            long b = fs.nextLong();
            out.append(modPow(a, b)).append('\n');
        }

        System.out.print(out.toString());
    }

    // Fast input (important for large n)
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            long val = 0;
            int c;
            do {
                c = read();
            } while (c <= ' ');

            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = read();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return neg ? -val : val;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}
