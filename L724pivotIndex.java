package leetCode;

import java.util.Arrays;

public class L724pivotIndex {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3 };
        System.out.println(pivotIndex(arr));
    }

    public static int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum == total - nums[i]) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}