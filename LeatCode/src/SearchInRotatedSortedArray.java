public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check if left half is sorted
            if (nums[mid] >= nums[left]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Search in left half
                } else {
                    left = mid + 1; // Search in right half
                }
            }
            // Otherwise, right half must be sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Search in right half
                } else {
                    right = mid - 1; // Search in left half
                }
            }
        }
        return -1; // Target not found
    }
}
