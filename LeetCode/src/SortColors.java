class SortColors {
    public void sortColors(int[] nums) {

        int low =0;
        int mid = 0;
        int high = nums.length-1;

        while(mid<=high){
            if(nums[mid]==0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }

    }
}

// // Arrays.sort(nums);

// int temp;
// for(int i=0;i<nums.length;i++){
//     for(int j = i+1;j<nums.length;j++){
//         if(nums[i]>nums[j]){
//             temp = nums[i];
//             nums[i]=nums[j];
//             nums[j]=temp;
//         }
//     }
// }