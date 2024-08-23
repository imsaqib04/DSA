class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree ( root.left );
        invertTree ( root.right );

        return root;

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode ( 4 );
        root.left = new TreeNode ( 2 );
        root.right = new TreeNode ( 7 );
        root.left.left = new TreeNode ( 1 );
        root.left.right = new TreeNode ( 3 );
        root.right.left = new TreeNode ( 6 );
        root.right.right = new TreeNode ( 9 );

        System.out.println ( "Original Tree:" );
        printTree ( root );

        invertTree ( root );

        System.out.println ( "\nInverted Tree:" );
        printTree ( root );
    }

    // method to print the tree (pre-order traversal)
    public static void printTree(TreeNode node) {
        if (node != null) {
            System.out.print ( node.val + " " );
            printTree ( node.left );
            printTree ( node.right );
        }
    }
}