import java.util.*;

public class KBeautifulString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();

            // Initialize string with all 'a's
            char[] s = new char[n];
            Arrays.fill(s, 'a');

            // Iterate backwards to find the position of the first 'b'
            for (int i = n - 2; i >= 0; i--) {
                long cnt = n - i - 1; // Number of valid positions for the second 'b'

                if (k > cnt) {
                    // The k-th string is not in this group, skip these 'cnt' strings
                    k -= cnt;
                } else {
                    // Found the position for the first 'b'
                    s[i] = 'b';

                    // FIXED LINE: Place the second 'b'
                    // Smaller k means second 'b' is further to the right (larger index)
                    s[n - (int) k] = 'b';
                    break;
                }
            }

            System.out.println(new String(s));
        }
        sc.close();
    }
}
