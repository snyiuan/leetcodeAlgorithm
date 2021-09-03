package leetCode;

import java.util.Arrays;

/**
 * @author zzq
 * @create 2021-09-03-18:04
 */
public class L977sortedSquares {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 6, 4, 5, 3, 2, 1};
        int[] arr2 = new int[]{-4, -1, 0, 3, 10};

        System.out.println(Arrays.toString(sortedSquares(arr2)));

    }

    public static int[] sortedSquares(int[] nums) {
        int i = 0;
        int len = nums.length;
        int j = len - 1;
        int pos = len - 1;
        int[] res = new int[len];
        while (i <= j) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                res[pos--] = nums[i] * nums[i];
                i++;
            } else {
                res[pos--] = nums[j] * nums[j];
                j--;
            }
        }
        return res;
    }

}
