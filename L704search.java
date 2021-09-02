package leetCode;

import java.util.Arrays;

/**
 * @author zzq
 * @create 2021-09-02-10:51
 */
public class L704search {
    public static void main(String[] args) {
//        int[] arr = new int[]{9, 8, 7, 5, 6, 4, 3, 1, 2};
        int[] arr = new int[]{-1, 0, 1, 2, 4, 5, 6, 8, 9, 10};
        System.err.println(search(arr, 3));
        System.err.println(search(arr, 10));
        System.out.println(Arrays.binarySearch(arr, 3));
    }

    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int m;
        while (l <= r) {
            m = (int) Math.floor((l + r) / 2);
            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
