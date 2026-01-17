import java.util.*;

public class TopKFrequent {
        public int[] topKFrequent(int[] nums, int k) {

            // Step 1: Count frequency
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int x : nums) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }

            // Step 2: Convert map to list
            List<Map.Entry<Integer, Integer>> list =
                    new ArrayList<> (map.entrySet());

            // Step 3: Sort by frequency (descending)
            Collections.sort(list, (a, b) -> b.getValue() - a.getValue());

            // Step 4: Take first k elements
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = list.get(i).getKey();
            }

            return result;
        }
    }

