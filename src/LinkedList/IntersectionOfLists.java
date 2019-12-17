package LinkedList;

/**
 * @author jakadam on 2019-12-14
 * <p>
 * https://www.interviewbit.com/problems/intersection-of-linked-lists/
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * For example, the following two linked lists:
 * <p>
 * <p>
 * A:          a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B:     b1 → b2 → b3
 * <p>
 * begin to intersect at node c1.
 * <p>
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */

/**
 * https://www.interviewbit.com/problems/intersection-of-linked-lists/
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 *
 *
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 *
 * begin to intersect at node c1.
 *
 *  Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class IntersectionOfLists {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        //step 1: calculate the lengths of both the linked lists say lenA and lenB =>O(lenA+lenB)
        //step 2: mark the bigger list as A, calculate the difference between the lengths, d = |lenA-lenB|
        //step 3: move the iterator d nodes from the head in the larger list
        //step 4: now, start iterating both the lists and compare the pointer(address) of the nodes
        //        to find the common node => O(lenA+lenB)
        //Overall time complexity=>O(lenA+lenB), space complexity => O(1)


        //step1:
        int lenA = 0, lenB = 0;
        ListNode head1 = a, head2 = b;

        //continue operation until both the lists are exhausted
        while (!(head1 == null && head2 == null)) {
            // for list a
            if (head1 != null) {
                lenA++;
                head1 = head1.next;
            }
            //for list2
            if (head2 != null) {
                lenB++;
                head2 = head2.next;
            }
        }

        //step2:
        // we are assuming that a is bigger than b, if that is not the case swap the lists
        if (lenA < lenB) {
            // swap the lists
            ListNode temp = b;
            b = a;
            a = temp;
        }

        int d = Math.abs(lenA - lenB);

        //step3: combining step3 and step4 here to otimize the code
        head1 = a;
        head2 = b;
        while (!(head1 == null && head2 == null)) {
            if (d > 0) {
                head1 = head1.next;
                d--;
            } else {
                if (head1 == head2) return head1;
                if (head1 != null) head1 = head1.next;
                if (head2 != null) head2 = head2.next;

            }

        }
        // no intersection found
        return null;
    }

    public ListNode getIntersectionNodeWithoutDiff(ListNode headA, ListNode headB) {
        /**
         * Idea:
         * Actually we don't care about the "value" of difference, we just want to make sure two pointers
         * reach the intersection node at the same time.
         *
         * We can use two iterations to do that. In the first iteration, we will reset the pointer of one
         * LinkedList to the head of another LinkedList after it reaches the tail node. In the second
         * iteration, we will move two pointers until they points to the same node. Our operations in
         * first iteration will help us counteract the difference. So if two LinkedList intersects, the
         * meeting point in second iteration must be the intersection point. If the two linked lists have
         * no intersection at all, then the meeting pointer in second iteration must be the tail node of
         * both lists, which is null
         */

        //boundary check
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while (a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}

/**
 * Notes: https://discuss.leetcode.com/topic/28067/java-solution-without-knowing-the-difference-in-len
 */
