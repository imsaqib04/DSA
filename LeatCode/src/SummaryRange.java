import java.util.ArrayList;
import java.util.List;

public class SummaryRange {
        public List<String> summaryRanges(int[] nums) {
            List<String> result = new ArrayList<> ();
            int n = nums.length;
            if (n == 0) return result; // Handle empty array case

            for (int i = 0; i < n; i++) {
                int start = nums[i]; // Start of the current range

                // Use while loop to find the end of the range
                while (i + 1 < n && nums[i + 1] == nums[i] + 1) {
                    i++; // Move to the next consecutive number
                }

                // If start and end are the same, add single number, else add range
                if (start == nums[i]) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + nums[i]);
                }
            }

            return result;
        }

        public static void main(String[] args) {
            SummaryRange summaryRange = new SummaryRange ();
            int[] nums = {0, 1, 2, 4, 5, 7};
            System.out.println(summaryRange.summaryRanges(nums)); // Output: ["0->2", "4->5", "7"]
        }
    }