public class RemoveDuplicate2 {
    public int removeDuplicates(int[] nums) {

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (index < 2 || nums[i] != nums[index - 2]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
