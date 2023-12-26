package list;

import model.ListNode;

/**
 * Find Start of LinkedList Cycle
 */
public class StartOfCycle {

    public static ListNode findCycleStart(ListNode head) {
        if(head==null) {
            return head;
        }

        ListNode slow = head, fast = head;

        int cycleLength = 0;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) {
                cycleLength = findCycleLength(slow);
                break;
            }
        }
        return findStart(head, cycleLength);
    }

    private static int findCycleLength(ListNode node) {
        ListNode current = node.next;
        int cycleLength = 1;
        while(current!=node) {
            cycleLength++;
            current=current.next;
        }
        return cycleLength;
    }

    private static ListNode findStart(ListNode head, int cycleLength) {
        ListNode kNode = head;
        while(cycleLength > 0) {
            kNode = kNode.next;
            cycleLength--;
        }
        ListNode node = head;
        while(node!=kNode) {
            node= node.next;
            kNode = kNode.next;
        }
        return node;
    }
}
