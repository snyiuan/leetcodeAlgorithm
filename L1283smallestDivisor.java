package leetCode;

public class L1283smallestDivisor {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 5, 9 };

        System.out.println(smallestDivisor(arr, 5));
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int r = 1000000;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(nums, mid, threshold) <= threshold) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static int check(int[] nums, int divider, int threshold) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt += (nums[i] + divider - 1) / divider;
            if (cnt > threshold) {
                return cnt;
            }
        }
        return cnt;
    }
}
