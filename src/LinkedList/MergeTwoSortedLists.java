package LinkedList;

/**
 * @author jakadam on 2019-12-15
 */

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists,
 * and should also be sorted.
 *
 * For example, given following linked lists :
 *
 *   5 -> 8 -> 20
 *   4 -> 11 -> 15
 * The merged list should be :
 *
 * 4 -> 5 -> 8 -> 11 -> 15 -> 20
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {

        // corner cases
        //1. both lists are null or
        if (A == null && B == null)
            return A;

        //2. one of them is null, return whichever is not null
        if (A == null || B == null)
            return A == null ? B : A;

        //initialize iterators for list, ansHead points to the ans list,
        //head is the first node of ans list

        ListNode ptrA = A,
                ptrB = B,
                head = new ListNode(0),
                ansHead = head;
        while (true) {
            //both the lists are not exhausted yet
            if (ptrA != null && ptrB != null) {
                if (ptrA.val <= ptrB.val) {
                    head.next = ptrA;
                    ptrA = ptrA.next;
                } else {
                    head.next = ptrB;
                    ptrB = ptrB.next;
                }
                head = head.next;
            } else {// one of the lists has exhausted
                head.next = (ptrA == null) ? ptrB : ptrA;
                break;
            }
        }

        return ansHead.next;
    }

}


/*
Notes-
https://discuss.leetcode.com/topic/27564/my-ac-java-solution
 */