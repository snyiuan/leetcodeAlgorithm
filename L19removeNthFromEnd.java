package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zzq
 * @create 2021-08-25-16:22
 */
public class L19removeNthFromEnd {
    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1, new ListNode(2));
/*        System.out.println(listNode1);
        System.out.println(listNode2);
        System.out.println(listNode3);*/
        System.out.println(removeNthFromEnd(listNode1, 2));
        System.out.println(removeNthFromEnd(listNode2, 1));
        System.out.println(removeNthFromEnd(listNode3, 1));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = dummy;
        dummy.next = head;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        int count = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode tmp = head;
        while (tmp != null) {
            map.put(count, tmp);
            count++;
            tmp = tmp.next;
        }
        int tar = count - n;
        if (tar == 0) {
            if (count == 1) {
                return null;
            } else {
                return map.get(1);
            }
        } else {
            if (tar == count - 1) {
                map.get(tar - 1).next = null;
                return head;
            } else {
                map.get(tar - 1).next = map.get(tar + 1);
                return head;
            }
        }
    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode tmp = head;
        int length = 0;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        ListNode pre = head;
        tmp = head;
        int tar = length - n;
        int count = 0;
        while (tmp != null) {
            if (count == tar) {
                if (tmp.next == null) {
                    pre.next = null;
                } else {
                    pre.next = tmp.next;
                }
            }
            pre = tmp;
            tmp = tmp.next;
            count++;
        }
        return head;
    }
}
