package leetCode;

/**
 * @author zzq
 * @create 2021-08-29-9:53
 */
public class L62uniquePaths {
    public static void main(String[] args) {

    }

    public static int uniquePaths(int m, int n) {

        return 1;
    }

    public static int uniquePaths1(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            f[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
}