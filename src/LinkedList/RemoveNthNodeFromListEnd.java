package LinkedList;

/**
 * @author jakadam on 2019-12-15
 */

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 *  Note:
 * If n is greater than the size of the list, remove the first node of the list.
 * Try doing it using constant additional space.
 */
public class RemoveNthNodeFromListEnd {
    public ListNode removeNthFromEnd(ListNode A, int n) {
        /*

        1->2->3->4->5, and n = 2.
        1->2->3->5
        */
        int lenA = 0;
        ListNode head = new ListNode(0);
        head.next = A;
        ListNode cur = A;
        //corner case
        if (A == null)
            return A;

        //find length of the list
        while (cur != null) {
            lenA++;
            cur = cur.next;
        }
        //If n is greater than the size of the list, remove the first node of the list.
        if (n > lenA)
            return A.next;

        //initialize two pointers ptr1 and ptr2, both pointing to the dummyHead.
        //progress ptr1, n times from head, without moving ptr2. Then move start progressing
        //both pointers simultaneously one step at a time until ptr1 reaches end of list
        //observation: when ptr1 reaches end of list, ptr2 is pointing to the node which
        //is just one place behind the node to be removed from the list

        ListNode ptr1 = head, ptr2 = head;
        while (ptr1.next != null) {
            if (n > 0) {
                ptr1 = ptr1.next;
                n--;
            } else {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
        }
        //remove the node by adjusting the pointers
        if (ptr2.next != null)
            ptr2.next = ptr2.next.next;

        return head.next;
    }

    //Slightly different approach, working solution
    public ListNode removeNthFromEnd1(ListNode A, int n) {
        ListNode slow=A;
        ListNode fast=A;

        // move fast pointer n+1 times in total. First move n times and later once
        // this maintains the constant gap of n nodes between fast and slow pointers
        for(int i=0;i<n; i++){
            if(fast!=null)
                fast=fast.next;
            else
                break;
        }

        // if fast==null remove head
        if(fast==null)
            return A.next;

        // now move it once more
        fast= fast.next;


        // now move the both pointers in sync, 1 step at a time
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }


        //now remove the slow.next
        slow.next=slow.next.next;

        return A;
    }

}
