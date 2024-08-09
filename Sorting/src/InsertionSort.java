public class InsertionSort {
    public void insertionAlgorithm(int []A){
        int n = A.length;
        for(int i =0; i<n; i++){
            int temp = A[i];
            int j = i-1;
            while (j>=0 && A[j]>temp){
                A[j+1] = A[j];
                j--;
            }
            A[j+1] = temp;
        }
    }
    public void printFunction(int []A){
        for(int i = 0; i<A.length; i++){
            System.out.print(A[i]+ " ");
        }
        System.out.println();
    }
}