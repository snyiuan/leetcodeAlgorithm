package leetCode;

/**
 * @author zzq
 * @create 2021-09-27-11:22
 */
public class L55canJump {
    public static void main(String[] args) {
        int[] num1 = new int[]{2, 3, 1, 1, 4};
        int[] num2 = new int[]{3, 2, 1, 0, 4};
        int[] num3 = new int[]{1, 2, 3};
        L55canJump self = new L55canJump();
        System.out.println(self.canJump(num1));
        System.out.println(self.canJump(num2));
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int far = nums[0];
        int count = 0;
        while (count <= far) {
            if (far >= nums.length - 1) {
                return true;
            }
            far = Math.max(far, nums[count] + count);
            count++;
        }
        return false;
    }
}
