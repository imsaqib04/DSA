import java.util.Arrays;

class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;

        // Step 1: Initialize arrays with default values (1 candy per child)
        int[] l2r = new int[n];
        int[] r2l = new int[n];
        Arrays.fill ( l2r, 1 );
        Arrays.fill ( r2l, 1 );

        // Step 2: Left to Right pass (ensure higher-rated child gets more candy than left neighbor)
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                l2r[i] = l2r[i - 1] + 1;
            }
        }

        // Step 3: Right to Left pass (ensure higher-rated child gets more candy than right neighbor)
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                r2l[i] = r2l[i + 1] + 1;
            }
        }

        // Step 4: Get the maximum candies needed per child
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.max ( l2r[i], r2l[i] );
        }

        return result;
    }
}
