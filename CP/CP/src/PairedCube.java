import java.io.*;
import java.util.*;

class PairedCube {

    static final int MAXA = 1000000;

    // Smallest Prime Factor
    static int[] spf = new int[MAXA + 1];

    // Build SPF using sieve
    static void buildSPF() {
        for (int i = 1; i <= MAXA; i++) spf[i] = i;
        for (int i = 2; i * i <= MAXA; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= MAXA; j += i) {
                    if (spf[j] == j) spf[j] = i;
                }
            }
        }
    }

    // Build signature: prime^exp%3
    static Map<Integer, Integer> getSignature(int x) {
        Map<Integer, Integer> sig = new HashMap<>();
        while (x > 1) {
            int p = spf[x];
            int cnt = 0;
            while (x % p == 0) {
                x /= p;
                cnt++;
            }
            cnt %= 3;
            if (cnt != 0) sig.put(p, cnt);
        }
        return sig;
    }

    // Build complement signature
    static Map<Integer, Integer> getComplement(Map<Integer, Integer> sig) {
        Map<Integer, Integer> comp = new HashMap<>();
        for (Map.Entry<Integer, Integer> e : sig.entrySet()) {
            int p = e.getKey();
            int exp = e.getValue();
            comp.put(p, (3 - exp) % 3);
        }
        return comp;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        buildSPF();

        Map<Map<Integer, Integer>, Long> freq = new HashMap<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(arr[i]);

            Map<Integer, Integer> sig = getSignature(val);
            Map<Integer, Integer> comp = getComplement(sig);

            ans += freq.getOrDefault(comp, 0L);

            freq.put(sig, freq.getOrDefault(sig, 0L) + 1);
        }

        System.out.println(ans);
    }
}
