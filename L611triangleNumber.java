package leetCode;

import java.util.Arrays;

public class L611triangleNumber {
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 2, 3, 4 };
        // 333,334,334
        int[] arr2 = new int[] { 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 8, 8, 9, 9, 10 };
        System.out.println(triangleNumber(arr));
    }

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        if (nums.length < 3) {
            return count;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int sum = nums[i] + nums[j];
                int l = j + 1;
                int r = nums.length - 1;
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    if (nums[m] >= sum) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
                count += r - j;
            }
        }
        return count;
    }

    public static int triangleNumber1(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        if (nums.length < 3) {
            return count;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] > nums[k]) {
                        count++;
                    }
                }
            }
        }
        return count;

    }
}
