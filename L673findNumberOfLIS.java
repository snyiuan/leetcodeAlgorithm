package leetCode;

/**
 * @author zzq
 * @create 2021-10-02-11:08
 */
public class L673findNumberOfLIS {
    public static void main(String[] args) {
        L673findNumberOfLIS self = new L673findNumberOfLIS();
        int[] arr = {1, 3, 5, 4, 7};
        int[] arr2 = {2, 2, 2, 2, 2, 2};
        int[] arr3 = {1, 2, 4, 2, 4,  2};
//        System.out.println(self.findNumberOfLIS(arr));
        System.out.println(self.findNumberOfLIS(arr2));
//        System.out.println(self.findNumberOfLIS(arr3));
    }

    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int[] cnt = new int[len];
        int maxLen = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                res = cnt[i];
            } else if (dp[i] == maxLen) {
                res += cnt[i];
            }
        }
        return res;
    }


}
