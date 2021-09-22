package leetCode;

import java.util.LinkedList;

/**
 * @author zzq
 * @create 2021-09-18-9:51
 */
public class L82deleteDuplicates {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
//        ListNode head2 = new ListNode(0, new ListNode(1));
        L82deleteDuplicates self = new L82deleteDuplicates();
        System.out.println(self.deleteDuplicates(head));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode respre = new ListNode(0, head);
        ListNode cur = respre;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int t = cur.next.val;
                while (cur.next != null && cur.next.val == t) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return respre.next;
    }
}
