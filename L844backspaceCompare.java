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
        // System.out.println(self.backspaceCompare(str, str2));
        // System.out.println(self.backspaceCompare(str4, str5));
        System.out.println("aaa");
    }

    public boolean backspaceCompare(String s, String t) {
        return false;
    }

    public static String helper(String s) {
        for (int i = 0; i < s.length(); i++) {
            
        }
        return "";

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
