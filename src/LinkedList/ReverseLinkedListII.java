package LinkedList;

/**
 * @author jakadam on 2019-12-15
 */

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return 1->4->3->2->5->NULL.
 *
 *  Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list. Note 2:
 * Usually the version often seen in the interviews is reversing the whole
 * linked list which is obviously an easier version of this question.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode A, int B, int C) {
        //corner case
        if (A == null || A.next == null)
            return A;

        //we are reversing 2->3->4 out of 1->2->3->4->5->NULL,
        //ans: 1->4->3->2->5->NULL

        // we will divide this problem in 2 steps,
        //1. identifying correct segment to be reversed
        //2. actually reversing the segment

        //Step1:
        //use 2 pointers ptr1 and prevToPtr1 which track start of the segment to be reversed and
        //node just before the segment starts, respectively. We need prevToPtr1 so that we can connect the
        //reversed segment with the first half of the given list

        ListNode dummy = new ListNode(0);
        dummy.next = A;
        ListNode ptr1 = dummy, prevToPtr1 = dummy;
        int count = B;

        while (ptr1 != null && count > 0) {
            //when B=1, we are at node just previous to the start of the segment to be reversed
            if (count == 1)
                prevToPtr1 = ptr1;

            ptr1 = ptr1.next;
            count--;
        }


        //now ptr1 points to start of the segment to be reversed

        //Step2: actually reversing the list
        int numNodesToBeReversed = C - B + 1;
        ListNode reversedSegmentHead = reverseList(ptr1, numNodesToBeReversed);

        //prev==null means we started the reversal process from node 1
        //eg. 1->2->3 start=1, end=2
        if (prevToPtr1 == null)
            return reversedSegmentHead;

        //connect the first segment of the given list to the reversed segment
        prevToPtr1.next = reversedSegmentHead;

        return dummy.next;


    }

    public ListNode reverseList(ListNode head, int count) {
        ListNode cur = head,
                prev = null,
                next = null;

        while (cur != null && count > 0) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;

            count--;
        }

        //after reversal prev points to the 1st node of the reversed list and
        //head points to the last node of the reversed list
        //cur will point to the next node after the last node in the list which usually is null node
        //because usually we reverse the entire list but in the case where we are reversing the segment
        //of an entire list, cur will point to the next node after the list segment to be reversed, so that means
        //here we are reversing 2->3->4 out of 1->2->3->4->5->NULL, hence after we reverse we get 4->3->2
        //prev -> 4, head->2, cur->5

        //this is a key step. connect the reversed segment to the remaining part of the entire list, here we
        //need to connect end of reversed segment to 5
        head.next = cur;


        //now return the head of reversed segment which is held in prev
        return prev;
    }


}
