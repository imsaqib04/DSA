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

public class BalanceBinaryTree {

        public boolean isBalanced(TreeNode root) {
            if(root == null){
                return true;
            }
            if(height(root)!=-1){
                return true;
            }
            return false;
        }

        public int height(TreeNode root){
            if(root == null){
                return 0;
            }
            int left = height(root.left);
            int right = height(root.right);
            if(left == -1 || right ==-1){
                return -1;
            }
            if(Math.abs(left-right)>1){
                return -1;
            }
            return Math.max(left,right)+1;
        }
    }


//    public boolean isBalanced(TreeNode root) {  //one test case fail
//
//        if (root == null) {
//            return true;
//        }
//
//        int lh = height ( root.left );
//        int rh = height ( root.right );
//
//        if (Math.abs ( lh - rh ) <= 1) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    int height(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        int lh = height ( root.left );
//        int rh = height ( root.right );
//
//        return Math.max ( lh, rh ) + 1;
//    }
//}