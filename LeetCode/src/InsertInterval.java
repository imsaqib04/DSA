import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        for (int[] current_interval : intervals) {
            // If current interval ends before newInterval starts, add it to result.
            if (current_interval[1] < newInterval[0]) {
                result.add(current_interval);
            }
            // If newInterval ends before current interval starts, add newInterval, then update newInterval.
            else if (newInterval[1] < current_interval[0]) {
                result.add(newInterval);
                newInterval = current_interval;
            }
            // Merge overlapping intervals by updating newInterval's start and end.
            else {
                newInterval[0] = Math.min(newInterval[0], current_interval[0]);
                newInterval[1] = Math.max(newInterval[1], current_interval[1]);
            }
        }
        // Add the final newInterval.
        result.add(newInterval);

        return result.toArray(new int[result.size()][]);
    }
}
