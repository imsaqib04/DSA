//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class ThreeSum {
//    public List<List<Integer>> threeSum(int[] nums) {
//
//        Arrays.sort ( nums );
//        List<List<Integer>> list = new ArrayList<> ();
//
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                for (int k = j + 1; k < n; k++) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        list.add ( Arrays.asList ( nums[i], nums[j], nums[k] ) );
//                    }
//                }
//            }
//        }
//        return list;
//    }
//}


import java.util.*;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<> ();

        if (nums == null || nums.length < 3){
            return new ArrayList<> ();
        }

        for(int i=0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length-1;

            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];

                if(sum==0){
                    set.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                }
                else if(sum<0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return new ArrayList<>(set);

    }
}