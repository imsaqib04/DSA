import java.util.*;

public class MultiSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            TreeMap<Long, Integer> multiset = new TreeMap<>();
            int towers = 0;

            for (int i = 0; i < n; i++) {
                long x = sc.nextLong();

                Long key = multiset.higherKey(x);
                if (key == null) {
                    // new tower
                    multiset.put(x, multiset.getOrDefault(x, 0) + 1);
                    towers++;
                } else {
                    // place on existing tower
                    int cnt = multiset.get(key);
                    if (cnt == 1) multiset.remove(key);
                    else multiset.put(key, cnt - 1);

                    multiset.put(x, multiset.getOrDefault(x, 0) + 1);
                }
            }

            System.out.println(towers);
        }

        sc.close();
    }
}
