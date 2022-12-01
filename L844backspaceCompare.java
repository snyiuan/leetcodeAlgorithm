package leetCode;

/**
 * @author zzq
 * @create 2021-09-19-11:11
 */
public class L844backspaceCompare {
    public static void main(String[] args) {
        String str = "ab#c";
        String str2 = "ab#c";
        String str3 = "ab##";
        String str4 = "xywrrmp";
        String str5 = "xywrrmu#p";

        String str6 = "gtc#uz#";
        String str7 = "gtcm##uz#";

        String str8 = "xywrrmp";
        String str9 = "xywrrmu#p";
        String str10 = "bxj##tw";
        String str11 = "bxo#j##tw";

        System.out.println(helper(str11));
        System.out.println(helper("ab#c"));
        
        // System.out.println(backspaceCompare(str10, str11));
        // System.out.println(self.backspaceCompare(str, str2));
        // System.out.println(self.backspaceCompare(str4, str5));
    }

    public static boolean backspaceCompare(String s, String t) {
        return helper(s).equals(helper(t));
    }

    public static String helper(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int len = s.length() - 1;
        while (len >= 0) {
            if (s.charAt(len) == '#') {
                count++;
                len--;
            } else if (count > 0) {
                len--;
                count--;
            } else {
                sb.append(s.charAt(len));
                len--;
            }
        }
        return sb.reverse().toString();
    }

    public boolean backspaceCompare4(String s, String t) {
        int sl = s.length() - 1;
        int tl = t.length() - 1;
        int scount = 0;
        int tcount = 0;
        while (sl >= 0 || tl >= 0) {
            while (sl >= 0) {
                if (s.charAt(sl) == '#') {
                    scount++;
                } else if (scount > 0) {
                    scount--;
                } else {
                    break;
                }
                sl--;
            }
            while (tl >= 0) {
                if (t.charAt(tl) == '#') {
                    tcount++;
                } else if (tcount > 0) {
                    tcount--;
                } else {
                    break;
                }
                tl--;
            }
            if (sl >= 0 && tl >= 0) {
                if (s.charAt(sl) != t.charAt(tl))
                    return false;
            } else if (sl >= 0 || tl >= 0) {
                return false;
            }
            sl--;
            tl--;
        }
        return true;
    }

    public boolean backspaceCompare1(String s, String t) {
        int sl = s.length() - 1;
        int tl = t.length() - 1;
        int slcount = 0;
        int tlcount = 0;
        StringBuilder sb1 = new StringBuilder();
        for (int i = sl; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '#') {
                slcount++;
            } else if (slcount > 0) {
                slcount--;
            } else {
                sb1.append(ch);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i = tl; i >= 0; i--) {
            char ch = t.charAt(i);
            if (ch == '#') {
                tlcount++;
            } else if (tlcount > 0) {
                tlcount--;
            } else {
                sb2.append(ch);
            }
        }
        System.out.println(sb2.toString());
        return sb1.toString().equals(sb2.toString());
    }
}
