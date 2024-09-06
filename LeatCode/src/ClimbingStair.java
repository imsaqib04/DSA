public class ClimbingStair {
    public int climbStairs(int n) {

        int a = 1;       // when no stair;
        int b = 1;        // when only one stair;
        int c;
        for (int i = 0; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return a;
    }
}
