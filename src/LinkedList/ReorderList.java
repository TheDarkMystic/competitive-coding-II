package LinkedList;

/**
 * @author jakadam on 2019-12-15
 */

/**
 * Given a singly linked list
 *
 *     L: L0 → L1 → … → Ln-1 → Ln,
 * reorder it to:
 *
 *     L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * You must do this in-place without altering the nodes’ values.
 *
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {
    public ListNode reorderList(ListNode A) {
        /**
         * Step 1: Cut the given list in the middle
         * Step 2: Reverse the second half of the list
         * Step 3: Now, weave the first half of the list and list obtained from step2 to get the answer list
         */

        //corner case
        if (A == null || A.next == null)
            return A;

        //Step1: find the middle node, to cut the list in the middle
        ListNode slow = A, fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //with this approach, at the end of the loop, slow will point to the last node of the fist half,
        // also if list contains odd number of nodes, first half will always have one node more than second half
        //eg. if 1-2-3-4-5 is given list, after cutting we will get 1-2-3 and 4-5

        //mark the snd of first list and start of second list
        ListNode l2Start = slow.next;
        slow.next = null;

        //Step2: Reverse the second half
        ListNode cur = l2Start, prev = null, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        //at the end of this loop prev will be pointing to the start of the reversed list
        // and A is pointing to the head of first list
        ListNode dummyHead = new ListNode(0);
        ListNode ptr1 = A, ptr2 = prev;
        ListNode ansHead = dummyHead;


        //Step3: Weaving the lists
        //continue until both lists are exhausted
        while (!(ptr1 == null && ptr2 == null)) {

            if (ptr1 != null) {
                dummyHead.next = ptr1;
                ptr1 = ptr1.next;
                dummyHead = dummyHead.next;
            }

            if (ptr2 != null) {
                dummyHead.next = ptr2;
                ptr2 = ptr2.next;
                dummyHead = dummyHead.next;
            }
        }
        //in case the original list has odd number of nodes, list1 will have an extra node
        if (ptr1 != null) {
            dummyHead.next = ptr1;
            ptr1 = ptr1.next;
            dummyHead = dummyHead.next;
        }


        return ansHead.next;
    }

}
