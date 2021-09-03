package leetCode;


import java.util.Stack;

/**
 * @author zzq
 * @create 2021-08-31-17:36
 */
public class L206reverseList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(listNode);
        System.out.println(reverseList(listNode));
    }

    public static ListNode res;

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode reverseList3(ListNode head) {
        if (head == null) {
            return null;
        }
        res = new ListNode(0);
        ListNode start = res;
        deepf(head, res);
        return start.next;
    }

    public static void deepf(ListNode head, ListNode pre) {
        if (head != null) {
            pre = head;
            deepf(head.next, pre);
            res.next = new ListNode(pre.val);
            res = res.next;
        }
        return;
    }


    public static ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<Integer> stack = new Stack();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        System.out.println(stack);
        int start = stack.pop();

        cur = new ListNode(start);
        ListNode res = cur;
        while (!stack.isEmpty()) {
            cur.next = new ListNode(stack.pop());
            cur = cur.next;
        }
        return res;
    }
}
