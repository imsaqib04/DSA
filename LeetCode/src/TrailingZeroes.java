public class TrailingZeroes {
        public int trailingZeroes(int n) {
            int count = 0;

            // Keep dividing n by powers of 5
            while (n > 0) {
                n /= 5;
                count += n;
            }

            return count;
        }
    }


