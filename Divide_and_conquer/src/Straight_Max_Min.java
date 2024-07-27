public class Straight_Max_Min
{

    public static class MinMax
    {
        int min;
        int max;
    }
    public static MinMax maxminelement (int[] arr)
    {

            int min = arr[0];
            int max = arr[0];

            for (int i = 0; i < arr.length; i++)
            {
                if (arr[i] > max)
                    max = arr[i];
                 else if (arr[i] < min)
                     min = arr[i];
            }

            MinMax result = new MinMax ();
            result.max = max;
            result.min = min;
            return result;
    }
}



