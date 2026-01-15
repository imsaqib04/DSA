import java.util.Scanner;

public class BinomialCoefficients {
    long mod = 1000000000+7;

    public static void main(String[] args) {


        // calculate the nCr
        Scanner sc = new Scanner ( System.in );
        int T = sc.nextInt ();
        StringBuilder sb = new StringBuilder ();
        BinomialCoefficients bc = new BinomialCoefficients();

        while(T>0) {
            int n = sc.nextInt ();
            int r = sc.nextInt ();

            if (r > n) {
                sb.append ( 0 ).append ( "\n");
            } else {
                sb.append ( bc.ncr ( n,r )).append ( "\n" );
            }
        T--;
        }
        System.out.println (sb.toString ());
    }

    long PowerMod(long base,long exp){
        long res= 1;
        base = base%mod;

        while(exp>0){
            if(exp%2==1){
                res = (res * base )%mod;
            }
            exp = exp/2;
            base = (base * base)%mod;
        }
        return res;
    }

    long inverse_mod(long a){
        return PowerMod ( a,mod-2 );
    }
    long fact(long n){
        long ans= 1;
        for(long i =2;i<=n;i++){
            ans = ( ans * i ) % mod;
        }
        return ans;
    }

    long ncr(long n, long r){
        long num = fact(n);
        long den = (fact(r) * fact(n-r) ) % mod;
        return (num * inverse_mod ( den ))%mod;
    }
}