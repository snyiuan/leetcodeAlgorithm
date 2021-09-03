package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zzq
 * @create 2021-08-26-17:31
 */
public class L101isSymmetric {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        TreeNode treeNode2 = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
        System.out.println(isSymmetric(treeNode1));
        System.out.println(isSymmetric(treeNode2));

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return subIsSymmetric(root.left, root.right);
    }

    public static boolean subIsSymmetric(TreeNode t1, TreeNode t2) {
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(t1);
        queue.offer(t2);
        while (!queue.isEmpty()) {
            t1 = queue.poll();
            t2 = queue.poll();
            if (t1 == null && t2 == null) {
                return true;
            }
            if (t1 == null || t2 == null || t1.val != t2.val) {
                return false;
            }
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
    }


    public static boolean subIsSymmetric1(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return subIsSymmetric1(left.left, right.right) && subIsSymmetric1(left.right, right.left);
    }
}
