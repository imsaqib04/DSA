import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {

        Queue<pair> q = new LinkedList<> ();
        int total = 0, rotten = 0, time = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) {
                    total++;
                }
                if (grid[i][j] == 2) {
                    q.offer ( new pair ( i, j ) );
                }
            }
        }

        if (total == 0) {
            return 0;
        }

        while (!q.isEmpty ()) {
            int size = q.size ();
            rotten = rotten + size;
            if (rotten == total) {
                return time;
            }
            time++;

            for (int i = 0; i < size; i++) {
                pair p = q.peek ();

                if (p.x + 1 < grid.length && grid[p.x + 1][p.y] == 1) {
                    grid[p.x + 1][p.y] = 2;
                    q.offer ( new pair ( p.x + 1, p.y ) );
                }

                if (p.x - 1 >= 0 && grid[p.x - 1][p.y] == 1) {
                    grid[p.x - 1][p.y] = 2;
                    q.offer ( new pair ( p.x - 1, p.y ) );
                }

                if (p.y + 1 < grid[0].length && grid[p.x][p.y + 1] == 1) {
                    grid[p.x][p.y + 1] = 2;
                    q.offer ( new pair ( p.x, p.y + 1 ) );
                }

                if (p.y - 1 >= 0 && grid[p.x][p.y - 1] == 1) {
                    grid[p.x][p.y - 1] = 2;
                    q.offer ( new pair ( p.x, p.y - 1 ) );
                }

                q.poll ();

            }

        }
        return -1;

    }

    static class pair {
        int x;
        int y;

        pair(int x, int y) {

            this.x = x;
            this.y = y;
        }
    }
}