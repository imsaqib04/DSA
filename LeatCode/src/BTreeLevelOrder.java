import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BTreeLevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<> (); //store the final result
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> q = new ArrayDeque<> ();
        q.offer ( root );
        while (!q.isEmpty ()) {
            List<Integer> t = new ArrayList<> (); //store the values of nodes at the current level of the tree.
            for (int n = q.size (); n > 0; --n) {
                TreeNode node = q.poll ();
                t.add ( node.val );
                if (node.left != null) {
                    q.offer ( node.left );
                }
                if (node.right != null) {
                    q.offer ( node.right );
                }
            }
            ans.add ( t );
        }
        return ans;
    }
}
