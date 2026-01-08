public class ContainerWithMostWater {
    public int maxArea(int[] height) {

        int maxWater = 0;
        int n = height.length;
        int l = 0;
        int r = n - 1;

        while (l < r) {
            int w = r - l;
            int ht = Math.min ( height[l], height[r] );
            int currWater = ht * w;
            maxWater = Math.max ( maxWater, currWater );

            // height[l] < height[r] ? l++ : r--;
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxWater;
    }
}

    //     int maxWater = 0;
    //     int n = height.length;
    //     for(int i = 0; i<n-1;i++){
    //         for(int j=i+1;j<n;j++){
    //             int w = j-i;
    //             int ht = Math.min(height[i],height[j]);
    //             int currWater = w*ht;

    //             maxWater = Math.max(currWater,maxWater);
    //         }
    //     }
    //     return maxWater;
    // }

