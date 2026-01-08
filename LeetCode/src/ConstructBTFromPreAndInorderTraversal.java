import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromPreAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inOrderIndexMap = new HashMap<> ();

        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put ( inorder[i], i );
        }

        return splitTree ( preorder, inOrderIndexMap, 0, 0, inorder.length - 1 );
    }

    private TreeNode splitTree(int[] preorder, Map<Integer, Integer> inOrderIndexMap, int rootIndex, int left, int right) {
        if (left > right) {
            return null;
        }

        TreeNode root = new TreeNode ( preorder[rootIndex] );
        int mid = inOrderIndexMap.get ( preorder[rootIndex] );

        if (mid > left) {
            root.left = splitTree ( preorder, inOrderIndexMap, rootIndex + 1, left, mid - 1 );
        }

        if (mid < right) {
            root.right = splitTree ( preorder, inOrderIndexMap, rootIndex + (mid - left) + 1, mid + 1, right );
        }

        return root;
    }
}
