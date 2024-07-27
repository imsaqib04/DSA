
public class BinarySearch {

    public static int binarySearching(int[] arr, int i, int j, int element) {

        while (i <= j) {

            int mid = (i + j) / 2;

            if (arr[mid] == element) {
                return mid;
            } else if (arr[mid] > element) {
                i = mid - 1;
            } else {
                j = mid + 1;
            }
        }
        return -1;
    }
}
