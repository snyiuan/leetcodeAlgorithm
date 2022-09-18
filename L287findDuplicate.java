package leetCode;

import java.util.ArrayList;
import java.util.List;

public class L287findDuplicate {
    public static void main(String[] args) {
        int[] arr1 = new int[] { 1, 3, 4, 2, 2 };
        int[] arr2 = new int[] { 3, 1, 3, 4, 2 };
        int[] arr3 = new int[] { 2, 5, 9, 6, 9, 3, 8, 9, 7, 1 };
        /*
         * System.out.println(findDuplicate(arr1));
         * System.out.println(findDuplicate(arr2));
         */
        System.out.println(findDuplicate(arr3));
    }

    public static int findDuplicate(int[] nums) {
        int l = 1;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= m) {
                    cnt++;
                }
            }
            if (cnt <= m) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l - 1;
    }

    public static int findDuplicate2(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        System.out.println(slow);
        System.out.println(fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        System.out.println(slow);
        System.out.println(fast);
        return slow;
    }
}
