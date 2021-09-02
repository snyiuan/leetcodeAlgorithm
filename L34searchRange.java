package leetCode;

import java.util.Arrays;

/**
 * @author zzq
 * @create 2021-08-28-0:36
 */
public class L34searchRange {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 7, 8, 8, 10};
        int[] arr2 = new int[]{8};
        int[] arr3 = new int[]{5, 8};
        int[] arr4 = new int[]{1, 2, 3, 8, 9, 10};
        int[] arr5 = new int[]{1, 2, 3, 9, 10};
        int[] arr6 = new int[]{8, 9, 10, 11};
        System.out.println(binarySearch(arr2, 8));
        System.out.println(binarySearch(arr3, 8));
        System.out.println(binarySearch(arr4, 8));
        System.out.println(binarySearch(arr5, 8));
        System.out.println(binarySearch(arr6, 8));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int start = finLeftBorder(nums, target);
        if (start == -1) return new int[]{-1, -1};
        int end = finRightBorder(nums, target);
        return new int[]{start, end};
    }

    public static int finLeftBorder(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l + 1 < r) {
            int m = (int) Math.floor((l + r) / 2);
            if (nums[m] < target) {
                l = m;
            } else {
                r = m;
            }
        }
        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        return -1;
    }

    public static int finRightBorder(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l + 1 < r) {
            int m = (int) Math.floor((l + r) / 2);
            if (nums[m] > target) {
                r = m;
            } else {
                l = m;
            }
        }
        if (nums[r] == target) return r;
        if (nums[l] == target) return l;
        return 1;
    }

    public static int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int m;
        while (l + 1 < r) {
            m = (int) Math.floor((l + r) / 2);
            if (nums[m] < target) {
                l = m;
            } else if (nums[m] > target) {
                r = m;
            } else {
                return m;
            }
        }
        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        return -1;
    }
}