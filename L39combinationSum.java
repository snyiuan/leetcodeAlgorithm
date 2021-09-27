package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzq
 * @create 2021-09-25-12:42
 */
public class L39combinationSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int[] arr2 = {2, 3, 5};
        L39combinationSum self = new L39combinationSum();
        System.out.println(self.combinationSum(arr, 7));
        System.out.println(self.combinationSum(arr2, 8));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(res, list, candidates, target, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int index) {
        if (index == candidates.length) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        helper(res, list, candidates, target, index + 1);
        if (target - candidates[index] >= 0) {
            list.add(candidates[index]);
            helper(res, list, candidates, target - candidates[index], index);
            list.remove(list.size() - 1);
        }
    }
}
