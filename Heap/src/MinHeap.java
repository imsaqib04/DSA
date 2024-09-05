/*

// #using array

public class MinHeap {

    public static void insert(int arr[], int size, int value) {

        size = size + 1;
        arr[size-1] = value;
        int index = size-1;

        while (index > 0) {
            int parent = index / 2;
            if (arr[parent] > arr[index]) {
                swap ( arr, index, parent );
//                index = parent;
            }
            else{
                return;
            }
        }
    }

    public static void swap(int[] arr, int index, int parent) {
        int temp = arr[index];
        arr[index] = arr[parent];
        arr[parent] = temp;
    }

    public static void main(String[] args) {
        int [] arr = new int[7];
        int [] value = {1,13,14,6,17,9,11};
        int size = 0;

        for(int i = 0; i<value.length;i++){
            insert ( arr,size,value[i] );
            size++;
            System.out.println ("After Inserting " + value[i]+":" );

            for(int j = 0; j<size;j++){
                System.out.println (arr[j]+ " ");
            }
            System.out.println ();
        }


    }
}
*/

import java.util.LinkedList;

import java.util.Queue;

class Node {
    int value;
    Node left;
    Node right;
    Node parent;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}


class MinHeap {

//    ArrayList<Node>List;
    Node root;
    Node lastNode; // To track the last node during insertion

    public MinHeap() {
        this.root = null;
        this.lastNode = null;
    }

    public void insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            lastNode = root;
        } else {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                Node current = queue.poll();

                if (current.left == null) {
                    current.left = newNode;
                    newNode.parent = current;
                    lastNode = newNode;
                    break;
                } else if (current.right == null) {
                    current.right = newNode;
                    newNode.parent = current;
                    lastNode = newNode;
                    break;
                } else {
                    queue.add(current.left);
                    queue.add(current.right);
                }
            }

            heapifyUp(newNode);
        }
    }

    public void delete() {
        if (root == null) return;

        if (root == lastNode) {
            root = null;
            lastNode = null;
            return;
        }

        // Replace root value with last node's value
        root.value = lastNode.value;

        // Remove last node and update lastNode reference
        if (lastNode.parent.right == lastNode) {
            lastNode.parent.right = null;
        } else {
            lastNode.parent.left = null;
        }

        // Update the last node reference by traversing the tree
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node current = null;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
        lastNode = current;

        // Restore the min-heap property
        heapifyDown(root);
    }

    public void heapifyUp(Node node) {
        while (node.parent != null && node.value < node.parent.value) {
            swap(node, node.parent);
            node = node.parent;
        }
    }

    public void heapifyDown(Node node) {
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

    public void swap(Node a, Node b) {
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

        minHeap.delete();
        minHeap.delete();



        System.out.println("Heap elements after deletion:");
        minHeap.printHeap();
    }
}


