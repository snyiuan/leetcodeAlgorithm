package leetCode;

/**
 * @author zzq
 * @create 2021-08-28-23:52
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "" + val + "" + (next == null ? "" : "->" + next);
    }
}
