package leetCode;

import java.util.ArrayList;
import java.util.List;

public class L46permute {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3 };
        System.out.println(permute(arr));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        int len = nums.length;
        boolean[] use = new boolean[len];
        helper(res, list, use, nums, len, 0);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> list, boolean[] use, int[] nums, int len,
            int start) {
        if (start > len) {
            return;
        }
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (use[start]) {
            helper(res, list, use, nums, len, start + 1);
        } else {
            list.add(nums[start]);
            use[start] = true;
            helper(res, list, use, nums, len, start + 1);
            list.remove(list.size() - 1);
            use[start] = false;
        }
    }

}