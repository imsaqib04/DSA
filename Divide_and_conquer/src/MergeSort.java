public class MergeSort {

    public static void mergesort(int[] arr, int low, int mid, int high) {
        int i, j, k;
        int[] brr = new int[arr.length];

        i = low;
        j = mid + 1;
        k = low;

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

        while (i <= mid) {
            brr[k] = arr[i];
            i++;
            k++;
        }

        while (j <= high) {
            brr[k] = arr[j];
            j++;
            k++;
        }

        for (i = low; i <= high; i++) {
            arr[i] = brr[i];
        }
    }

    public static void MS(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            MS(arr, low, mid);
            MS(arr, mid + 1, high);
            mergesort(arr, low, mid, high);
        }
    }
}

