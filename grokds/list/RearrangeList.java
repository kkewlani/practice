package list;

import model.ListNode;

public class RearrangeList {
    public ListNode reorder(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }

        ListNode prevToMiddle = findMiddle(head);
        ListNode reverseHead = reverse(prevToMiddle.next);
        prevToMiddle.next = null;
        ListNode prev = head;
        ListNode start = head;

        while(head!=null && reverseHead!=null) {
            ListNode hNext = head.next;
            head.next = reverseHead;
            head = hNext;

            ListNode rNext = reverseHead.next;
            reverseHead.next = head;
            prev = reverseHead;
            reverseHead = rNext;
        }
        if(reverseHead!=null) {
            prev.next = reverseHead;
        }

        return start;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode prev = null;

        while(fast!=null && fast.next!= null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle;
        if(fast!=null) {
            middle = slow.next;
            prev = slow;
        } else {
            middle = slow;
        }
        //prev.next = null;
        return prev;
    }

    private ListNode reverse(ListNode start) {
        ListNode prev = null;
        ListNode head = prev;
        ListNode next = start;

        do {
            head = next;
            next = head.next;
            head.next = prev;
            prev = head;
        } while(next!=null);
        ListNode curr = head;
        while(curr!=null) {
            System.out.print(curr.val+" ");
            curr = curr.next;
        }

        System.out.println("");
        return head;
    }

    public static void main(String[] args) {
        RearrangeList rl = new RearrangeList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode curr = head;
        System.out.println("original");
        while(curr!=null) {
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
        System.out.println("");

        curr = rl.reorder(head);
        System.out.println("after solution");
        while(curr!=null) {
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
    }
}
