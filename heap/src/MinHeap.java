import java.util.LinkedList;
import java.util.Queue;

class Node {
    int value;
    Node left, right, parent;

    public Node(int value) {
        this.value = value;
    }
}

class MinHeap {
    private Node root;
    private Node lastNode;

    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
//            newNode = lastNode;
        } else {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty ()) {
                Node current = queue.poll();

                if (current.left == null) {
                    current.left = newNode;
                    newNode.parent = current;  // Correctly set the parent
                    break;
                } else if (current.right == null) {
                    current.right = newNode;
                    newNode.parent = current;  // Correctly set the parent
                    break;
                } else {
                    queue.add(current.left);
                    queue.add(current.right);
                }
            }
            lastNode = newNode;  // Correctly update lastNode after insertion
            heapifyUp(newNode);   //method is called to maintain the heap property
        }
    }

    public void delete() {
        if (root == null) return;

        if (root == lastNode) {   //only one value
            lastNode = null;
            return;
        }

        root.value = lastNode.value; // Replace root value with last node's value
        if (lastNode.parent.right == lastNode) {
            lastNode.parent.right = null;
        } else {
            lastNode.parent.left = null;
        }

        updateLastNode();
        heapifyDown(root);   //maintain heap property

    }

    private void updateLastNode() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node current = null;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        lastNode = current; // The last node in the level-order traversal
    }

    private void heapifyUp(Node node) {
        while (node.parent != null && node.value < node.parent.value) {
            swap(node, node.parent);
            node = node.parent;
        }
    }

    private void heapifyDown(Node node) {
        while (node.left != null) {
            Node smallerChild = node.left;
            if (node.right != null && node.right.value < node.left.value) {
                smallerChild = node.right;
            }

            if (node.value > smallerChild.value) {
                swap(node, smallerChild);
                node = smallerChild;
            } else {
                break;
            }
        }
    }


    private void swap(Node a, Node b) {
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }

    public void printHeap() {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(3);
        minHeap.insert(4);
        minHeap.insert(5);

        System.out.println("Heap elements after insertion:");
        minHeap.printHeap();

        System.out.println("Heap elements after deletion:");
        minHeap.delete();
        minHeap.delete();

        minHeap.printHeap();
    }
}
