public class MinMax {
    public static class Min1Max1 {
        int min;
        int max;
    }

    public static Min1Max1 Min_Max(int[] arr, int i, int j) {
        int mid;
        Min1Max1 mm = new Min1Max1 ();

        if (i == j) {
            mm.min = arr[i];
            mm.max = arr[j];
            return mm;
        } else if (i == j - 1) {

            if (arr[i] > arr[j]) {

                mm.max = arr[i];
                mm.min = arr[j];
                return mm;
            } else {
                mm.max = arr[j];
                mm.min = arr[i];
                return mm;
            }
        } else {
            mid = (i + j) / 2;
            Min1Max1 left = Min_Max ( arr,mid,i );
            Min1Max1 right = Min_Max ( arr, mid + 1, j );
            mm.min = Math.min ( left.min, right.min );
            mm.max = Math.max( left.max, right.max );
            return mm;
        }
    }
}
