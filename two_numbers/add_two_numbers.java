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

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Length, l2Length;
        int number1, number2;
        number1 = generateNumber(l1);
        number2 = generateNumber(l2);
        //System.out.println(number1 + " "+ number2);
        int addedNumber = number1 + number2;
        return generateList(addedNumber);
    }

    private int generateNumber(ListNode l) {
        int pos = 0, number = 0;
        while (l != null) {
            number = addDigit(number, l.val, pos);
            //System.out.println(number);
            pos++;
            l = l.next;
        }
        return number;
    }

    private int addDigit(int number, int digit, int pos ) {
        int newNumber = (number + digit * ((int) Math.pow(10,pos)));
        //System.out.println(newNumber + ", ("+ number+ "+ "+ digit +"* (10 ^"+pos+")");
        return newNumber;
    }

    private ListNode generateList(int number) {
        String num = String.valueOf(number);
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

}