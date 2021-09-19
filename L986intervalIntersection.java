package leetCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zzq
 * @create 2021-09-19-17:58
 */
public class L986intervalIntersection {
    public static void main(String[] args) {
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        L986intervalIntersection self = new L986intervalIntersection();
        int[][] ints = self.intervalIntersection(firstList, secondList);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }

    }/*
    List<int[]> ans = new ArrayList();
    int i = 0, j = 0;
    while (i < A.length && j < B.length) {
      // Let's check if A[i] intersects B[j].
      // lo - the startpoint of the intersection
      // hi - the endpoint of the intersection
      int lo = Math.max(A[i][0], B[j][0]);
      int hi = Math.min(A[i][1], B[j][1]);
      if (lo <= hi)
        ans.add(new int[]{lo, hi});
      // Remove the interval with the smallest endpoint
      if (A[i][1] < B[j][1])
        i++;
      else
        j++;
    }
    return ans.toArray(new int[ans.size()][]);
    **/


    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int fl = firstList.length;
        int sl = secondList.length;
        int l = 0;
        int r = 0;
        ArrayList<int[]> list = new ArrayList<>();
        while (l < fl && r < sl) {
            int low = Math.max(firstList[l][0], secondList[r][0]);
            int high = Math.min(firstList[l][1], secondList[r][1]);
            if (low <= high) list.add(new int[]{low, high});
            if (firstList[l][1] < secondList[r][1]) l++;
            else r++;

        }
        return list.toArray(new int[list.size()][]);

    }

    public int[][] intervalIntersection1(int[][] firstList, int[][] secondList) {
        int fl = firstList.length;
        int sl = secondList.length;
        int l = 0;
        int r = 0;
        ArrayList<int[]> list = new ArrayList<>();
        while (l < fl && r < sl) {
            // []
            //      []
            if (firstList[l][1] < secondList[r][0]) {
                l++;
                //      []
                //  []
            } else if (firstList[l][0] > secondList[r][1]) {
                r++;
                //      [       ]]]]]]]]]]]]]
                //[      [      ]
            } else if (firstList[l][1] >= secondList[r][1]) {
                if (secondList[r][0] <= firstList[l][0]) {
                    list.add(new int[]{firstList[l][0], secondList[r][1]});
                } else if (secondList[r][0] > firstList[l][0]) {
                    list.add(new int[]{secondList[r][0], secondList[r][1]});
                }
                r++;
                //      [       ]
                // [        [   ]]]]]]]]]]]]]
            } else if (firstList[l][1] < secondList[r][1]) {
                if (firstList[l][0] > secondList[r][0]) {
                    list.add(new int[]{firstList[l][0], firstList[l][1]});
                } else {
                    list.add(new int[]{secondList[r][0], firstList[l][1]});
                }
                l++;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
