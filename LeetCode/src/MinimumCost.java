class MinimumCost {
    public int minimumCost(int[] nums) {

    /*    int n = nums.length;
        int ans = Integer.MAX_VALUE;

        for(int i = 1;i<n-1;i++){

            for(int j = i + 1;j<n;j++){

                int cost = nums[0]+nums[i]+nums[j];

                ans = Math.min(cost,ans);
            }

        }

        return ans; */

        int n= nums.length;

        int fristNum = nums[0];
        int min1  = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int i = 1; i<n; i++){

            if(nums[i]<min1){
                min2 = min1;
                min1 = nums[i];
            }
            else if(nums[i]<min2){
                min2 = nums[i];
            }
        }

        return fristNum + min1 +min2;
    }
}