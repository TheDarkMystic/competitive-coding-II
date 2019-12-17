package LinkedList;

/**
 * @author jakadam on 2019-12-15
 */


/**
 * Given a sorted linked list, delete all duplicates such that each element appear
 * only once.
 * <p>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode A) {
        //corner case
        //1.List has 0 or 1 node
        if (A == null || A.next == null)
            return A;

        /**
         * iterate over list and for each node, scan next nodes till you find the non-duplicate
         * node and connect the current nodes next to the newly found non-duplicate node
         */

        //head is used as dummy node which points to the answer list
        ListNode head = new ListNode(0);
        head.next = A;
        //initialize list iterators
        ListNode cur = A, next = A;

        while (cur != null) {
            //if the val of cur and next node are equal, we have encountered duplicate,
            //adjust pointers to remove the duplicate and repeat till we find next unique node
            while (next != null && cur.val == next.val) {
                next = next.next;
            }
            cur.next = next;

            //reset cur and next to the new unique node for the next iteration of finding new
            //unique node in list
            cur = cur.next;
            next = cur;
        }
        //return the list
        return head.next;
    }


    //Slightly different approach, working solution

    public ListNode deleteDuplicates1(ListNode A) {

        ListNode cur = A;

        //sequence of operations is important

        //1. Check if cur is null or not
        while (cur != null) {

            //2. if next node is null, no point in going ahead. Break.
            if (cur.next == null)
                break;
            //3. if cur and next has same value, drop the next node
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            //4. increament the cur pointer
            else
                cur = cur.next;
        }
        return A;
    }

}

/*
Notes:
recursive solution
https://discuss.leetcode.com/topic/12580/3-line-recursive-solution/10
 */