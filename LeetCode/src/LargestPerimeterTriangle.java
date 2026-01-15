import java.util.Arrays;

public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] nums) {

        int n = nums.length;
        Arrays.sort ( nums );

        for (int i = n - 1; i >= 2; i--) {
            int largest = nums[i];
            int middle = nums[i - 1];
            int small = nums[i - 2];

            if (largest < middle + small) {
                return largest + middle + small;
            }
        }
        return 0;
    }
}