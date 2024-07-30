public class Test {
    public static void main(String[] args) {

        int[] arr = {5, 3, 8, 2, 9, 1};

        int n = arr.length;
        BubbleSort bs = new BubbleSort();
        BubbleSort.BS (arr,n);
        bs.printArray (arr,n);

    }
}

