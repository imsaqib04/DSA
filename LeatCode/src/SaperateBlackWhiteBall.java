public class SaperateBlackWhiteBall {
    public long minimumSteps(String s) {
        long ans = 0;
        int cnt = 0;
        int n = s.length ();
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt ( i ) == '1') {
                ++cnt;
                ans += n - i - cnt;
            }
        }
        return ans;
    }
}

//class Solution {
//
//    public long minimumSteps(String s) {
//        long totalSwaps = 0;
//        int blackBallCount = 0;
//
//        // Iterate through each ball (character) in the string
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '0') {
//                // Swap with all black balls to its left
//                totalSwaps += blackBallCount;
//            } else {
//                // Increment the count
//                blackBallCount++;
//            }
//        }
//
//        return totalSwaps;
//    }
//}
