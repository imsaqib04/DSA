class MaximumSubArray{
    public int maxSubArray(int[] nums) {

        int maximum = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int n = nums.length;
        int end = 0;

        for (int i = 0; i < n; i++) {
            if (sum == 0) {
                start = i;
            }
            sum = sum + nums[i];
            if (sum > maximum) {
                maximum = sum;
                end = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println ( start );    //starting index
        System.out.println ( end );    //last index
        return maximum;
    }

    public static void main(String[] args) {
        int n [] = {2,4,5,1,-2,-3};
        MaximumSubArray msa = new MaximumSubArray ();
        System.out.println (msa.maxSubArray ( n ));
    }
}