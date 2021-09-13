package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zzq
 * @create 2021-09-13-11:16
 */
public class L120minimumTotal {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(2));
        lists.add(Arrays.asList(3, 4));
        lists.add(Arrays.asList(6, 5, 7));
        lists.add(Arrays.asList(4, 1, 8, 3));
        L120minimumTotal l120minimumTotal = new L120minimumTotal();
        int i = l120minimumTotal.minimumTotal(lists);
        System.out.println(i);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] res = new int[len][len];
        res[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < len; i++) {
            res[i][0] = res[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                int cur = triangle.get(i).get(j);
                    res[i][j] = Math.min(res[i - 1][j - 1] + cur, res[i - 1][j] + cur);
            }
            res[i][i]=res[i-1][i-1]+triangle.get(i).get(i);

        }
        int min = Integer.MAX_VALUE;
        int lastIndex = len - 1;
        for (int i = 0; i < res[lastIndex].length; i++) {
            min = Math.min(min, res[lastIndex][i]);
        }
        return min;
    }
}
