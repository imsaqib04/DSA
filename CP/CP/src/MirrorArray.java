import java.util.*;

// Inplace method
public class MirrorArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] arr = new int[N][M];

            // Input matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // In-place reverse each row
            for (int i = 0; i < N; i++) {
                int left = 0, right = M - 1;

                while (left < right) {
                    int temp = arr[i][left];
                    arr[i][left] = arr[i][right];
                    arr[i][right] = temp;

                    left++;
                    right--;
                }
            }

            // Print the modified array
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}


//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        int T = sc.nextInt();   // number of test cases
//
//        while (T-- > 0) {
//
//            int N = sc.nextInt(); // rows
//            int M = sc.nextInt(); // columns
//
//            int[][] arr = new int[N][M];
//
//            // Input the matrix
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    arr[i][j] = sc.nextInt();
//                }
//            }
//
//            // Print mirror (reverse each row)
//            for (int i = 0; i < N; i++) {
//                for (int j = M - 1; j >= 0; j--) {
//                    System.out.print(arr[i][j] + " ");
//                }
//                System.out.println();
//            }
//        }
//
//        sc.close();
//    }
//}
