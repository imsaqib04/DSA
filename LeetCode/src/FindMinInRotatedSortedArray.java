class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        // If array is already sorted
        if (nums[left] < nums[right]) {
            return nums[left];
        }

        // Binary search
        while (left < right) {

            int mid = left + (right - left) / 2;

            // If mid element is greater than right element,
            // min is in the right part
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise min is in the left part (including mid)
                right = mid;
            }
        }

        // left == right → minimum found
        return nums[left];   // you can use also right
    }
}
