package leetCode;

public class L1894chalkReplacer {
    public static void main(String[] args) {

    }

    public int chalkReplacer(int[] chalk, int k) {
        int start = 0;
        int length = chalk.length - 1;
        long count = 0;
        while (k >= 0) {
            k -= chalk[start];
            count += chalk[start];
            if (k < 0) {
                return start;
            }
            if (start == length) {
                k = (int) (k - count * (k / count));
                start = 0;
            } else {
                start++;
            }
        }
        return start;
    }
}
