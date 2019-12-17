package LinkedList;

/**
 * @author jakadam on 2019-12-14
 * <p>
 * https://www.interviewbit.com/problems/palindrome-list/
 * <p>
 * Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting
 * if its a palindrome or not, respectively.
 * <p>
 * Notes:
 * <p>
 * Expected solution is linear in time and constant in space.
 * For example,
 * <p>
 * List 1-->2-->1 is a palindrome.
 * List 1-->2-->3 is not a palindrome.
 */


/**
 * https://www.interviewbit.com/problems/palindrome-list/
 *
 * Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting
 * if its a palindrome or not, respectively.
 *
 * Notes:
 *
 * Expected solution is linear in time and constant in space.
 * For example,
 *
 * List 1-->2-->1 is a palindrome.
 * List 1-->2-->3 is not a palindrome.
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

public class PalindromeList {
    public int checkIfListIsPalindrome(ListNode A) {
        /*
        STEP1:  Find the middle of the list
        STEP2:  Cut the list at middle & Reverse the Second half
        STEP3:  Compare the 2 lists node by node

        NOTE: Finding middle element in LL and Reversing the LL are two common, reusable operations.
        They have standard code.
        For both these operations just take a 3 node list and dry run the logic on it.

        */

        //Pointers for 2 lists. Initialize head2 once you get the start of second list.
        ListNode head1 = A;
        ListNode head2 = null;


        // STEP1: Find middle of the list.
        // Use 2 pointers, at the end of loop, slow pointer points to the middle ele.
        // middle.next=> start of second list & middle.next=null (mark the end of first list)
        ListNode fast = A;
        ListNode slow = A;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // mark start of second list
        head2 = slow.next;

        // mark end of first list
        slow.next = null;


        // STEP2: Cut the list at middle & Reverse the Second half
        // we have already cut the list so just reverse the second list now.
        ListNode cur = head2;
        ListNode prev = null;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        //prev will be pointing to the head of the reversed list, hence update head2
        head2 = prev;

        // STEP3: Check the 2 lists node by node for palindrome property
        while (head1 != null && head2 != null) {
            if (head1.val == head2.val) {
                head1 = head1.next;
                head2 = head2.next;
            } else
                break;
        }


        //The logic for finding middle is written in such a way, that if the lis has
        // off no. of else, after split, first list will always have the greater no. of else

        // hence in the end, we check head1==null || head1.next==null.
        // if initial list has odd no. of eles, head1.next==null will be true
        // eg. 1->2->1  is a palindrome.
        if ((head1 == null || head1.next == null) && head2 == null)
            return 1;
        else return 0;

    }
}


/*
Notes-
this solution reuses the technique used in reorder list problem
https://leetcode.com/problems/palindrome-linked-list/#/solutions
http://www.programcreek.com/2014/07/leetcode-palindrome-linked-list-java/
*/


