import java.util.*;

class LongestConsecutiveSeq {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);
        int curr = 1;
        int longest = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue; // skip duplicates
            } else if (nums[i + 1] == nums[i] + 1) {
                curr++;
            } else {
                longest = Math.max(longest, curr);
                curr = 1; // reset current streak
            }
        }

        return Math.max(longest, curr);
    }
}

/*
// Step 1: Add all numbers to a HashSet for O(1) lookups
Set<Integer> set = new HashSet<>();
        for (int num : nums) {
        set.add(num);
        }

int longest = 0; // This will store the length of the longest sequence

// Step 2: Loop through each number in the set
        for (int num : set) {
        // Check if it's the start of a sequence (no previous number exists)
        if (!set.contains(num - 1)) {
int curr = num;    // Start of a new consecutive sequence
int count = 1;     // Length of the current sequence

// Step 3: Continue to check next consecutive numbers
                while (set.contains(curr + 1)) {
curr++;       // Move to next number in the sequence
count++;      // Increase the sequence length
        }

// Step 4: Update the longest sequence found so far
longest = Math.max(longest, count);
            }
                    }

                    // Step 5: Return the length of the longest consecutive sequence
                    return longest;*/
