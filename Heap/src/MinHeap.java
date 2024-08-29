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
        int [] value = {1,3,4,6,7,9,11};
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
