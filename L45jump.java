package leetCode;

import javax.swing.plaf.IconUIResource;

/**
 * @author zzq
 * @create 2021-09-28-11:17
 */
public class L45jump {
    public static void main(String[] args) {
        L45jump self = new L45jump();
        int[] num1 = {2, 3, 1, 1, 4};
        int[] num2 = new int[]{3, 2, 1, 0, 4};
        int[] num3 = new int[]{1, 2, 3};
        System.out.println(self.jump(num1));
        System.out.println(self.jump(num2));
        System.out.println(self.jump(num3));
    }

    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
d