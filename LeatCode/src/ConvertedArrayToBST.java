public class ConvertedArrayToBST {
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
    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }
        return ConstructBST ( nums, 0, nums.length - 1 );
    }

    private TreeNode ConstructBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode ( nums[mid] );

        root.left = ConstructBST ( nums, left, mid - 1 );
        root.right = ConstructBST ( nums, mid + 1, right );
        return root;
    }
}
