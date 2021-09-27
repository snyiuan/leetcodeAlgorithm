package leetCode;

import java.util.Arrays;

/**
 * @author zzq
 * @create 2021-09-27-9:55
 */
public class L213rob {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1};
        L213rob self = new L213rob();

        System.out.println(self.rob(arr));
        System.out.println(self.rob(new int[]{1}));
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int first = robRange(nums, 0, nums.length - 1);
        int second = robRange(nums, 1, nums.length);
        return Math.max(first, second);
    }

    private int robRange(int[] nums, int start, int end) {
        int prep = 0;
        int pre = 0;
        int cur = nums[0];
        for (int i = start; i < end; i++) {
            cur = Math.max(pre, nums[i] + prep);
            prep = pre;
            pre = cur;
        }
        return cur;
    }

    public int rob2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int first = rob198(Arrays.copyOfRange(nums, 0, nums.length - 1));
        int second = rob198(Arrays.copyOfRange(nums, 1, nums.length));
        return Math.max(first, second);
    }

    private int rob198(int[] nums) {
        int prep = 0;
        int pre = 0;
        int cur = nums[0];
        for (int i = 0; i < nums.length; i++) {
            cur = Math.max(pre, nums[i] + prep);
            prep = pre;
            pre = cur;
        }
        return cur;
    }

}
