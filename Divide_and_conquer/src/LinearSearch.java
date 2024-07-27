public class LinearSearch {

    public static int searching(int arr[], int element) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element)
                return i;
        }
        return -1;
    }
}