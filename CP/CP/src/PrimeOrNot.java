import java.util.Scanner;
public class PrimeOrNot {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int T = sc.nextInt();
            while (T-- > 0) {

                int n = sc.nextInt();

                if (n <= 1) {
                    System.out.println("NO");
                    continue;
                }

                boolean isPrime = true;

                for (int i = 2; i * i <= n; i++) {
                    if (n % i == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }
