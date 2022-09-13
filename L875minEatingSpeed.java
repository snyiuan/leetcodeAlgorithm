package leetCode;

public class L875minEatingSpeed {
    public static void main(String[] args) {
        int[] arr = new int[] { 805306368, 805306368, 805306368 };
        int speed = 1000000000;
        /*
         * System.out.println((long) Math.pow(10, 9));
         * System.out.println(Integer.MAX_VALUE > Math.pow(10, 9));
         * System.out.println(Integer.MAX_VALUE);
         */
        System.out.println(minEatingSpeed(arr, speed));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 1000000000;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(piles, mid) <= h) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r + 1;

    }

    public static long check(int[] piles, int speed) {
        long count = 0;
        for (int i = 0; i < piles.length; i++) {
            count += (piles[i] + speed - 1) / speed;
        }
        return count;
    }

}
