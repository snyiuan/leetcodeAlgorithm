package leetCode;

/**
 * @author zzq
 * @create 2021-09-02-11:28
 */
public class L278firstBadVersion {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(7));
        //2126753390
        //1702766719
        System.out.println(Integer.MAX_VALUE);
        System.out.println(firstBadVersion(2126753390));

    }

    public static int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int m = (int) Math.floor(((long) l + (long) r) / 2);
            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static boolean isBadVersion(int n) {
        if (n >= 1702766719) {
            return true;
        }
        return false;
    }
}
