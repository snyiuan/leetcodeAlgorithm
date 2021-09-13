package leetCode;

/**
 * @author zzq
 * @create 2021-09-13-11:03
 */
public class L198rob {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1};
    }

    public int rob(int[] nums) {
        int p = 0;
        int q = 0;
        int cur = 0 ;
        for (int i = 0; i < nums.length; i++) {
            cur = Math.max(q, p + nums[i]);
            p = q;
            q = cur;
        }
        return cur;
    }
}
