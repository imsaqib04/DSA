// 5-March
public class CountTotalNumberOfColoredCells {
    public long coloredCells(int n) {
        // return (n*n) + (n-1)*(n-1);
        // return 2 * n * n - 2 * n + 1;
        return 2L * n * n - 2L * n + 1;


        // time 1  ||  grid fill 1             = 1
        // time 2  ||  grid fill 4 + 1(center) = 5
        // time 3  ||  grid fill 8 + 5         = 13
        // n^2+(n-1)^2
        // 2n^2-2n+1
    }
}