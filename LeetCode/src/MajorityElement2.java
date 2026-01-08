import java.util.*;

class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {

        int n = nums.length;

        // Step 1: Find two potential candidates
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify the candidates
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        // Step 3: Prepare the answer
        List<Integer> result = new ArrayList<>();

        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        return result;
    }
}

// using own solution!
// int n = nums.length;
// List<Integer> list = new ArrayList<>();
// Set<Integer> set = new HashSet<>();
// Map<Integer,Integer> map = new HashMap<>();
// int count = 0;

// for(int i =0;i<n;i++){
//     map.put(nums[i],map.getOrDefault(nums[i],0)+1);
// }

// for(int i = 0; i<n;i++){

//     if(map.get(nums[i]) > n/3){
//         set.add(nums[i]);
//     }
// }

// for(int num : set){
//     list.add(num);
// }

// return list;
