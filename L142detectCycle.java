package leetCode;

import java.util.ArrayList;
import java.util.List;

public class L142detectCycle {
    public ListNode detectCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            if (list.contains(head)) {
                return head;
            }else{
                list.add(head);
                head = head.next;
            }            
        }
        return null;
    }
}
