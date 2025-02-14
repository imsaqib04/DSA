import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {
    
    public int[] twoSum(int[] numbers, int target) {

        Map<Integer, Integer> m = new HashMap<> ();
        for (int i = 0; ; i++) {
            int x = numbers[i];
            int y = target - x;
            if (m.containsKey ( y )) {
                return new int[]{m.get ( y ) + 1, i + 1};
            }
            m.put ( x, i );
        }
    }
}