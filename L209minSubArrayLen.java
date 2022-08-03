package leetCode;

public class L209minSubArrayLen {
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 1, 2, 4, 3 };
        System.out.println(minSubArrayLen(7, arr));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int count = 0;
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            end = i + 1;
            while (count >= target) {
                min = Math.min(min, end - start);
                count = count - nums[start];
                start++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
