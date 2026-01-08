class RearrangeElementsArrayBySign {
    public int[] rearrangeArray(int[] nums) {
        // Create result array with same length as input
        int[] result = new int[nums.length];

        // Initialize pointers for positive and negative number positions
        // positiveIndex starts at 0 (even indices: 0, 2, 4, ...)
        // negativeIndex starts at 1 (odd indices: 1, 3, 5, ...)
        int positiveIndex = 0;
        int negativeIndex = 1;

        // Iterate through each number in the input array
        for (int number : nums) {
            if (number > 0) {
                // Place positive number at even index
                result[positiveIndex] = number;
                // Move to next even position
                positiveIndex += 2;
            } else {
                // Place negative number at odd index
                result[negativeIndex] = number;
                // Move to next odd position
                negativeIndex += 2;
            }
        }

        return result;
    }
}