import java.util.LinkedList;
import java.util.List;

/**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
public class ValidBinarySearchTree {
    public boolean isValidBST(TreeNode root) {

        List<Integer> inorderList = new LinkedList<> ();

        inorder ( root, inorderList );

        // int first = inorderList.get(0);

        for (int i = 1; i < inorderList.size (); i++) {
            if (inorderList.get ( i ) <= inorderList.get ( i - 1 )) {
                // first = inorderList.get(i);
                return false;
            }
        }
        return true;

    }

    void inorder(TreeNode node, List<Integer> inorderList) {

        if (node == null) {
            return;
        }

        inorder ( node.left, inorderList );
        inorderList.add ( node.val );
        inorder ( node.right, inorderList );

    }

}