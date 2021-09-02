package leetCode;

import java.util.*;

/**
 * @author zzq
 * @create 2021-09-01-21:00
 */
public class L15threeSum {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(arr);
        System.out.println(lists);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 3) {
            return null;
        }
        List<List<Integer>> result = new ArrayList();
        Map ex = new HashMap();
        for (int i = 0; i < nums.length - 3; i++) {
            int target = nums[i];
            twoSum(Arrays.copyOfRange(nums, i + 1, nums.length), target, result, ex);
        }
        return result;
    }

    public static void twoSum(int[] nums, int target, List res, Map ex) {

        Map<Integer, Integer> map = new HashMap();
        List<Integer> list;
        for (int i = 0; i < nums.length; i++) {
            list = new ArrayList();
            list.add(target);
            if (map.containsKey(nums[i])) {
                if (!ex.containsKey(nums[i]) && !ex.containsValue(nums[i])) {
                    int value = map.get(nums[i]);
                    list.add(value);
                    list.add(nums[i]);
                    ex.put(nums[i], value);
                    res.add(list);
                }
            } else {
                map.put(-target - nums[i], nums[i]);
            }
        }
    }


}
