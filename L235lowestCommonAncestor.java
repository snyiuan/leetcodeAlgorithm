package leetCode;

public class L235lowestCommonAncestor {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }
        TreeNode loop = root;
        // p<q
        //
        while (loop != null) {
            if (loop.val <= q.val && loop.val >= p.val) {
                return loop;
            } else if (loop.val > q.val && loop.val > p.val) {
                loop = loop.left;
            } else if (loop.val < q.val && loop.val < p.val) {
                loop = loop.right;
            }
        }
        return loop;
    }
}
