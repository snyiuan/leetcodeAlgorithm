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
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = n - 1;
            int target = -nums[first];
            for (int second = first + 1; second < n; ++second) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[second]);
                    list.add(nums[third]);
                    list.add(nums[first]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    

}
