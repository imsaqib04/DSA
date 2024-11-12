import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<> ();
        Arrays.sort ( candidates );
        dfs ( 0, target, new ArrayList<> (), result, candidates );
        return result;
    }

    void dfs(int i, int target, ArrayList<Integer> t, List<List<Integer>> result, int candidates[]) {
        if (target == 0) {
            result.add ( new ArrayList<> ( t ) );
            return;
        }

        if (i >= candidates.length || target < candidates[i]) {
            return;
        }

        dfs ( i + 1, target, t, result, candidates );
        t.add ( candidates[i] );
        dfs ( i, target - candidates[i], t, result, candidates );
        t.remove ( t.size () - 1 );

    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum ();
        int nums[] = {2,3,5,6,1};
       List<List<Integer>> r =  cs.combinationSum ( nums,4 );
        System.out.println (r);
    }
}
