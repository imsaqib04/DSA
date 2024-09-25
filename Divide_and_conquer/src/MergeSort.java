public class MergeSort {

    // Function to merge two halves of the array
    public static void mergesort(int[] arr, int low, int mid, int high) {
        int i, j, k;
        // Temporary array to hold merged elements
        int[] brr = new int[arr.length];

        i = low;        // Starting index for the left subarray
        j = mid + 1;    // Starting index for the right subarray
        k = low;        // Starting index for the merged array

        // Merge the two halves into brr[]
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                brr[k] = arr[i];
                i++;
            } else {
                brr[k] = arr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of the left subarray, if any
        while (i <= mid) {
            brr[k] = arr[i];
            i++;
            k++;
        }

        // Copy remaining elements of the right subarray, if any
        while (j <= high) {
            brr[k] = arr[j];
            j++;
            k++;
        }

        // Copy the merged subarray back into the original array
        for (i = low; i <= high; i++) {
            arr[i] = brr[i];
        }
    }

    // Function to perform merge sort recursively
    public static void MS(int[] arr, int low, int high) {
        if (low < high) {
            // Find the middle point
            int mid = (low + high) / 2;

            // Recursively sort first half
            MS(arr, low, mid);

            // Recursively sort second half
            MS(arr, mid + 1, high);

            // Merge the two sorted halves
            mergesort(arr, low, mid, high);
        }
    }

    // Main function to test the merge sort algorithm
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original Array:");
        printArray(arr);

        // Apply merge sort on the array
        MS(arr, 0, arr.length - 1);

        System.out.println("Sorted Array:");
        printArray(arr);
    }

    // Helper function to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
