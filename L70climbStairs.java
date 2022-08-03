package leetCode;

/**
 * @author zzq
 * @create 2021-09-13-9:58
 */
public class L70climbStairs {
    public static void main(String[] args) {
        L70climbStairs l70climbStairs = new L70climbStairs();

        for (int j = 0; j < 45; j++) {
            int i = l70climbStairs.climbStairs(j);
            System.out.println(j + "--: " + i);
        }

    }

    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q; 
            q = r; 
            r = p + q;
        }
        return r;
    }

}
