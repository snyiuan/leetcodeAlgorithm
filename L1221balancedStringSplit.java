package leetCode;

public class L1221balancedStringSplit {
    public int balancedStringSplit(String s) {
        int res = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                l++;
            } else {
                l--;
            }
            if (l == 0) {
                res++;
            }
        }

        return res;

    }
}
