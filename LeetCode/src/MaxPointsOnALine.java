
// TC:O(n^3)
//public class MaxPointsOnALine {
//        public int maxPoints(int[][] points) {
//
//            int n = points.length;
//            int max = 0;
//            if (n <= 2) {
//                return n;
//            }
//
//            for (int i = 0; i < n; i++) {
//                for (int j = i + 1; j < n; j++) {
//                    int count = 2;
//
//                    for (int k = j + 1; k < n; k++) {
//                        if (isCollinear(points[i], points[j], points[k])) {
//                            count++;
//                        }
//                    }
//                    max = Math.max(max, count);
//                }
//            }
//            return max;
//        }
//
//        boolean isCollinear(int[] p1, int[] p2, int[] p3) {
//            return ((p2[1] - p1[1]) * (p3[0] - p1[0])) == ((p3[1] - p1[1]) * (p2[0] - p1[0]));
//        }
//    }


// optimized O(n^2)
import java.util.*;
class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;

        int result = 0;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int samePoints = 0;
            int localMax = 0;

            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                // Duplicate points
                if (dx == 0 && dy == 0) {
                    samePoints++;
                    continue;
                }

                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;

                // Normalize sign
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                }

                // Handle vertical lines
                if (dx == 0) {
                    dy = 1;
                }

                // Handle horizontal lines
                if (dy == 0) {
                    dx = 1;
                }

                String slope = dx + "," + dy;
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                localMax = Math.max(localMax, map.get(slope));
            }

            result = Math.max(result, localMax + samePoints + 1);
        }

        return result;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
