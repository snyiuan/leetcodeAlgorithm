package leetCode;

/**
 * @author zzq
 * @create 2021-09-21-9:30
 */
public class L200numIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        L200numIslands self = new L200numIslands();
//        System.out.println(grid[0][0] == '1');
        System.out.println(self.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] seen = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && seen[i][j] != 1) {

                    /**
                     Stack ??
                     **/

                }
            }
        }
        return count;
    }

    public int numIslands2(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] seen = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && seen[i][j] != 1) {
                    search(grid, m, n, i, j, seen);
                    count++;
                }
            }
        }
        return count;
    }

    private void search(char[][] grid, int m, int n, int i, int j, int[][] seen) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (seen[i][j] == 1) {
            return;
        } else if (grid[i][j] == '1') {
            seen[i][j] = 1;
            search(grid, m, n, i - 1, j, seen);
            search(grid, m, n, i + 1, j, seen);
            search(grid, m, n, i, j - 1, seen);
            search(grid, m, n, i, j + 1, seen);
        }
    }
}
