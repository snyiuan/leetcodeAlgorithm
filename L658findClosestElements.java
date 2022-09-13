package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.lang.model.element.Element;

public class L658findClosestElements {
    public static void main(String[] args) {
        // int[] arr = new int[] { 1, 1, 1, 1, 2, 3, 4, 5, 5, 5, 5 };
        int[] arr2 = new int[] { 1, 2, 5, 5, 5, 5, 5, 7, 8 };
        int[] arr3 = new int[] { 1, 1, 1, 10, 10, 10 };
        // System.out.println(binarySearch(arr2, 5));
        System.out.println(binarySearch(arr3, 9));
        System.out.println(findClosestElements(arr3,2,9));

    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int right = binarySearch(arr, x);
        int left = right - 1;
        while (k-- > 0) {
            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
            } else if (x - arr[left] <= arr[right] - x) {
                left--;
            } else {
                right++;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = left +1; i < right; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    public static int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        Arrays.binarySearch(arr, x);
        List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(ret, (a, b) -> a == b ? a - b : Math.abs(a - x) - Math.abs(b - x));
        ret = ret.subList(0, k);
        Collections.sort(ret);
        return ret;
    }

}
