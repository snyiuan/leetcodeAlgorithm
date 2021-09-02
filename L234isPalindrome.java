package leetCode;

import demo.ListNode;

import java.util.Stack;

/**
 * @author zzq
 * @create 2021-08-28-23:51
 */
public class L234isPalindrome {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(isPalindrome(listNode));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private static ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode cur = head;
        Stack<Integer> stack = new Stack();
        stack.add(cur.val);
        while (cur.next != null) {
            cur = cur.next;
            stack.add(cur.val);
        }
        cur = head;
        while (cur != null) {
            if (cur.val != stack.pop()) {
                return false;
            }
            cur = cur.next;
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
