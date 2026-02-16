import java.io.*;
import java.util.*;

public class Solve_The_Equation {
    static long mod = 1000000007L;

    static long add(long a, long b) {
        return ((a % mod) + (b % mod)) % mod;
    }

    static long sub(long a, long b) {
        long ans = ((a % mod) - (b % mod)) % mod;
        ans %= mod;
        ans = (ans + mod) % mod;
        return ans;
    }

    static long mul(long a, long b) {
        return ((a % mod) * (b % mod)) % mod;
    }

    static long power(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ((ans % mod) * (a % mod)) % mod;
            }
            a = ((a % mod) * (a % mod)) % mod;
            b >>= 1;
        }
        return ans;
    }

    static long res(char op, long a, long b) {
        if (op == '+')
            return add(a, b);
        else if (op == '-')
            return sub(a, b);
        else if (op == '*')
            return mul(a, b);
        else
            return mul(a, power(b, mod - 2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) line = br.readLine();
        int t = Integer.parseInt(line.trim());
        for (int tc = 0; tc < t; tc++) {
            String s = br.readLine();
            while (s != null && s.trim().isEmpty()) s = br.readLine();
            if (s == null) break;
            String[] tokens = s.trim().split("\\s+");
            String s1 = tokens[0];
            char op1 = tokens[1].charAt(0);
            long b = Long.parseLong(tokens[2]);
            char op2 = tokens[3].charAt(0);
            String s2 = tokens[4];
            // tokens[5] should be "mod"
            mod = Long.parseLong(tokens[6]);
            long a = Long.parseLong(s1.substring(1));
            s2 = s2.substring(0, s2.length() - 1);
            long c = Long.parseLong(s2);

            long ans = 0;
            if (op1 == '+' || op1 == '-') {
                if (op2 == '+' || op2 == '-') {
                    ans = res(op1, a, b);
                    ans = res(op2, ans, c);
                } else {
                    ans = res(op2, b, c);
                    ans = res(op1, a, ans);
                }
            } else {
                ans = res(op1, a, b);
                ans = res(op2, ans, c);
            }

            out.println(ans);
        }

        out.flush();
        out.close();
    }
}
