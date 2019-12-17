package LinkedList;

/**
 * @author jakadam on 2019-12-15
 */

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 * For example:
 *
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
public class RotateList {
    public ListNode rotateRight(ListNode A, int k) {

        //corner case
        if (A == null)
            return A;

        //find length of the list
        int lenA = 0;
        ListNode cur = A;
        while (cur != null) {
            cur = cur.next;
            lenA++;
        }

        //k can be greater than the length of the list: take mod of k with length of
        //the list i.e. rotate the list k%lenA times
        k = k % lenA;

        //if k is multiple of length of list, the list will remain  same even after rotation
        if (k == 0)
            return A;


        //ansHead is a dummy node which acts as the head of the list
        ListNode ansHead = new ListNode(0);
        ansHead.next = A;

        //progress cur (lenA-k) times, starting from the ansHead, cur will be pointing to the last node of result list
        //at the end of this loop
        cur = ansHead;
        int count = lenA - k;
        while (count > 0) {
            cur = cur.next;
            count--;
        }

        // mark the cur.next as head of answer list,
        ListNode newHead = cur.next, tempEnd = newHead;

        //mark the end of answer list
        cur.next = null;

        //tempEnd is used to point to the last node of given(existing) list
        while (tempEnd.next != null)
            tempEnd = tempEnd.next;

        //adjust pointers to connect end of existing list with head of existing list
        tempEnd.next = ansHead.next;


        //return the head of answer list
        return newHead;
    }

    //Slightly different approach, working solution
    public ListNode rotateRight1(ListNode head, int k) {
        ListNode lastNode = null;
        ListNode cur = head;

        if (head == null || head.next == null)
            return head;

        int len = 1;// assuming list has atleast 1 node, as head!=null above

        //calculate the length of the list
        // by the end of loop, cur will be pointing to the lastNode of current list
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }

        k = k % len;

        // if we rotate the list lenght times, head will again become head
        if (k == 0) return head;


        // connect the lastNode to head i.e., circle the list
        lastNode = cur;
        lastNode.next = head;

        //now, after rotating the list 'k' times (len-k)th node will be the
        //1->2->3->4->5->NULL and k = 2, ans 4->5->1->2->3->NULL.
        //in above eg. 3 is the end node and 4 is the start node for new list
        //so we just need to adjust the pointers now as we have created a cyclic list

        // find the (len-k)th node. mark the next node as head and (len-k)th nodes next pointer to null.
        ListNode tail = head;
        for (int i = 1; i < len - k; i++) {
            tail = tail.next;
        }

        // mark the head for new list/rotated list
        head = tail.next;

        // mark the end of new list/rotated list
        tail.next = null;


        return head;
    }

}

