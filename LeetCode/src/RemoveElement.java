class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int p = 0;
        int q = nums.length - 1;

        while (p <= q) {
            if (nums[p] == val) {
                int temp = nums[p];
                nums[p] = nums[q];
                nums[q] = temp;
                q--;
            } else {
                p++;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 2, 3, 5, 4, 2};
        RemoveElement a = new RemoveElement ();
        int len = a.removeElement(nums, 2);

        System.out.println(len);

        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
