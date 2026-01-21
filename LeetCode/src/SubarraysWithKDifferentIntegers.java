import java.util.*;
public class SubarraysWithKDifferentIntegers {

        public int subarraysWithKDistinct(int[] nums, int k) {
            return atMostK(nums, k) - atMostK(nums, k - 1);
        }

        private int atMostK(int[] nums, int k) {
            if (k < 0) return 0;

            Map<Integer, Integer> freq = new HashMap<>();
            int left = 0, result = 0;

            for (int right = 0; right < nums.length; right++) {
                freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

                if (freq.get(nums[right]) == 1) {
                    k--; // new distinct number added
                }

                while (k < 0) {
                    freq.put(nums[left], freq.get(nums[left]) - 1);
                    if (freq.get(nums[left]) == 0) {
                        k++; // distinct number removed
                    }
                    left++;
                }

                result += right - left + 1;
            }
            return result;
        }
    }
