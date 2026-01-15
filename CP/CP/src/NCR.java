import java.io.*;
// using pascal!
public class NCR {

    static final int MAXN = 1000;
    static final long MOD = 1000000000L;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // Precompute Pascal Triangle
        long[][] C = new long[MAXN + 1][MAXN + 1];

        for (int i = 0; i <= MAXN; i++) {
            C[i][0] = 1;
            C[i][i] = 1;
            for (int j = 1; j < i; j++) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            for (int r = 0; r <= n; r++) {
                sb.append(C[n][r]);
                if (r < n) sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
