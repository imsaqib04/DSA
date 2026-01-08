import java.util.Arrays;

class MissingNumbers {
    public int missingNumber(int[] nums) {

        if(nums.length == 1 && nums[0] == 1){
            return 0;
        }
        if(nums.length == 1 && nums[0] == 0){
            return 1;
        }

        Arrays.sort(nums);

        if (nums[0] != 0) {
            return 0;
        }

        for(int i =0;i<nums.length-1;i++){
            if(nums[i]+1 == nums[i+1])
                continue;

            else{
                return nums[i]+1;
            }
        }
        return nums.length;
    }
}

//class Solution {
//    public int missingNumber(int[] nums) {
//        int n = nums.length;
//        int expectedSum = n * (n + 1) / 2;
//        int actualSum = 0;
//
//        for (int num : nums) {
//            actualSum += num;
//        }
//
//        return expectedSum - actualSum;
//    }
//}
