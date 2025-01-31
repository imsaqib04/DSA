public class JumpGame2 {
    public int jump(int[] nums) {
        int totalJumps = 0;
        int destination = nums.length - 1;

        int coverage = 0;
        int lastIndex = 0;

// base case
        if (nums.length == 1) {
            return 0;
        }

// gready strategy:
        for (int i = 0; i < nums.length; i++) {
            coverage = Math.max ( coverage, i + nums[i] );

            if (i == lastIndex) {
                lastIndex = coverage;
                totalJumps++;

// check if we reached already ? in destination
                if (coverage >= destination) {
                    return totalJumps;
                }
            }
        }
        return totalJumps;
    }
}