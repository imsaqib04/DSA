import java.io.*;

public class DerangmentDP {

    static final int MOD = 1000000007;
    static long[] der = new long[1000001]; // DP array

    static void computeDerangements(int N) {
        if (N >= 1) der[1] = 0;
        if (N >= 2) der[2] = 1;

        for (int i = 3; i <= N; i++) {
            der[i] = ((i - 1) * (der[i - 1] + der[i - 2])) % MOD;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        computeDerangements(N);

        System.out.println(der[N]);
    }
}
// SP:O(n)
//TC:O(n)