package leetCode;

/**
 * @author zzq
 * @create 2021-10-02-9:38
 */
public class L1143longestCommonSubsequence {
    public static void main(String[] args) {
        String str = "12345";
        String str1 = "abcde";
        String str2 = "ace";
//        System.out.println(str.substring(4, 5));
        L1143longestCommonSubsequence self = new L1143longestCommonSubsequence();
        System.out.println(self.longestCommonSubsequence(str1, str2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char ch1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char ch2 = text2.charAt(j - 1);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }
        return dp[m][n];
    }
}
