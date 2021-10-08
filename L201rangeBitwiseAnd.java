package leetCode;

/**
 * @author zzq
 * @create 2021-10-04-14:25
 */
public class L201rangeBitwiseAnd {
    /**
     * 0   1   0   1
     * 0   1   1   0
     * 0   1   1   1
     **/
    public static void main(String[] args) {
        L201rangeBitwiseAnd self = new L201rangeBitwiseAnd();
        System.out.println(self.rangeBitwiseAnd(5, 7));
        System.out.println(self.rangeBitwiseAnd(1, 2147483647));
        System.out.println(self.rangeBitwiseAnd(14, 22));
        System.out.println(self.rangeBitwiseAnd(75, 111));
        System.out.println(self.rangeBitwiseAnd(9, 12));
        System.out.println(5 & 6 & 7);
    }

    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        // 找到公共前缀
        while (left < right) {
            left >>= 1;
            right >>= 1;
            ++shift;
        }
        return left << shift;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        while (m < n) {
            n = n & (n - 1);
        }
        return n;
    }


}
