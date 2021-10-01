package leetCode;

/**
 * @author zzq
 * @create 2021-09-29-10:00
 */
public class L5longestPalindrome {
    public static void main(String[] args) {
        L5longestPalindrome self = new L5longestPalindrome();
        String s1 = "babad";
        String s2 = "cbbd";
        String s3 = "ccc";
        String s4 = "cccc";
//        System.out.println((int) 3-1 / 2);
//        System.out.println(self.longestPalindrome(s1));
//        System.out.println(self.longestPalindrome(s2));
//        System.out.println(self.longestPalindrome(s3));
        System.out.println(self.longestPalindrome(s4));
    }


    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int l1 = expandAroundCenter(s, i, i);
            int l2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(l1, l2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public String longestPalindrome3(String s) {
        String res = s.substring(0, 1);

        for (int i = 1; i < s.length(); i++) {
            String s1 = expandAroundCenter2(s, i - 1, i, 0);
            String s2 = expandAroundCenter2(s, i - 1, i + 1, 1);
            if (s1.length() < s2.length()) {
                if (s2.length() > res.length()) {
                    res = s2;
                }
            } else {
                if (s1.length() > res.length()) {
                    res = s1;
                }
            }
        }
        return res;
    }

    public String longestPalindrome2(String s) {
        String res = s.substring(0, 1);
        for (int i = 1; i < s.length(); i++) {
            int j = 1;
            int l;
            int m = 0;
            int r;
            if (s.charAt(i) == s.charAt(i - 1)) {
                l = i - j;
                r = i;
                while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    if ((2 * j + m) > res.length()) {
                        res = s.substring(l, r + 1);
                    }
                    l -= 1;
                    r += 1;
                    j++;
                }

            }
            j = 1;
            l = i - j;
            r = i + j;
            m = 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if ((2 * j + m) > res.length()) {
                    res = s.substring(l, r + 1);
                }
                j++;
                l -= 1;
                r += 1;
            }

        }
        return res;
    }


    private String expandAroundCenter2(String s, int l, int r, int m) {
        String res = "";
        int j = 1;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if ((2 * j + m) > res.length()) {
                res = s.substring(l, r + 1);
            }
            j++;
            l -= 1;
            r += 1;
        }
        return res;
    }


}
