class PrimeNumber {
    public boolean isPrime(int n) {

        //  if (n <= 1)
        //     return false;

        // // Check divisibility from 2 to n-1
        // for (int i = 2; i < n; i++)
        //     if (n % i == 0)
        //         return false;

        // return true;

        // optimized way for large inputs!

        if(n<2){
            return false;
        }
        if(n==2){
            return true;
        }
        if(n%2==0){
            return false;
        }
        for(int i =3;i*i<=n;i+=2){
            if(n%i==0){
                return false;
            }
        }
        return true;

    }
}