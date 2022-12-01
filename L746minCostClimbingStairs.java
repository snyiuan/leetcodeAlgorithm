package leetCode;

public class L746minCostClimbingStairs {
    public static void main(String[] args) {

    }

    public int minCostClimbingStairs(int[] cost) {
        int pp = cost[0], p = cost[1];
        int cur = 0;
        for (int i = 2; i < cost.length; i++) {
            cur = cost[i] + Math.min(p, pp);
            pp = p;
            p = cur;
        }
        return Math.min(p, pp);
    }

    public int minCostClimbingStairs2(int[] cost) {

        return Math.min(helper(cost, cost[0], 0), helper(cost, cost[1], 1));
    }

    public static int helper(int[] cost, int sum, int index) {
        if (index >= cost.length - 2) {
            return 0;
        }
        return Math.min(helper(cost, sum + cost[index + 1], index + 1), helper(cost, sum + cost[index + 2], index + 2));
    }
}
