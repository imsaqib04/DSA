public class Test_Algorithm {
    public static void main(String[] args) {


        int arr[] = {2, 5, 1, 66, 55, 6, 17, 8};


        Straight_Max_Min.MinMax result = Straight_Max_Min.maxminelement ( arr );

        System.out.println (result.max);
        System.out.println (result.min);
    }

}
