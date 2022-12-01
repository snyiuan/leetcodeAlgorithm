package leetCode;

public class L21mergeTwoLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(mergeTwoLists(list1, list2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            return new ListNode(list1.val, mergeTwoLists(list1.next, list2));
        } else {
            return new ListNode(list2.val, mergeTwoLists(list1, list2.next));
        }

    }

    public static ListNode mergeTwoLists3(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode l = new ListNode(0);
        ListNode start = l;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                l.next = list2;
                list2 = null;
            } else if (list2 == null) {
                l.next = list1;
                list1 = null;
            } else if (list1.val <= list2.val) {
                l.next = new ListNode(list1.val);
                list1 = list1.next;
                l = l.next;
            } else {
                l.next = new ListNode(list2.val);
                list2 = list2.next;
                l = l.next;
            }
        }
        return start.next;
    }
}
