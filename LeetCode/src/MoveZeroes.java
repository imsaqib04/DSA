class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int j = 0; // pointer for next non-zero position

        // Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        // Fill remaining positions with zeros
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }
}
