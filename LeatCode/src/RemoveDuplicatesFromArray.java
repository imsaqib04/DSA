public class RemoveDuplicatesFromArray {

    static int removeDuplicates(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int uniqueIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[uniqueIndex]) {

                uniqueIndex++;
                arr[uniqueIndex] = arr[i];
            }
        }

        return uniqueIndex + 1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 3, 3, 4, 4, 4, 5};

        // Remove duplicates and get the number of unique elements
        int n = removeDuplicates(arr);

        // Print the modified array containing unique elements
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}



//class Solution {
//    public int removeDuplicates(int[] nums) {
//
//        int [] temp = new int[nums.length];
//        int j=0;
//        for (int i = 0; i<nums.length - 1; i++){
//            if(nums[i] != nums[i+1]){
//
//                temp[j] = nums[i];
//                j++;
//
//            }
//        }
//
//        temp[j] = nums[nums.length - 1];
//        j++;
//
//        for(int i = 0;i<j;i++){
//            nums[i] = temp[i];
//        }
//
//        return j;
//
//    }
//}
