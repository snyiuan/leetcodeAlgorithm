package leetCode;

import java.util.ArrayList;
import java.util.List;

public class L102levelOrder {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(levelOrder(treeNode));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, root, 0);
        return list;
    }

    public static void helper(List<List<Integer>> list, TreeNode root, int depth) {
        if (root == null)
            return;
        if (list.size() == depth)
            list.add(new ArrayList<>());
        list.get(depth).add(root.val);
        helper(list, root.left, depth + 1);
        helper(list, root.right, depth + 1);
    }
}
