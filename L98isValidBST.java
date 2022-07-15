package leetCode;

import java.lang.annotation.Retention;

public class L98isValidBST {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        int low = Integer.MIN_VALUE;
        int upper = Integer.MAX_VALUE;
        return helper(root, low, upper);
    }

    private static boolean helper(TreeNode root, int low, int upper) {
        if (root == null) {
            return true;
        }
        return helper(root.left, low, root.val) && helper(root.right, root.val, upper);
    }
}
