import java.util.Arrays;

public class H_Index {
    public int hIndex(int[] citations) {

        Arrays.sort ( citations ); // Sort the array in ascending order
        int n = citations.length;

        // Traverse from the highest citation count
        for (int i = 0; i < n; i++) {
            int h = n - i; // Number of papers with at least citations[i] citations
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0; // If no valid h-index is found
    }

}
