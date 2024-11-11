import java.util.List;
import java.util.ArrayList;

class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        // Initialize result list as a list of lists
        List<List<Integer>> resultList = new ArrayList<> ();

        // Call backtracking helper method with an empty temp list
        backtracking ( resultList, new ArrayList<> (), nums );
        return resultList;
    }

    void backtracking(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] nums) {
        // Base case: if tempList has reached the size of nums array, add a copy to resultList
        if (tempList.size () == nums.length) {
            resultList.add ( new ArrayList<> ( tempList ) );
            return;
        }

        for (int number : nums) {
            // Skip the number if it's already in tempList
            if (tempList.contains ( number )) {
                continue;
            }
            // Add number to tempList and call backtracking recursively
            tempList.add ( number );
            backtracking ( resultList, tempList, nums );
            // Backtrack by removing the last element added
            tempList.remove ( tempList.size () - 1 );
        }
    }

    public static void main(String[] args) {
        Permutation solution = new Permutation ();

        // Test case 1: Empty array
        int[] nums1 = {};
        List<List<Integer>> result1 = solution.permute ( nums1 );
        System.out.println ( "Test Case 1: " + result1 );
        // Expected: [[]] or empty list of lists, as no elements to permute

        // Test case 2: Array with one element
        int[] nums2 = {1};
        List<List<Integer>> result2 = solution.permute ( nums2 );
        System.out.println ( "Test Case 2: " + result2 );
        // Expected: [[1]]

        // Test case 3: Array with two elements
        int[] nums3 = {1, 2};
        List<List<Integer>> result3 = solution.permute ( nums3 );
        System.out.println ( "Test Case 3: " + result3 );
        // Expected: [[1, 2], [2, 1]]

        // Test case 4: Array with three elements
        int[] nums4 = {1, 2, 3};
        List<List<Integer>> result4 = solution.permute ( nums4 );
        System.out.println ( "Test Case 4: " + result4 );
        // Expected: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]

        // Test case 5: Array with duplicate elements (handled by code design)
        int[] nums5 = {1, 1, 2};
        List<List<Integer>> result5 = solution.permute ( nums5 );
        System.out.println ( "Test Case 5: " + result5 );
        // Expected: Due to duplicate '1's, expect unique permutations like [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
        // Current code assumes no duplicates; use unique list checker if duplicates were allowed.
    }
}