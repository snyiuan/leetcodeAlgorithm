package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zzq
 * @create 2021-09-21-9:53
 */
public class L547findCircleNum {
    public static void main(String[] args) {
        L547findCircleNum self = new L547findCircleNum();
        int[][] arr = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] arr2 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int[][] arr3 = {{1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}};

        System.out.println(self.findCircleNum(arr));
        System.out.println(self.findCircleNum(arr2));
        System.out.println(self.findCircleNum(arr3));
    }

    public int findCircleNum(int[][] isConnected) {
        return 1;

    }

    public int findCircleNum1(int[][] isConnected) {
        int m = isConnected.length;
        int n = isConnected[0].length;
        boolean[] visit = new boolean[m];
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (!visit[i]) {
                dfs(isConnected, visit, m, n, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, boolean[] visit, int m, int n, int i) {
        for (int j = 0; j < m; j++) {
            visit[i] = true;
            if (isConnected[i][j] == 1 && !visit[j]) {
                dfs(isConnected, visit, m, n, j);
            }
        }
    }
}
