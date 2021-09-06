package leetCode;


/**
 * @author zzq
 * @create 2021-09-06-9:13
 */
public class L876middleNode {
    public static void main(String[] args) {

    }

    public static ListNode middleNode(ListNode head) {
        ListNode[] nodes = new ListNode[100];
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            nodes[n++] = cur;
            cur = cur.next;
        }
        return nodes[n / 2];

    }

    public static ListNode middleNode2(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        int k = 1;
        cur = head;
        while (k < n / 2) {
            cur = cur.next;
            k++;
        }
        return cur;
    }

    public static ListNode middleNode1(ListNode head) {
        ListNode mid = head;
        ListNode next = head;
        while (next.next != null) {
            if (next.next.next != null) {
                next = next.next.next;
            } else {
                next = next.next;
            }
            mid = mid.next;
        }
        return mid;
    }
}
