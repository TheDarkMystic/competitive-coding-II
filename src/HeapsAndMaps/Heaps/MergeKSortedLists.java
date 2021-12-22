package HeapsAndMaps.Heaps;

/**
 * @author jakadam on 2019-12-21
 */

import LinkedList.ListNode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 *
 * Example :
 *
 * 1 -> 10 -> 20
 * 4 -> 11 -> 13
 * 3 -> 8 -> 9
 * will result in
 *
 * 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 */


public class MergeKSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        // input contains heads of sorted LinkedLists to be merged

        /*
        Following is detailed algorithm.
        1. Create an output array of size n*k.
        2. Create a min heap of size k and insert 1st element in all the arrays into the heap
        3. Repeat following steps n*k times.
             a) Get minimum element from heap (minimum is always at root) and store it in output array.
             b) Replace heap root with next element from the array from which the element is extracted.

             If the array doesnt have any more elements, then replace root with infinite. After replacing
             the root, heapify the tree.

             3b is tricky as we need have been provided with heads of lists not the entire lists in input
             we need to figure out a way to progress in the lists simultaneously

             carefully observe the operations inside while loop
        */

        //corner case: input list is empty
        if (a == null || a.size() == 0)
            return null;


        // define minHeap to sort ListNodes, ListNodes is a custom data type hence we have to define a
        // comparator over here to override toCompare method
        Queue<ListNode> minHeap = new PriorityQueue<>(
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode o1, ListNode o2) {
                        if (o1.val < o2.val)
                            return -1;
                        else if (o1.val > o2.val)
                            return 1;
                        else
                            return 0;
                    }
                }
        );





        // add the all the K heads of K LLs to the heap
        for (ListNode node : a) {
            minHeap.add(node);
        }

        ListNode dummyHead = new ListNode(0);
        ListNode dummyEnd = dummyHead;

        while (minHeap.isEmpty() == false) {
            // remove the root i.e., smallest node from minHeap and after poll operation heap will get
            //adjusted and the smaller of the k-1 remaining listNodes will become root
            dummyEnd.next = minHeap.poll();
            //progress the end of result List so that we can append the new smallest at the end
            dummyEnd = dummyEnd.next;

            //we removed 1 node from minHeap, we need to maintain heapSize =k , so we add a node
            // of the list from which we removed last node and that node is pointed by dummyEnd right now
            // need to be careful and check if that was the last node of that list
            if (dummyEnd.next != null) { // if node added to result list is not the last node of the sorted list
                minHeap.add(dummyEnd.next);
            }
        }

        return dummyHead.next;
    }
}

/**
 * Tested on InterviewBit
 * https://www.interviewbit.com/problems/merge-k-sorted-lists/
 */