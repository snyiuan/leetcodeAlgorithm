package leetCode;

/**
 * @author zzq
 * @create 2021-09-16-11:00
 */
public class L74searchMatrix {
    public static void main(String[] args) {
        L74searchMatrix self = new L74searchMatrix();
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(self.searchMatrix(matrix, 3));
        System.out.println(self.searchMatrix(new int[][]{{1}}, 1));

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int len = m * n ;
        int l = 0;
        int r = len - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midx = mid / n;
            int midy = mid % n;
            if (matrix[midx][midy] > target) {
                r = mid - 1;
            } else if (matrix[midx][midy] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
