////public class MinHeap {
////
////    public static void insert(int arr[], int size, int value) {
////
////        size = size + 1;
////        arr[size-1] = value;
////        int index = size-1;
////
////        while (index > 0) {
////            int parent = index / 2;
////            if (arr[parent] > arr[index]) {
////                swap ( arr, index, parent );
//////                index = parent;
////            }
////            else{
////                return;
////            }
////        }
////    }
////
////    public static void swap(int[] arr, int index, int parent) {
////        int temp = arr[index];
////        arr[index] = arr[parent];
////        arr[parent] = temp;
////    }
////
////    public static void main(String[] args) {
////        int [] arr = new int[7];
////        int [] value = {1,13,14,6,17,9,11};
////        int size = 0;
////
////        for(int i = 0; i<value.length;i++){
////            insert ( arr,size,value[i] );
////            size++;
////            System.out.println ("After Inserting " + value[i]+":" );
////
////            for(int j = 0; j<size;j++){
////                System.out.println (arr[j]+ " ");
////            }
////            System.out.println ();
////        }
////
////
////    }
////}
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//class Node {
//    int value;
//    Node left;
//    Node right;
//    Node parent;
//
//    public Node(int value) {
//        this.value = value;
//        this.left = null;
//        this.right = null;
//        this.parent = null;
//    }
//}
//
//class MinHeap {
//
//    Node root;
//
//    public MinHeap() {
//        this.root = null;
//    }
//
//    public void insert(int value) {
//        Node newNode = new Node(value);
//
//        if (root == null) {
//            root = newNode;
//        }
//        else {
//            List<Node> list = new ArrayList<>();
//            list.add(root);
//
//            for(int i=0; i<list.size (); i++){
//
//                Node current = list.get(i);
//
//                if (current.left == null) {
//                    current.left = newNode;
//                    newNode.parent = current;
//                    break;
//                }
//                else if (current.right == null) {
//                    current.right = newNode;
//                    newNode.parent = current;
//                    break;
//                }
//                else {
//                    list.add(current.left);
//                    list.add(current.right);
//                }
//            }
//
//            heapifyUp(newNode);
//        }
//    }
//
//    public void heapifyUp(Node node) {
//        while (node.parent != null && node.value < node.parent.value) {
////            swap(node, node.parent);
//
//            int temp = node.value;
//            node.value = node.parent.value;
//            node.parent.value = temp;
//
//           node = node.parent;
//        }
//    }
//
////    public void swap(Node a, Node b) {
////        int temp = a.value;
////        a.value = b.value;
////        b.value = temp;
////    }
//
//
//    public void printHeap() {
//        if (root == null) return;
//
//        List<Node> list = new ArrayList<>();
//        list.add(root);
//
//        int i = 0;
//        while (i < list.size()) {
//            Node current = list.get(i);
//            System.out.print(current.value + " ");
//
//            if (current.left != null)
//                list.add(current.left);
//            if (current.right != null)
//                list.add(current.right);
//
//            i++;
//        }
//        System.out.println();
//    }
//
//
//    public static void main(String[] args) {
//        MinHeap minHeap = new MinHeap();
//
//        minHeap.insert(1);
//        minHeap.insert(2);
//        minHeap.insert(3);
//        minHeap.insert(4);
//        minHeap.insert(5);
//
//        System.out.println("Heap elements after insertion:");
//        minHeap.printHeap();
//    }
//}











import java.util.ArrayList;
import java.util.List;

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

    Node root;

    public MinHeap() {
        this.root = null;
    }

    public void insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
        }
        else {
            List<Node> list = new ArrayList<>();
            list.add(root);

            for(int i=0; i<list.size (); i++){

                Node current = list.get(i);

                if (current.left == null) {
                    current.left = newNode;
                    newNode.parent = current;
                    break;
                }
                else if (current.right == null) {
                    current.right = newNode;
                    newNode.parent = current;
                    break;
                }
                else {
                    list.add(current.left);
                    list.add(current.right);
                }
            }

            heapifyUp(newNode);
        }
    }

    public void heapifyUp(Node node) {
        while (node.parent != null && node.value < node.parent.value) {
            int temp = node.value;
            node.value = node.parent.value;
            node.parent.value = temp;

            node = node.parent;
        }
    }

    public void heapifyDown(Node node) {
        while (node.left != null) {
            Node smallerChild = node.left;
            if (node.right != null && node.right.value < node.left.value) {
                smallerChild = node.right;
            }

            if (node.value < smallerChild.value) {
                break; // heap property satisfied
            }

            // Swap values
            int temp = node.value;
            node.value = smallerChild.value;
            smallerChild.value = temp;

            node = smallerChild;
        }
    }

    public void delete() {
        if (root == null) {
            System.out.println("Heap is empty!");
            return;
        }

        // Step 1: Find the last node
        Node lastNode = getLastNode();

        // Step 2: Replace root value with the last node's value
        if (lastNode != null) {
            root.value = lastNode.value;

            // Step 3: Remove the last node
            if (lastNode.parent != null) {
                if (lastNode.parent.left == lastNode) {
                    lastNode.parent.left = null;
                } else {
                    lastNode.parent.right = null;
                }
            } else {
                // This is the last node and the only node (root)
                root = null;
            }

            // Step 4: Heapify down from the root to maintain heap property
            if (root != null) {
                heapifyDown(root);
            }
        }
    }

    private Node getLastNode() {
        if (root == null) return null;

        List<Node> list = new ArrayList<>();
        list.add(root);

        Node lastNode = null;
        int i = 0;
        while (i < list.size()) {
            Node current = list.get(i);
            lastNode = current;

            if (current.left != null)
                list.add(current.left);
            if (current.right != null)
                list.add(current.right);

            i++;
        }

        return lastNode;
    }

    public void printHeap() {
        if (root == null) return;

        List<Node> list = new ArrayList<>();
        list.add(root);

        int i = 0;
        while (i < list.size()) {
            Node current = list.get(i);
            System.out.print(current.value + " ");

            if (current.left != null)
                list.add(current.left);
            if (current.right != null)
                list.add(current.right);

            i++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        minHeap.insert(10);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(6);
        minHeap.insert(5);

        System.out.println("Heap elements after insertion:");
        minHeap.printHeap();

        System.out.println("Deleting root element:");
        minHeap.delete();
        minHeap.printHeap();

        System.out.println("Deleting root element again:");
        minHeap.delete();
        minHeap.printHeap();
    }
}
