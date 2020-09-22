/**
 * Question:
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 *
 *
 * Provided:
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.math.BigDecimal;

class AddReverseNumberAsList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Length, l2Length;
        BigDecimal number1, number2;
        number1 = generateNumber(l1);
        number2 = generateNumber(l2);
        //System.out.println(number1 + " "+ number2);
        BigDecimal addedNumber = number1.add(number2);
        return generateList(addedNumber);
    }

    private BigDecimal generateNumber(ListNode l) {
        int pos = 0;
        BigDecimal number = new BigDecimal(0);
        while (l != null) {
            number = addDigit(number, l.val, pos);
            //System.out.println(number);
            pos++;
            l = l.next;
        }
        return number;
    }

    private BigDecimal addDigit(BigDecimal number, int digit, int pos ) {
        BigDecimal posNumber = (new BigDecimal (10)).pow(pos);

        BigDecimal newNumber = number.add(posNumber.multiply(new BigDecimal(digit)));
        //System.out.println(newNumber.toPlainString() + ", ("+ number.toPlainString()+ "+ "+ posNumber.toPlainString());
        return newNumber;
    }

    private ListNode generateList(BigDecimal number) {
        String num = number.toPlainString();
        int numLength = num.length();
        ListNode prev = null, curr = null, head = null;
        for (int i = numLength-1; i >= 0; i--) {
            curr = new ListNode(Integer.parseInt(String.valueOf(num.charAt(i))));
            if (prev != null) {
                prev.next = curr;
            } else {
                head = curr;
            }
            prev = curr;
        }
        return head;
    }

    class ListNode {
        ListNode next;
        int val;
         public ListNode(int val) {
             this.val = val;
         }
    }
}