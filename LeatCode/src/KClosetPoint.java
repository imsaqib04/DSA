import java.util.Comparator;
import java.util.PriorityQueue;

class KClosetPoint {
    // Function to find the K closest points
    public int[][] kClosest(int[][] points, int K) {
        // Create a priority queue with a custom comparator to compare the distances
        PriorityQueue<int[]> minHeap = new PriorityQueue<> (new PointComparator());

        // Add all points to the priority queue
        for (int[] point : points) {
            minHeap.offer(point);
        }

        // Prepare the result array to store the K closest points
        int[][] result = new int[K][2];

        // Extract the first K points from the priority queue (which will be the closest)
        for (int i = 0; i < K; i++) {
            result[i] = minHeap.poll(); // Remove and return the closest point
        }

        return result;
    }

    // Helper method to calculate the squared distance from the origin (0,0)
    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1]; // Return x^2 + y^2
    }

    // Custom comparator class to compare the distances of points
    class PointComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return getDistance(a) - getDistance(b);
        }
    }

    // Driver code for testing
    public static void main(String[] args) {
        KClosetPoint sol = new KClosetPoint ();

        int[][] points = { {1, 3}, {-2, 2}, {5, 8}, {0, 1} };
        int K = 2;

        int[][] result = sol.kClosest(points, K);
        System.out.println("K Closest points to the origin:");
        for (int[] point : result) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }
}
