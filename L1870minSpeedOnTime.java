package leetCode;

import java.util.Arrays;

public class L1870minSpeedOnTime {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 2 };
        int[] arr2 = new int[] { 1, 1, 100000 };
        System.out.println(minSpeedOnTime(arr, 6));
        System.out.println(minSpeedOnTime(arr2, 2.01));

    }

    public static int minSpeedOnTime(int[] dist, double hour) {
        int l = 1;
        //hour精确到小数点后两位,所以speed最大值为dist数组中最大值的100倍
        int r = Arrays.stream(dist).max().getAsInt()*100;
        // int r = 10000000;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(dist, mid) <= hour) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static double check(int[] dist, int speed) {
        int cnt = 0;
        int length = dist.length;
        for (int i = 0; i < length - 1; i++) {
            cnt += (dist[i] + speed - 1) / speed;
        }
        double res = cnt + dist[length - 1] * 1.0 / speed;
        return res;
    }

}
