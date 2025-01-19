class ProductOfArray {

    public int[] productExceptSelf(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}
  /*  public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int answer[] = new int[n];
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (j != i)
                    product = product * nums[j];
            }
            answer[i] = product;
        }
        return answer;
    }
}*/


//class Solution {
//    public int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[] answer = new int[n];
//
//        // Step 1: Compute prefix product
//        answer[0] = 1; // No elements to the left of index 0
//        for (int i = 1; i < n; i++) {
//            answer[i] = answer[i - 1] * nums[i - 1];
//        }
//
//        // Step 2: Compute suffix product and update answer array
//        int suffixProduct = 1; // No elements to the right of the last index
//        for (int i = n - 1; i >= 0; i--) {
//            answer[i] *= suffixProduct;
//            suffixProduct *= nums[i];
//        }
//
//        return answer;
//    }
//}
