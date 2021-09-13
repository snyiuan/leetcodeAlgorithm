package leetCode;

/**
 * @author zzq
 * @create 2021-09-13-9:58
 */
public class L70climbStairs {
    public static void main(String[] args) {
        L70climbStairs l70climbStairs = new L70climbStairs();

        for (int j = 0; j < 10; j++) {
            int i = l70climbStairs.climbStairs(j);
            System.out.println(j + "--: " + i);
        }

    }

    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        int pre = 1;
        int cur = 1;
        int tmp = 0;
        for (int i = 2; i <= n; i++) {
            tmp = cur + pre;
            pre = cur;
            cur = tmp;
        }
        return cur;
    }

}
