package leetCode;

public class L1480runningSum {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            arr[i] = sum;
        }
        return arr;
    }
}
