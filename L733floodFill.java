package leetCode;

import java.util.Arrays;

/**
 * @author zzq
 * @create 2021-09-08-9:14
 */
public class L733floodFill {
    public static void main(String[] args) {
        // int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        // int[][] image = new int[][] { { 0, 0, 0 }, { 0, 1, 1 } };
        // for (int[] ints : image) {
        // System.out.println(Arrays.toString(ints));
        // }
        // System.out.println("====================");
        // image = floodFill(image, 1, 1, 1);
        // for (int[] ints : image) {
        // System.out.println(Arrays.toString(ints));
        // }

    }

    public static int[][] floodFill4(int[][] image, int sr, int sc, int newColor) {
        for (int i = 0; i < image.length; i++) {
            
        }
        int[][] seen = new int[image.length][image[0].length];
        int origin = image[sr][sc];
        helper(image, seen, sr, sc, newColor, origin);
        return image;
    }

    public static void helper(int[][] image, int[][] seen, int sr, int sc, int newColor, int origin) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || seen[sr][sc] == 1) {
            if (image[sr][sc] == origin) {
                image[sr][sc] = newColor;
            }
            seen[sr][sc] = 1;
            return;
        }
        helper(image, seen, sr + 1, sc, newColor, origin);
        helper(image, seen, sr - 1, sc, newColor, origin);
        helper(image, seen, sr, sc + 1, newColor, origin);
        helper(image, seen, sr, sc - 1, newColor, origin);
    }

    public static int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int origin = image[sr][sc];
        if (origin != newColor) {
            subFloodFill2(image, sr, sc, newColor, origin);
        }
        return image;
    }

    public static void subFloodFill2(int[][] image, int sr, int sc, int newColor, int origin) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) {
            return;
        }
        if (image[sr][sc] == origin) {
            image[sr][sc] = newColor;
            subFloodFill2(image, sr - 1, sc, newColor, origin);
            subFloodFill2(image, sr, sc - 1, newColor, origin);
            subFloodFill2(image, sr + 1, sc, newColor, origin);
            subFloodFill2(image, sr, sc + 1, newColor, origin);
        }
    }

    public static int[][] floodFill3(int[][] image, int sr, int sc, int newColor) {
        int[][] seen = new int[image.length][image[0].length];
        int origin = image[sr][sc];
        if (origin != newColor) {
            subFloodFill3(image, seen, sr, sc, origin, newColor);
        }
        return image;
    }

    public static void subFloodFill3(int[][] image, int[][] seen, int sr, int sc, int origin, int newColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) {
            return;
        }
        if (image[sr][sc] == origin && seen[sr][sc] != 0) {
            seen[sr][sc] = 1;
            image[sr][sc] = newColor;
            subFloodFill3(image, seen, sr - 1, sc, origin, newColor);
            subFloodFill3(image, seen, sr + 1, sc, origin, newColor);
            subFloodFill3(image, seen, sr, sc - 1, origin, newColor);
            subFloodFill3(image, seen, sr, sc + 1, origin, newColor);
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int origin = image[sr][sc];
        int[][] change = new int[image.length][image[0].length];
        if (origin != newColor) {
            subFloodFill(image, sr, sc, newColor, origin, change);
        }
        return image;
    }

    public static void subFloodFill(int[][] image, int sr, int sc, int newColor, int origin, int[][] change) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) {
            return;
        }
        if (change[sr][sc] == 0 && image[sr][sc] == origin) {
            change[sr][sc] = 1;
            image[sr][sc] = newColor;
            subFloodFill(image, sr - 1, sc, newColor, origin, change);
            subFloodFill(image, sr, sc - 1, newColor, origin, change);
            subFloodFill(image, sr + 1, sc, newColor, origin, change);
            subFloodFill(image, sr, sc + 1, newColor, origin, change);
        }
    }

}
