import java.util.*;

public class Max_Item {

    public static int maxItems(int[] prices, int B) {
        Arrays.sort(prices);   // cheapest first

        int count = 0;
        int sum = 0;

        for (int p : prices) {
            if (sum + p <= B) {
                sum += p;
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int B = sc.nextInt();

        int[] prices = new int[N];
        for (int i = 0; i < N; i++) {
            prices[i] = sc.nextInt();
        }

        int result = maxItems(prices, B);
        System.out.println(result);
    }
}
