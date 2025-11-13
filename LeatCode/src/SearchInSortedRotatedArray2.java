class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {


        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = left+(right-left)/2;

            if(nums[mid]==target){
                return true;
            }

            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
                continue;
            }

            // left sorted array checking
            if(nums[mid]>=nums[left]){
                if(nums[left]<=target && nums[mid]>target){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            // right sorted array checking
            else{
                if(nums[right]>=target && nums[mid]<target){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }

        }
        return false;
    }
}