class SumOfAllOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[] arr) {
        int totalSum = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            // Step 1: Total subarrays jisme arr[i] aata hai
            // Left Options * Right Options
            // Left Options = i + 1 (0 se i tak indices)
            // Right Options = n - i (i se n-1 tak indices)
            int totalSubarrays = (i + 1) * (n - i);

            // Step 2: Odd Subarrays kitne honge?
            // Formula: (Total + 1) / 2
            // Example: Agar total 3 hain -> 2 odd honge. Agar 4 hain -> 2 odd honge.
            int oddSubarrays = totalSubarrays/2;
            if(totalSubarrays%2==1){
                oddSubarrays++;
            }

            // Step 3: Contribution add karo
            totalSum += arr[i] * oddSubarrays;
        }

        return totalSum;
    }
}

//public class SumOfAllOddLengthSubarrays {
//        public int sumOddLengthSubarrays(int[] arr) {
//
//            int n = arr.length;
//            int totalSum = 0;
//
//            for(int i =0;i<n;i++){
//
//                for(int j = i;j<n;j++){
//                    int length = j-i+1;
//
//                    if(length%2!=0){
//                        int sumofsubarrcurr = 0;
//                        for(int k = i;k<=j;k++){
//
//                            sumofsubarrcurr += arr[k];
//                        }
//
//                        totalSum = totalSum + sumofsubarrcurr;
//                    }
//                }
//            }
//            return totalSum;
//        }
//    }