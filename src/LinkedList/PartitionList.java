package LinkedList;

/**
 * @author jakadam on 2019-12-15
 */


/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
public class PartitionList {
    public ListNode partition(ListNode A, int B) {
        //corner case
        if(A==null || A.next==null)
            return A;

        // we will split the given list into 2 separate lists, one contains nodes<B and other contains
        // nodes>=B
        ListNode smallerHead=new ListNode(0);
        ListNode smallerHeadItr=smallerHead;
        ListNode largerHead=new ListNode(0);
        ListNode largerHeadItr=largerHead;

        // build the smaller and larger lists
        ListNode cur=A;

        while(cur!=null){
            if(cur.val<B){
                smallerHeadItr.next=cur;
                smallerHeadItr=smallerHeadItr.next;

            }else{
                largerHeadItr.next=cur;
                largerHeadItr=largerHeadItr.next;
            }
            cur=cur.next;
        }


        // connect the last node of smaller list to the first node of the larger list
        smallerHeadItr.next =largerHead;

        // mark the last node of larger list as null to represent end of result list
        largerHeadItr.next=null;

        return smallerHead.next;
    }

}
