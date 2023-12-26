package list;

import model.ListNode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next== null) {
            return true;
        }
        ListNode prevToMiddle = findMiddle(head);
        ListNode reverseHead = reverse(prevToMiddle.next);
        prevToMiddle.next = null;
        System.out.println("printing after reverse");
        ListNode curr = head;
        while(curr!=null) {
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
        System.out.println("cut");
        boolean isPalin = checkPalindrome(head, reverseHead);
        ListNode middleHead = reverse(reverseHead);
        prevToMiddle.next = middleHead;
        return isPalin;
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

    private boolean checkPalindrome(ListNode first, ListNode second) {
        ListNode head1 = first;
        ListNode head2 = second;
        while(head1!= null && head2!= null) {
            if(head1.val!=head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }

    // return new head
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
        PalindromeLinkedList p = new PalindromeLinkedList();

        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        //head.next.next.next.next.next = new ListNode(2);
        ListNode curr = head;
        System.out.println("original");
        while(curr!=null) {
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
        System.out.println("");

        System.out.println(p.isPalindrome(head));
        curr = head;
        System.out.println("after solution");
        while(curr!=null) {
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
    }
}
