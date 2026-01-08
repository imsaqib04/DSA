import java.util.LinkedList;
import java.util.Queue;

public class _01Matrix {

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;  // number of rows
        int n = mat[0].length; // number of columns

        Queue<int[]> queue = new LinkedList<> ();  //for store co-ordinates

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {         // traverse full matrix
                if (mat[i][j] == 0) {
                    queue.offer ( new int[]{i, j} );  // add in queue
                } else {
                    mat[i][j] = -1;                //   if one is present then dist not calculated and replace 1 to -1
                }
            }
        }

        //[ [0, 0, 0],
        //  [0, -1, 0],
        //  [-1, -1, -1] ]

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};   //defines 4 possible directions you can move in the matrix: up, down, left, and right

        //BFS

        while (!queue.isEmpty ()) {
            int[] cell = queue.poll ();
            for (int[] d : dir) {
                                            // d = dir[i][0]  // d = dir[i][1]
                int r = cell[0] + d[0];   //calculates the row of the neighboring cell by adding the row direction d[0] to the current cell's row.
                int c = cell[1] + d[1];   //calculates the column of the neighboring cell by adding the column direction d[1] to the current cell's column.

                if (r < 0 || r >= m || c < 0 || c >= n || mat[r][c] != -1) {  // check it is not out of bound or matrix
                    continue;
                }
                queue.add ( new int[]{r, c} );              //Updating the distance for valid cells
                mat[r][c] = mat[cell[0]][cell[1]] + 1;
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        _01Matrix test = new _01Matrix ();

        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        // Call updateMatrix method
        int[][] result = test.updateMatrix ( mat );

        // Print the resulting matrix
        System.out.println ( "Updated Matrix:" );
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print ( result[i][j] + " " );
            }
            System.out.println ();
        }
    }
}