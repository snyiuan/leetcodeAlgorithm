package leetCode;

import java.util.Arrays;

/**
 * @author zzq
 * @create 2021-08-27-17:05
 */
public class L122maxProfit2 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{7, 1, 5, 3, 6, 4};
        int[] arr2 = new int[]{1, 2, 3, 4, 5};
        int[] arr3 = new int[]{7, 6, 4, 3, 1};
        System.out.println(maxProfit(arr1));
//        System.out.println(maxProfit(arr2));
//        System.out.println(maxProfit(arr3));
        //0 0   4   4   7   7
        //7 1   1   1   1   3
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
