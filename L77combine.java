package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * @author zzq
 * @create 2021-09-12-9:24
 */
public class L77combine {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));

    }

    public static List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(res, list, n, k, 1);
        return res;
    }

    public static void helper(ArrayList<List<Integer>> res, List<Integer> list, int n, int k, int start) {
        if (list.size() + n - start + 1 < k) {
            return;
        }
        if (list.size()==k) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(start);
        helper(res, list, n, k , start + 1);
        list.remove(list.size() - 1);
        helper(res, list, n, k, start + 1);


    }

    public static void helper1(ArrayList<List<Integer>> res, List<Integer> list, int n, int k, int start) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            list.add(i);
            helper(res, list, n, k - 1, i + 1);
            list.remove(list.size() - 1);
        }
    }


}
