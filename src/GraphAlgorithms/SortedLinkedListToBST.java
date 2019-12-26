package GraphAlgorithms;

import LinkedList.ListNode;
import Trees.TreeNode;

/**
 * @author jakadam on 2019-12-24
 */

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * A height balanced BST : a height-balanced binary tree is defined as a binary tree in which the depth of the
 * two subtrees of every node never differ by more than 1.
 * Example :
 * <p>
 * <p>
 * Given A : 1 -> 2 -> 3
 * A height balanced BST  :
 * <p>
 * 2
 * /   \
 * 1     3
 */

public class SortedLinkedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        return buildBST(head, null);

    }

    public static TreeNode buildBST(ListNode head, ListNode tail) {
        // base condition
        if (head == tail)
            return null;

        //step 1: find mid element using hare and tortoise
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != tail && fast.next.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //step 2: build BST
        TreeNode root = new TreeNode(slow.val);
        root.left = buildBST(head, slow);
        root.right = buildBST(slow.next, tail);

        return root;
    }
}
/**
 * solution is O(NlogN)
 * <p>
 * Logic is identical to the logic used in SortedArrayToBST
 */