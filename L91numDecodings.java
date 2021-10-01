package leetCode;

/**
 * @author zzq
 * @create 2021-09-30-9:24
 */
public class L91numDecodings {
    public static void main(String[] args) {
        L91numDecodings self = new L91numDecodings();
        System.out.println(self.numDecodings("12"));
        System.out.println(self.numDecodings("11106"));
    }


    public int numDecodings(String s) {
        int[] arr = new int[s.length() + 1];
        arr[0] = 1;
        s = "0" + s;
        for (int i = 1; i <= s.length()-1; i++) {
            int a = s.charAt(i) - '0';
            int b = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if (0 < a && a <= 9) {
                arr[i] = arr[i - 1];
            }
            if (10 <= b && b <= 26) {
                arr[i] = arr[i] + arr[i - 2];
            }

        }
        return arr[s.length()-1];
    }
    public int numDecodings2(String s) {
        int n = s.length();
        s = " " + s;
        char[] cs = s.toCharArray();
        int[] f = new int[3];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i % 3] = 0;
            int a = cs[i] - '0', b = (cs[i - 1] - '0') * 10 + (cs[i] - '0');
            if (1 <= a && a <= 9) f[i % 3] = f[(i - 1) % 3];
            if (10 <= b && b <= 26) f[i % 3] += f[(i - 2) % 3];
        }
        return f[n % 3];
    }
}
