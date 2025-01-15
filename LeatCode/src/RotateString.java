public class RotateString {
    public boolean rotateString(String s, String goal) {
        if (s.length () != goal.length ()) return false;

        for (int i = 0; i < s.length (); i++) {
            // Rotate string manually
            String rotated = s.substring ( i ) + s.substring ( 0, i );
            if (rotated.equals ( goal )) {
                return true;
            }
        }
        return false;
    }
}

//class Solution {
//    public boolean rotateString(String s, String goal) {
//        // Lengths must be equal for rotation to be possible
//        if (s.length() != goal.length()) {
//            return false;
//        }
//        // Concatenating s with itself covers all possible rotations
//        String combined = s + s;
//        return combined.contains(goal);
//    }
//}
