package leetCode;

public class L392isSubsequence {
    public static void main(String[] args) {

    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int sIndex = 0, tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }
        if (sIndex == s.length()) {
            return true;
        }
        return false;
    }
}
