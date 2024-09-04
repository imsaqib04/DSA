import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BST {

    Node root;

    public void insertInBST(Node node, int key) {

        if (this.root == null) {
            this.root = new Node ( key );
        }
        else {
            if (key < node.key) {

                if (node.left == null) {
                    node.left = new Node ( key );
                } else {
                    insertInBST ( node.left, key );
                }
            }
            else {
                if (node.right == null) {
                    node.right = new Node ( key );
                } else {
                    insertInBST ( node.right, key );
                }
            }
        }
    }


    void preordertraverse(Node node) {
        if (node != null) {
            preordertraverse ( node.left );
            preordertraverse ( node.right );
            System.out.print ( node.key + " " );
        }
    }


    void inordertraverse(Node node){
        if(node != null){
            inordertraverse ( node.left );
            System.out.println (node.key);
            inordertraverse ( node.right );
        }
    }


    void postordertraverse(Node node){
        if(node != null){
            System.out.print ( node.key + " ");
            postordertraverse ( node.left );
            postordertraverse ( node.right );
        }
    }


    public void breadthFirstTraversal(Node root) {


        System.out.println ("\n\n-------------BFS------------");

        Queue<Node> queue = new ArrayDeque<> ();

        if (root == null) {
            System.out.println ( "Tree is empty" );
        }
        else {
            queue.add ( root );
            while (!queue.isEmpty ()) {
                Node n = queue.poll ();
                System.out.println ( n.key + " " );
                if (n.left != null) {
                    queue.add ( n.left );
                }
                if (n.right != null) {
                    queue.add ( n.right );
                }
            }
        }
    }


    public void depthFirstSearch(Node node) {

        System.out.println ("\n-------------DFS-------------");

        Stack<Node> stack = new Stack<> ();

        if (root == null) {
            System.out.println ( "Tree is empty" );
        }
        else {
            stack.push ( node );

            while (!stack.isEmpty ()) {
                Node n= stack.pop ();
                System.out.println ( n.key );

                if (n.right != null) {
                    stack.push ( n.right );
                }
                if (n.left != null) {
                    stack.push ( n.left );
                }
            }
        }
    }

    public static void main(String[] args) {

        BST mybst = new BST ();

        mybst.insertInBST ( mybst.root, 5 );
        mybst.insertInBST ( mybst.root, 1 );
        mybst.insertInBST ( mybst.root, 2 );
        mybst.insertInBST ( mybst.root, 6 );
        mybst.insertInBST ( mybst.root, 9 );
        mybst.insertInBST ( mybst.root, 11 );
        mybst.insertInBST ( mybst.root, 19 );

        mybst.preordertraverse ( mybst.root );        //preorder

        mybst.inordertraverse ( mybst.root );         //inorder

        mybst.postordertraverse ( mybst.root );       //postorder

        mybst.breadthFirstTraversal ( mybst.root );   //BFS (level order traversal)

        mybst.depthFirstSearch ( mybst.root );        //DFS

    }


}