public class partitionArrayAccordingToPivot {
    public int[] pivotArray(int[] nums, int pivot) {

        int[] arr = new int[nums.length];
        int[] brr = new int[nums.length];
        int[] crr = new int[nums.length];

        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pivot) {
                arr[a] = nums[i];
                a++;
            } else if (nums[i] < pivot) {
                brr[b] = nums[i];
                b++;
            } else {
                crr[c] = nums[i];
                c++;
            }
        }

        int index = 0;

        for (int i = 0; i < b; i++) {
            nums[index] = brr[i];
            index++;
        }

        for (int i = 0; i < a; i++) {
            nums[index] = arr[i];
            index++;
        }

        for (int i = 0; i < c; i++) {
            nums[index] = crr[i];
            index++;
        }

        return nums;

    }
}