package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zzq
 * @create 2021-08-30-11:43
 */
public class L141hasCycle {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))));
        listNode.next.next.next.next = listNode.next;
        System.out.println(hasCycle(listNode));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        ListNode cur = head;
        set.add(cur.hashCode());
        while (cur.next != null) {
            cur = cur.next;
            if (set.contains(cur.hashCode())) {
                return true;
            }
            set.add(cur.hashCode());
        }
        return false;
    }

    public static boolean hasCycle3(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode pre = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            if (pre == fast) {
                return false;
            }
            pre = pre.next;
        }
        return true;
    }

    public static boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode cur = head;
        ArrayList<Integer> list = new ArrayList();
        list.add(cur.hashCode());
        while (cur.next != null) {
            cur = cur.next;
            if (list.contains(cur.hashCode())) {
                return true;
            } else {
                list.add(cur.hashCode());
            }
        }
        return false;
    }
}
