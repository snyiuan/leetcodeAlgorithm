package leetCode;

public class L14longestCommonPrefix {
    public static void main(String[] args) {
        System.out.println("aaa".substring(0, 0));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int min = Integer.MAX_VALUE;
        int index = 0;
        String profix = "";
        String ans = "";
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < min) {
                min = strs[i].length();
                index = i;
                profix = strs[i];
            }
        }

        A: for (int i = profix.length() - 1 ; i > 0; i++) {
            String pre = profix.substring(0, i);
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(pre)) {
                    break;
                }
            }
            ans = pre;
        }
        return ans;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int min = Integer.MAX_VALUE;
        int index = 0;
        String profix = "";
        String ans = "";
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < min) {
                min = strs[i].length();
                index = i;
                profix = strs[i];
            }
        }

        A: for (int i = 1; i <= profix.length(); i++) {
            String pre = profix.substring(0, i);
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(pre)) {
                    break A;
                }
            }
            ans = pre;
        }
        return ans;
    }
}
