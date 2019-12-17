package LinkedList;

/**
 * @author jakadam on 2019-12-15
 */

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * <p>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode A) {
        //corner case:list has no nodes or single node
        if (A == null || A.next == null)
            return A;

        //initialize dummy head which refers to the answer list
        ListNode head = new ListNode(0);
        head.next = A;
        // initialize iterators
        ListNode cur = A, pre = head;

        while (cur != null) {
            //duplicate found, progress cur till we find a new node
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            //if cur is pointing to just the next node of pre, i.e. no duplicates found
            if (pre.next == cur)
                pre = pre.next;
            else// duplicates found and skipped, adjust pointers
                pre.next = cur.next;


            // common in both cases, to progress current
            cur = cur.next;
        }
        return head.next;
    }

    //Slightly different approach, working solution
    public ListNode deleteDuplicates1(ListNode A) {
        //corner case
        if (A == null || A.next == null)
            return A;

        //create head and cur for solution list
        ListNode dummy = new ListNode(0);
        ListNode dummyCur = dummy;

        //create cur pointer to traverse given list
        ListNode cur = A;

        //logic starts
        while (cur != null) {
            // if duplicates are found
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
            }
            //else element is unique
            else {
                dummyCur.next = cur;
                dummyCur = dummyCur.next;
            }

            //common cur increment for both if and else
            cur = cur.next;
        }
        // TESTCASE: 1->2->2->null  ans:[1]
        dummyCur.next = null;

        return dummy.next;
    }
}
