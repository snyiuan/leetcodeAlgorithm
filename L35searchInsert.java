package leetCode;

/**
 * @author zzq
 * @create 2021-09-02-11:56
 */
public class L35searchInsert {
    public static void main(String[] args) {
//        int[] arr = new int[]{1, 3, 5, 6};
//        int[] arr2 = new int[]{1, 3};
        int[] arr2 = new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10};
//        System.out.println(searchInsert(arr, 5));
        System.out.println(searchInsert(arr2, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
}
