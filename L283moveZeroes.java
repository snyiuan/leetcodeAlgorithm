package leetCode;

import java.util.*;

/**
 * @author zzq
 * @create 2021-08-29-17:14
 */
public class L283moveZeroes {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        while (right < len) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
