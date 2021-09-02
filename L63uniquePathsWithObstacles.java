package leetCode;

/**
 * @author zzq
 * @create 2021-08-29-11:44
 */
public class L63uniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] arr1 = new int[][]{{1, 0}};
//        int[][] arr1 = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(arr));
        System.out.println(uniquePathsWithObstacles(arr1));
//        System.out.println(uniquePathsWithObstacles(arr1));


    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                f[i][0] = 0;
            } else {
                f[i][0] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                f[0][i] = 0;
            } else {
                f[0][i] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];
    }
}
