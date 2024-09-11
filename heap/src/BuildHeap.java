public class BuildHeap {

    void minheapify(int arr[],int i,int n){
        int smallest = i;
        int left = 2*i+1;          // left position
        int right = 2*i+2;         // right position

        if(left<n && arr[left] < arr[smallest]){
            smallest = left;
        }

        if(right < n && arr[right] < arr[smallest]){
            smallest = right;
        }

        if(smallest!=i){

            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            minheapify ( arr,smallest,n);  //recursively call the method
        }
    }

    void buildHeap(int [] arr,int n){

        int startIndex = (n/2)-1;

        for (int i =startIndex;i>=0;i--){
            minheapify(arr,i,n);
        }
    }

    void print(int arr[],int n){
        for(int i= 0;i<n;i++){
            System.out.println (arr[i]+" ");
        }
        System.out.println ();
    }

    public static void main(String[] args) {
        BuildHeap bh = new BuildHeap ();
        int []arr= {1,2,3,4,5,6,7,8,9};
        int n = arr.length;
        bh.buildHeap ( arr,n );
        bh.print ( arr,n);
    }

}
