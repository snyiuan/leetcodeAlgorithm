package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zzq
 * @create 2021-09-25-11:40
 */
public class L47permuteUnique {
    public static void main(String[] args) {
        L47permuteUnique self = new L47permuteUnique();
        int[] arr = {1, 2, 3};
        int[] arr2 = {1, 2, 1};
        System.out.println(self.permuteUnique(arr));
        System.out.println(self.permuteUnique(arr2));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        boolean[] seen = new boolean[len];
        helper(res, list, nums, seen, len, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] seen, int len, int index) {
        if (index == len) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (seen[i] || (i > 0 && nums[i - 1] == nums[i] && !seen[i - 1])) {
                continue;
            }
            seen[i] = true;
            list.add(nums[i]);
            helper(res, list, nums, seen, len, index + 1);
            seen[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
