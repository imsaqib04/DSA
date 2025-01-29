public class MySqrt {

    public int mySqrt(int x) {

        long s = 1;
        long e = x;
        long ans = 0;
        while (s <= e) {
            long m = s + (e - s) / 2;
            if (m * m == x) {
                ans = (int) m;
                break;
            } else if (m * m < x) {
                s = m + 1;
                ans = m;
            } else {
                e = m - 1;
            }
        }
        return (int) ans;
    }
}
//    class Solution {
//        public int mySqrt(int x) {
//            if (x == 0 || x == 1) {
//                return x; // Special cases for 0 and 1
//            }
//
//            int ans = 0;
//
//            // Iterate from 1 to x to find the integer square root
//            for (int i = 1; i <= x; i++) {
//                if (i * i == x) {
//                    return i; // Perfect square root found
//                } else if (i * i > x) {
//                    return i - 1; // Stop when i*i exceeds x and return the previous value
//                }
//            }
//
//            return ans; // Should never reach here for valid inputs
//        }
//    }
