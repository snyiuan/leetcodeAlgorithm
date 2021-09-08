package leetCode;

/**
 * @author zzq
 * @create 2021-09-08-9:54
 */
public class L695maxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        L695maxAreaOfIsland self = new L695maxAreaOfIsland();
        System.out.println(self.maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, subCount(grid, i, j));
                }
            }
        }
        return max;
    }

    private int subCount(int[][] grid, int si, int sj) {
        if (si < 0 || si >= grid.length || sj < 0 || sj >= grid[0].length) {
            return 0;
        }
        if (grid[si][sj] == 1) {
            grid[si][sj] = 0;
            return 1 + subCount(grid, si - 1, sj)
                    + subCount(grid, si, sj - 1)
                    + subCount(grid, si + 1, sj)
                    + subCount(grid, si, sj + 1);
        }
        return 0;
    }
}
