public class MinMax {
    public static class Min1Max1 {
        int min;
        int max;


    }
    public static Min1Max1 Max_Min(int[]A, int i, int j) {
        int mid = (i + j) / 2;
        Min1Max1 mm = new Min1Max1 ();

        if (i == j) {
            mm.min = A[i];
            mm.max = A[j];
            return mm;

        }
        else if (i == j - 1) {

            if (A[i] > A[j]) {

                mm.max = A[i];
                mm.min = A[j];
                return mm;

            }
            else {
                mm.max = A[j];
                mm.min = A[i];
                return mm;
            }
        }
        else {
            mid = (i + j) / 2;
            Min1Max1 left = Max_Min ( A, i, mid );
            Min1Max1 right = Max_Min ( A, mid + 1, j );
            mm.min = Math.min ( left.min, right.min );
            mm.max = Math.max ( (left.max), right.max );
            return mm;
        }
    }
}
