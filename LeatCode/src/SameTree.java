public class SameTree {
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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree ( p.left, q.left ) && isSameTree ( p.right, q.right );
    }
}

/*

Queue <TreeNode> node = new LinkedList<>();

        node.add(p);
        node.add(q);

        while(!node.isEmpty()){
TreeNode node1 = node.poll();
TreeNode node2 = node.poll();

            if (node1 == null && node2 == null) {
        continue;
        }

        if (node1 == null || node2 == null || node1.val != node2.val) {
        return false;
        }

        node.add(node1.left);
            node.add(node2.left);
            node.add(node1.right);
            node.add(node2.right);
        }

                return true;
*/
