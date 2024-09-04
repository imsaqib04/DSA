import java.util.Arrays;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}


//class Test{
//    public boolean containsDuplicate(int[] nums) {
//
//        for(int i=0;i<nums.length-1;i++){
//
//            for(int j =i+1; j<nums.length;j++){
//
//                if(nums[i] == nums[j]){
//                    return true;
//                }
//            }
//        }
//        return false;
//
//
//    }
//}