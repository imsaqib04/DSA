import java.util.LinkedList;
import java.util.Queue;

public class SymmatricTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<> ();

        if (root == null) {
            return true;
        }

        queue.add ( root.left );
        queue.add ( root.right );

        while (!queue.isEmpty ()) {
            TreeNode left = queue.poll ();
            TreeNode right = queue.poll ();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null || right.val != left.val) {
                return false;
            }

            queue.add ( left.left );      // 3 left ka left
            queue.add ( right.right );    // 3 right ka right
            queue.add ( left.right );     //4 left ka right
            queue.add ( right.left );      //4 right ka left
        }
        return true;
    }
}


/*class Solution {
    public boolean isSymmetric(TreeNode root) {

        if(root==null){
            return true;
        }

        return isSame(root.left,root.right);
    }

    private boolean isSame(TreeNode l1,TreeNode r1){

        if(l1==null&&r1==null){
            return true;
        }

        if(l1==null || r1==null || l1.val!=r1.val){
            return false;
        }

        return isSame(l1.left,r1.right) && isSame(l1.right,r1.left);
    }
}*/
