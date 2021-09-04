package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zzq
 * @create 2021-09-04-9:57
 */
public class L167twosum {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twosum(arr, 9)));

    }

    public static int[] twosum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] twosum2(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < numbers.length; i++) {
            int res = target - numbers[i];
            if (map.containsKey(res)) {
                return new int[]{map.get(res) + 1, i + 1};
            } else {
                map.put(numbers[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] twosum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int num = target - numbers[i];
            int right = binarySearch(numbers, i + 1, num);
            if (right != -1) {
                return new int[]{i + 1, right + 1};
            }
        }
        return new int[]{-1, -1};
    }

    public static int binarySearch(int[] arr, int L, int target) {
        int l = L;
        int r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] < target) {
                l = m + 1;
            } else if (arr[m] > target) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }

}
