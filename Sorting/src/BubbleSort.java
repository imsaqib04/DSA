public class BubbleSort {

    public static void BS(int[] arr, int n) {

        boolean swapped;
        int i, j, temp;

        for (i = 0; i < n - 1; i++) {
            swapped = false;

            for (j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
    }

    public void printArray(int[] A, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print ( A[i] + " ");
        }
    }
}