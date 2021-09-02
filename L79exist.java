package leetCode;

import java.util.ArrayList;

/**
 * @author zzq
 * @create 2021-08-30-17:19
 */
public class L79exist {
    public static void main(String[] args) {
//         word = "ABCCED"

        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABCCED"));

    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int[][] target = new int[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    target[i][j] = 1;
                    if (isExit(board, target, word, i - 1, j, m, n, 1) ||
                            isExit(board, target, word, i + 1, j, m, n, 1) ||
                            isExit(board, target, word, i, j - 1, m, n, 1) ||
                            isExit(board, target, word, i, j + 1, m, n, 1)) {
                        return true;
                    }
                    target[i][j] = 0;
                }
            }
        }
        return false;
    }

    public static boolean isExit(char[][] board, int[][] target, String word, int i, int j, int m, int n, int index) {
        if (index >= word.length()) {
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n || target[i][j] == 1) {
            return false;
        }
        if (board[i][j] == word.charAt(index)) {
            target[i][j] = 1;
            index++;
            if (isExit(board, target, word, i - 1, j, m, n, index) ||
                    isExit(board, target, word, i + 1, j, m, n, index) ||
                    isExit(board, target, word, i, j - 1, m, n, index) ||
                    isExit(board, target, word, i, j + 1, m, n, index)) {
                return true;
            } else {
                target[i][j] = 0;
                return false;
            }
        }
        return false;
    }

    private static boolean findExit(char[][] board, int[][] target, String word, int i, int j, int m, int n, int index) {
        if (index == word.length() - 1) {
            return true;
        }
        if (i - 1 > 0 && i - 1 < m) {
            if (target[i - 1][j] != 1 && board[i - 1][j] == word.charAt(index)) {
                target[i - 1][j] = 1;
                if (!findExit(board, target, word, i - 1, j, m, n, index++)) {
                    target[i - 1][j] = 0;
                } else {
                    return true;
                }
            }
        }
        if (i + 1 > 0 && i + 1 < m) {
            if (target[i + 1][j] != 1 && board[i + 1][j] == word.charAt(index)) {
                target[i + 1][j] = 1;
                if (!findExit(board, target, word, i + 1, j, m, n, index++)) {
                    target[i + 1][j] = 0;
                } else {
                    return true;
                }
            }
        }
        if (j - 1 > 0 && j - 1 < n) {
            if (target[i][j - 1] != 1 && board[i][j - 1] == word.charAt(index)) {
                target[i][j - 1] = 1;
                if (!findExit(board, target, word, i, j - 1, m, n, index++)) {
                    target[i][j - 1] = 0;
                } else {
                    return true;
                }
            }
        }
        if (j + 1 > 0 && j + 1 < n) {
            if (target[i][j + 1] != 1 && board[i][j + 1] == word.charAt(index)) {
                target[i][j + 1] = 1;
                if (!findExit(board, target, word, i, j + 1, m, n, index++)) {
                    target[i][j + 1] = 0;
                } else {
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean subExit(char[][] board, int[][] target, String word, int i, int j, int index) {
        int m = board.length;
        int n = board[0].length;
        while (i > 0 && i < m && j > 0 && j < n) {

            if (i - 1 < 0) {
                if (target[i][j] != 1 && word.charAt(index) == target[i][j]) {

                }
            } else if (i + 1 > m) {
                if (target[i][j] != 1 && word.charAt(index) == target[i][j]) {

                }
            } else if (j - 1 < 0) {
                if (target[i][j] != 1 && word.charAt(index) == target[i][j]) {

                }
            } else if (j + 1 > n) {
                if (target[i][j] != 1 && word.charAt(index) == target[i][j]) {

                }
            }
        }
        return false;
    }
}
