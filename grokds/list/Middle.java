package list;

import model.ListNode;

public class Middle {
    public ListNode findMiddle(ListNode head) {
        if (head == null) {
            return head;
        }

        //starting position
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null) {
            return slow;
        } else {
            return slow.next;
        }
    }
}
