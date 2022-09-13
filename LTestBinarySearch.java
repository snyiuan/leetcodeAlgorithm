package leetCode;

public class LTestBinarySearch {
    public static void main(String[] args) {
        //3 l: 5, r:9
        int[] arr = new int[] { 1, 1, 1, 1, 2, 3, 3, 3, 3, 3, 4, 5, 6, 7, 8, 8, 8, 8, 8 };
        System.out.println(binarySearch(arr, 3));
        System.out.println(binarySearch(arr, 1));
        System.out.println(binarySearch(arr, 8));

    }

    public static int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

}
