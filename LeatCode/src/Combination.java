import java.util.ArrayList;
import java.util.List;

public class Combination {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<> ();

        dfs ( 1, n, k, new ArrayList<> (), res );
        return res;
    }

    void dfs(int j, int n, int k, ArrayList<Integer> t, List<List<Integer>> res) {

        if (t.size () == k) {
            res.add ( new ArrayList<> ( t ) );
            return;
        }

        for (int i = j; i <= n; i++) {
            t.add ( i );
            dfs ( i + 1, n, k, t, res );
            t.remove ( t.size () - 1 );
        }

    }
}