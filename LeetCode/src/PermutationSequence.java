//public class PermutationSequence {
//    public String getPermutation(int n, int k) {
//
//        int[] arr = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            arr[i] = i + 1;
//        }
//
//        for (int i = 1; i < k; i++) {
//            nextPermutation ( arr );
//        }
//
//        StringBuilder sb = new StringBuilder ();
//        for (int num : arr) {
//            sb.append ( num );
//        }
//        return sb.toString ();
//
//    }
//
//    static boolean nextPermutation(int[] arr) {
//
//        int n = arr.length;
//        int i = n - 2;
//
//        while (i >= 0 && arr[i] >= arr[i + 1]) {
//            i--;
//        }
//        if (i < 0) {
//            return false;
//        }
//
//        int j = n - 1;
//        while (arr[j] <= arr[i]) {
//            j--;
//        }
//
//        swap ( arr, i, j );
//        reverse ( arr, i + 1, n - 1 );
//
//        return true;
//    }
//
//    static void swap(int arr[], int a, int b) {
//        int temp = arr[a];
//        arr[a] = arr[b];
//        arr[b] = temp;
//    }
//
//    static void reverse(int arr[], int a, int b) {
//        while (a < b) {
//            swap ( arr, a, b );
//            a++;
//            b--;
//        }
//    }
//
//}
import java.util.ArrayList;
import java.util.List;

class PermutationSequence {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();

        // Build the factorial lookup and the number list
        for (int i = 1; i < n; i++) {
            fact = fact * i; // factorial of (n-1)
            numbers.add(i);
        }
        numbers.add(n); // Add the last number

        String ans = "";
        k = k - 1; // Adjust k to 0-based index

        while (true) {
            // Pick the correct number index
            ans = ans + numbers.get(k / fact);

            // Remove picked number
            numbers.remove(k / fact);

            if (numbers.size() == 0) {
                break;
            }

            // Update k and factorial for next iteration
            k = k % fact;
            fact = fact / numbers.size();
        }

        return ans;
    }
}
