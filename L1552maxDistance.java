package leetCode;

import java.io.PipedOutputStream;
import java.util.Arrays;

public class L1552maxDistance {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,7};
        System.out.println(maxDistance(arr, 3));
    }

    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 1;
        int r = 1000000000;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(position, mid, m)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l-1;
    }

    public static boolean check(int[] position, int space, int m) {
        int pre = position[0];
        int cnt = 1;
        for (int i = 1; i < position.length; i++) {
            if (position[i] - pre >= space) {
                pre = position[i];
                cnt += 1;
            }
        }
        return cnt >= m;
    }
}