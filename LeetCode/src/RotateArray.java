// Brute force approach;

public class RotateArray {
    public void rotate(int[] nums, int k) {

        int temp;
        int prv;
        int n = nums.length;
        k = k % n;

        for (int i = 0; i < k; i++) {
            prv = nums[nums.length - 1];

            for (int j = 0; j < n; j++) {
                temp = nums[j];
                nums[j] = prv;
                prv = temp;
            }
        }
    }
}


// using extra space;

//class Solution {
//    public void rotate(int[] nums, int k) {
//        int n = nums.length;
//        k = k % n; // handle if k > n
//
//        int[] arr = new int[n];
//
//        // move last k elements to the beginning
//        for (int i = 0; i < k; i++) {
//            arr[i] = nums[n - k + i];
//        }
//
//        // move first n-k elements after them
//        for (int i = k; i < n; i++) {
//            arr[i] = nums[i - k];
//        }
//
//        // copy back to original array
//        for (int i = 0; i < n; i++) {
//            nums[i] = arr[i];
//        }
//    }
//}



//class Solution {
//    public void reverse(int[] nums, int l,int h ){
//        while(l<h){
//            int temp=nums[l];
//            nums[l]=nums[h];
//            nums[h]=temp;
//            l++;
//            h--;
//        }
//
//    }
//    public void rotate(int[] nums, int k) {
//        k=k%nums.length;
//        reverse(nums,nums.length-k,nums.length-1);
//        reverse(nums,0,nums.length-k-1);
//        reverse(nums,0,nums.length-1);
//    }
//}