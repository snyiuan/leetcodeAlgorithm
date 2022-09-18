package leetCode;

public class L1898maximumRemovals {
    public static void main(String[] args) {
        System.out.println(maximumRemovals("abcbddddd", "abcd", new int[] { 3, 2, 1, 4, 5, 6 }));
    }

    public static int maximumRemovals(String s, String p, int[] removable) {
        int l = 0;
        int r = removable.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(s, p, removable, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l - 1;
    }

    public static boolean check(String s, String p, int[] removable, int index) {
        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();

        for (int i = 0; i < index; i++) {
            sCharArray[removable[i]] = 1;
        }
        int cnt = 0;
        for (int i = 0; i < sCharArray.length; i++) {
            if (cnt < pCharArray.length) {
                if (sCharArray[i] == pCharArray[cnt]) {
                    cnt++;
                }
            }
        }

        /*
         * for (int i = 0; i < pCharArray.length; i++) {
         * while (start < sCharArray.length) {
         * if (sCharArray[start] == pCharArray[i]) {
         * cnt++;
         * start++;
         * break;
         * }
         * start++;
         * }
         * }
         */
        if (cnt == p.length()) {
            return true;
        }
        return false;
    }

}
