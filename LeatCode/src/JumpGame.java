public class JumpGame {
    public boolean canJump(int[] nums) {

        int finalPos = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {

            if (i + nums[i] >= finalPos) {
                finalPos = i;
            }
        }
        return finalPos == 0;
    }
}

// if(nums.length-1==0){
//     return true;
// }
// for(int i = 0; i<=nums.length-1;i++){
//     if(nums[nums.length-2]==0 || nums[0] == 0){
//         return false;
//     }
// }
// return true;