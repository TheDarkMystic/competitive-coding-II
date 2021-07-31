package LinkedList;


/**
 * https://www.interviewbit.com/problems/add-two-numbers-as-lists/
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single
 * digit.
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 342 + 465 = 807
 * Make sure there are no trailing zeros in the output list
 * So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */

public class AddTwoNumbersAsLists {
    public ListNode addTwoNumbers(ListNode a, ListNode b) {

        // both lists are null, return ListNode(0) as result
        if (a == null && b == null)
            return new ListNode(0);

        ListNode head1 = a, head2 = b, ansNode = new ListNode(0), ansHead = ansNode;
        int num = 0, carry = 0;
        // continue adding the numbers till both the lists are exhausted
        while (!(head1 == null && head2 == null)) {
            num = (head1 == null ? 0 : head1.val) +
                    (head2 == null ? 0 : head2.val) +
                    carry;

            //calculate carry and the sum of two digits
            carry = num / 10;
            num = num % 10;

            //add a new node containing sum of the digits into the ans list and progress
            //the ans pointer
            ansHead.next = new ListNode(num);
            ansHead = ansHead.next;

            // progress the iterator of the lists to be added if the list is not exhausted
            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head1.next;


        }
        // check the carry in the end and add new node to ans list if carry is not 0
        if (carry != 0)
            ansHead.next = new ListNode(carry);

        return ansNode.next;
    }
}
