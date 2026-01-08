class MyPow {
    public double myPow(double x, int n) {

        long N = n;

        return solve(x,N);

    }

    double solve(double x ,long N){

        if (N == 0) return 1.0;

        if(N<0){
            x = 1/x;
            N=-N;
        }

        if(N%2==0){
            return solve(x*x,N/2);

        }
        return x*solve(x*x,(N-1)/2);

    }
}

//    double ans = 1.0;
//    double currprd = x;

//    while(N>0){
//     if(N%2==1){
//         ans = ans * currprd;
//     }
//     currprd = currprd * currprd;
//     N= N/2;

//    }
//    return ans;