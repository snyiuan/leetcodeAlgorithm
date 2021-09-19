package leetCode;

/**
 * @author zzq
 * @create 2021-09-19-19:53
 */
public class L11maxArea {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int area = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                area = Math.max(area, height[l] * (r - l));
                l++;
            } else {
                area = Math.max(area, height[r] * (r - l));
                r--;
            }
        }
        return area;
    }
}
