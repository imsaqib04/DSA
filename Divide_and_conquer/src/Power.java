public class Power {

    public static int pow(int n, int x) {

        if (x == 1){
            return n;
        }

        if (x % 2 == 0) {
            int p = pow ( n, x / 2 );
            return p * p;
        }

        else {
            int k = pow ( n, (x - 1) / 2 );
            return k * k * n;
        }
    }
}

