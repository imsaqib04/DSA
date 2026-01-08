class ReverseInteger {
    public int reverse(int x) {
        int rem;
        int sum =0;
        while(x!=0){
            if(sum>Integer.MAX_VALUE/10 || sum<Integer.MIN_VALUE/10){    // critical condition
                return 0;
            }

            rem = x%10;
            sum = sum*10+rem;
            x = x/10;
        }
        return sum;
    }
}