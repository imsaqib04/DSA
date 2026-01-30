import java.io.*;

public class MultipleOfThreeAndFive {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            long N = Long.parseLong(br.readLine());

            long k3 = (N - 1) / 3;
            long k5 = (N - 1) / 5;
            long k15 = (N - 1) / 15;

            long sum3 = 3 * k3 * (k3 + 1) / 2;
            long sum5 = 5 * k5 * (k5 + 1) / 2;
            long sum15 = 15 * k15 * (k15 + 1) / 2;

            long ans = sum3 + sum5 - sum15;
            sb.append(ans).append("\n");
        }

        System.out.print(sb.toString());
    }
}
