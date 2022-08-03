package leetCode;

public class L746minCostClimbingStairs {
    public static void main(String[] args) {

    }

    public int minCostClimbingStairs(int[] cost) {

        return Math.min(helper(cost, cost[0], 0), helper(cost, cost[1], 1));
    }

    public static int helper(int[] cost, int sum, int index) {
        if (index >= cost.length - 2) {
            return 0;
        }
        return Math.min(helper(cost, sum + cost[index + 1], index + 1), helper(cost, sum + cost[index + 2], index + 2));
    }
}
