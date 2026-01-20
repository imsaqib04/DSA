public class SumOfAllOddLengthSubarrays {
        public int sumOddLengthSubarrays(int[] arr) {

            int n = arr.length;
            int totalSum = 0;

            for(int i =0;i<n;i++){

                for(int j = i;j<n;j++){
                    int length = j-i+1;

                    if(length%2!=0){
                        int sumofsubarrcurr = 0;
                        for(int k = i;k<=j;k++){

                            sumofsubarrcurr += arr[k];
                        }

                        totalSum = totalSum + sumofsubarrcurr;
                    }
                }
            }
            return totalSum;
        }
    }