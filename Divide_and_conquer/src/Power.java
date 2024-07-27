public class Power {

    public static int pow(int num, int x) {

        if (x == 1){
            return num;
        }

        if (x % 2 == 0) {
            int k = pow ( num, x / 2 );
            return k * k;
        }

        else {
            int k = pow ( num, (x - 1) / 2 );
            return k * k * num;
        }
    }
}

