package leetCode;

/**
 * @author zzq
 * @create 2021-08-27-20:29
 */
public class L121maxProfit {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        int[] arr2 = new int[]{4, 5, 2, 5, 4, 8, 1};
        System.out.println(maxProfit(arr));
        System.out.println(maxProfit(arr2));

    }

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > maxProfit) {
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;
    }

}

