import java.util.Arrays;

class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] c = new int [nums1.length+nums2.length];

        for(int i=0;i<nums1.length;i++){
            c[i] = nums1[i];
        }
        for (int i=0;i<nums2.length;i++){
            c[nums1.length + i] = nums2[i];
        }
        Arrays.sort(c);

        // double sum = 0;

        // for(int i = 0; i <= c.length-1;i++){
        //     sum = sum + c[i];
        // }
        // double result = sum/c.length;
        // return result;

        int n = c.length;

        if(n%2 == 0){
            int mid1 = n/2;
            int mid2 = mid1-1;
            return ((c[mid1]+c[mid2])/2.0);
        }
        else{
            return c[n/2];
        }
    }
}