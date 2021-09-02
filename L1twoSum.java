package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class L1twoSum {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 7, 11, 15};
        int[] arr2 = new int[]{3, 2, 4};
        int[] arr3 = new int[]{3, 3};
        System.out.println(Arrays.toString(twoSum(arr1, 9)));
        System.out.println(Arrays.toString(twoSum(arr2, 6)));
        System.out.println(Arrays.toString(twoSum(arr3, 6)));

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == res) {
                    return new int[]{i, j};
                    
                }
            }
        }
        return null;
    }

    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                } else if (nums[j] == res) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}