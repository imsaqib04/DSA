// you are given 4 integers A,B,C,P , p is the prime number , find the A^(B^C) %P
// note 0^0 = 1;


import java.io.*;
import java.util.*;
public class Exponentiation_AZ101 {

    // Enter your code below
    public static BufferedReader br;
    public static StringTokenizer st;

    public static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    // (a^x)%p
    static long expo(long a, long x, long p) {
        long n, ans = 1;
        // prod= (a^(2^p1))
        a %= p;
        while (x > 0) {
            if ((x & 1) == 1) {
                ans = ((ans % p) * (a % p)) % p;
            }
            a = ((a % p) * (a % p)) % p;
            x = x >> 1;
        }
        return ans;
    }

    public static void solve(PrintWriter out) throws IOException {
        // write your code here
        long n, res, ans, a, b, c, p;
        a = Long.parseLong(next());
        b = Long.parseLong(next());
        c = Long.parseLong(next());
        p = Long.parseLong(next());
        if (b == 0 && c != 0) {
            out.println(1);
        } else if (a % p == 0 || a == 0) {
            out.println(0);
        } else {
            res = expo(b, c, p - 1);
            ans = expo(a, res, p);
            out.println(ans);
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        st = null;
        int T = 1;
        String tkn = next();
        if (tkn != null) T = Integer.parseInt(tkn);
        for (int i = 0; i < T; i++) {
            solve(out);
        }
        out.flush();
        out.close();
    }
}
