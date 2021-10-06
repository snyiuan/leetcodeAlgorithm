package leetCode;

/**
 * @author zzq
 * @create 2021-10-03-10:47
 */
public class L583minDistance {
    public static void main(String[] args) {

    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for (int i = 1; i <= m; i++) {
            char ch1 = word1.charAt(i);
            for (int j = 1; j <= n; j++) {
                char ch2 = word2.charAt(j);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int l = dp[m][n];
        return m - l + n - l;
    }
}
