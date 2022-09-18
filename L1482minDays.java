package leetCode;

public class L1482minDays {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 10, 3, 10, 2 };
        System.out.println(minDays(arr, 3, 2));
        System.out.println("aaa");

    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int l = 1;
        int r = 1000000000;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(bloomDay, mid, m, k) >= m) {
                r = mid - 1;
                ans = r;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static int check(int[] bloomDay, int day, int m, int k) {
        int cnt = 0;
        int flowCnt = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                cnt++;
                if (cnt == k) {
                    flowCnt++;
                    cnt = 0;
                }
            } else {
                cnt = 0;
            }
        }
        return flowCnt;
    }
}
