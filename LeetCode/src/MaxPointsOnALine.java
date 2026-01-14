public class MaxPointsOnALine {
        public int maxPoints(int[][] points) {

            int n = points.length;
            int max = 0;
            if (n <= 2) {
                return n;
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int count = 2;

                    for (int k = j + 1; k < n; k++) {
                        if (isCollinear(points[i], points[j], points[k])) {
                            count++;
                        }
                    }
                    max = Math.max(max, count);
                }
            }
            return max;
        }

        boolean isCollinear(int[] p1, int[] p2, int[] p3) {
            return ((p2[1] - p1[1]) * (p3[0] - p1[0])) == ((p3[1] - p1[1]) * (p2[0] - p1[0]));
        }
    }

