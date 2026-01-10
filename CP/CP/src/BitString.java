import java.util.Scanner;

// log(n)
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        int n = sc.nextInt ();

        long mod = 1000000007L;

        long ans = power ( 2,n,mod );
        System.out.println (ans);

    }
    static long power(long base,long exp, long mod){
        long res = 1;
        base = base%mod;
        while(exp>0){
            if(exp%2==1){             //  exp&1=1
                res = (res*base)%mod;
            }
                base = (base*base)%mod;
            exp = exp/2;               //exp>>1;
        }
        return res;
    }
}



// o(n)
//import java.util.Scanner;
//
//class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        long mod = 1000000007L;
//        long ans = 1;
//
//        for(int i = 0; i < n; i++) {
//            ans = (ans * 2) % mod;
//        }
//
//        System.out.println(ans);
//        sc.close();
//    }
//}