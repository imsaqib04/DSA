public class Test {
    public static void main(String[] args) {

        int[] arr = {5, 3, 8, 2, 9, 1};

        MergeSort ms = new MergeSort ();

        MergeSort.MS ( arr,0,arr.length-1 );

            for (int i : arr) {
                System.out.print(i + " ");
            }


















//        int n = arr.length;
//        BubbleSort bs = new BubbleSort();
//        BubbleSort.BS (arr,n);
//        bs.printArray (arr,n);

    }
}

