public class FloodFIll {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // If the new color is the same as the old color, no need to do anything
        if (color == image[sr][sc]) {
            return image;
        }

        // Call the DFS function to start filling
        DFS ( image, sr, sc, color, image[sr][sc] );
        return image;
    }

    public void DFS(int[][] image, int row, int column, int color, int oldColor) {
        // Check if the row and column are out of bounds or the color is not the old color
        if (row < 0 || row >= image.length || column < 0 || column >= image[0].length || image[row][column] != oldColor) {
            return;
        }

        // Set the current pixel to the new color
        image[row][column] = color;

        // Recursively call DFS for neighboring pixels
        DFS ( image, row - 1, column, color, oldColor ); // Up
        DFS ( image, row + 1, column, color, oldColor ); // Down
        DFS ( image, row, column - 1, color, oldColor ); // Left
        DFS ( image, row, column + 1, color, oldColor ); // Right
    }

    public static void main(String[] args) {
        // Declare and initialize a 2D array
        int[][] matrix = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        FloodFIll ff = new FloodFIll ();
        ff.floodFill ( matrix,1,1,2 );

        // Print the entire 2D array
        for (int i = 0; i < matrix.length; i++) {          // Loop through rows
            for (int j = 0; j < matrix[i].length; j++) {   // Loop through columns
                System.out.print ( matrix[i][j] + " " );
            }
            System.out.println ();  // Move to the next line after each row
        }
    }
}