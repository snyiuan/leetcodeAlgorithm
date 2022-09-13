package leetCode;

public class L1760minimumSize {
    public static void main(String[] args) {
        int[] arr = new int[]{2,4,8,2};
        System.out.println(minimumSize(arr, 4));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println((8-1)/4);

    }

    public static int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 1000000000;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(nums, mid, maxOperations)) {
                right = mid - 1;
                ans = (int) mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static boolean check(int[] nums, int cost, int maxOperations) {
        long ops = 0;
        for (int i = 0; i < nums.length; i++) {
            ops += (nums[i] - 1) / cost;
        }
        return ops <= maxOperations;
    }
}
