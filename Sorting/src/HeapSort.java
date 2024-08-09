public class HeapSort {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public int sorting(int[] arr, int i) {
        int n = arr.length;

        for (i = n / 2 - 1; i > 0; i--) {
            heapify ( arr, n, i );
        }

        for (i = n - 1; i > 0; i--) {

            swap ( arr, 0, i );

            heapify ( arr, i, 0 );
        }
        return i;
    }


    void heapify(int[] arr, int n, int i) {

        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap ( arr, i, largest );
        }
        heapify ( arr, n, largest );

    }


    static void printArray(int arr[]) {
        int N = arr.length;

        for (int i = 0; i < N; ++i)
            System.out.print ( arr[i] + " " );
        System.out.println ();
    }
}
