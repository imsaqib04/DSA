import java.util.*;

class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        if(nums.length < 4 || nums == null){
            return new ArrayList<> ();
        }
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<> ();
        int n = nums.length;

        for(int i = 0;i<n-3;i++){
            if(i>0 && nums[i] == nums[i-1])
                continue;
            for(int j = i+1;j<n-2;j++){
                if(j>i+1 && nums[j] == nums[j-1])
                    continue;

                int left = j+1;
                int right = n-1;

                while(left<right){
                    long sum = (long)nums[i]+nums[j]+nums[left]+nums[right];

                    if(sum == target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                    }
                    else if(sum <target){
                        left++;
                    }
                    else{
                        right--;
                    }
                }

            }
        }
        return new ArrayList<>(result);
    }
}