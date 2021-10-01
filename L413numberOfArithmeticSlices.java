package leetCode;

/**
 * @author zzq
 * @create 2021-09-29-11:39
 */
public class L413numberOfArithmeticSlices {
    public static void main(String[] args) {
        L413numberOfArithmeticSlices self = new L413numberOfArithmeticSlices();
        int[] arr1 = {7, 7, 7, 7, 7};
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] arr3 = {1, 2, 3, 4, 5, 19, 20, 30, 40};
        System.out.println(self.numberOfArithmeticSlices(arr1));
        System.out.println(self.numberOfArithmeticSlices(arr2));
        System.out.println(self.numberOfArithmeticSlices(arr3));

    }

    //  1   2   3   4   5
    //
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int d = nums[0] - nums[1], t = 0;
        int ans = 0;
        // 因为等差数列的长度至少为 3，所以可以从 i=2 开始枚举
        for (int i = 2; i < n; ++i) {
            if (nums[i - 1] - nums[i] == d) {
                ++t;
            } else {
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }
}




