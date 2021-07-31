package LinkedList;

/**
 * @author jakadam on 2020-01-16
 */

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Try solving it using constant additional space.
 *
 * Example :
 *
 * Input :
 *
 *                   ______
 *                  |     |
 *                  \/    |
 *         1 -> 2 -> 3 -> 4
 *
 * Return the node corresponding to node 3.
 */

public class ListCycle {
    public ListNode detectCycle(ListNode a) {
        ListNode head=a,
                fast=a,
                slow=a;


        //if the LL has no cycle, fast will be the first one to reach end of LL and
        //we keep fast.next!=null because fast is moving 2 steps so fast and fas.next both can reach the end.
        // hence the while condition
        while(fast!=null && fast.next!=null){
            fast= fast.next.next;
            slow=slow.next;

            if(slow==fast)//loop detected
            {
                // finding start of the loop
                // reset the slow to head and now move both pointers 1 step at a time
                slow=head;

                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                //once this loop breaks, meaning once the slow and fast pointing to the same node, we have found start of the cycle
                // why? for the reasoning check leetcode ans comments or gaurav sen's video
                // we can return either slow or fast as both are pointing to the start
                return slow;
            }
        }

        return null;// cycle not found
    }
}

/*

       Algorithm is simple
       1. take two pointers slow and fast
       2. slow moves ones step and fast moves 2 steps at a time
       3. if cycle exists, pointers will eventually meet else return NULL
       4. if cycle found, reset the slow pointer to the head, now run slow and fast both one step at a time
       5. when we keep them running, they meet at start of cycle.

        Why the algorithm works:
        https://www.geeksforgeeks.org/how-does-floyds-slow-and-fast-pointers-approach-work/
        https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/

 */

