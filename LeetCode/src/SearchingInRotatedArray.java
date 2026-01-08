public class SearchingInRotatedArray {
    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid =  l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[l] <= nums[mid]) {        // for left sorted array!

                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {

                if (nums[r] < target && target <= nums[mid]) {    // for right sorted array
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

        }
        return -1;
    }
}


// basically in this question we divide one array into two subArray and whether check left subArray is sorted or right subArray is sorted
// if left subArray is sorted , we check in this subArray to element is present in this array or not
// similarly check to right subArray
//This process continues until we find the element or confirm that it’s not in the array.

// Time complexity of this code is O(log n);    (avg and worst case both)









