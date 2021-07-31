package Trees;

/**
 * @author jakadam on 2019-12-20
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree
 *
 *     struct TreeLinkNode {
 *       TreeLinkNode *left;
 *       TreeLinkNode *right;
 *       TreeLinkNode *next;
 *     }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 *  Note:
 * You may only use constant extra space.
 * Example :
 *
 * Given the following binary tree,
 *
 *          1
 *        /  \
 *       2    3
 *      / \  / \
 *     4  5  6  7
 * After calling your function, the tree should look like:
 *
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \  / \
 *     4->5->6->7 -> NULL
 *  Note 1: that using recursion has memory overhead and does not qualify for constant space.
 *  Note 2: The tree need not be a perfect binary tree.
 */

public class PopulateNextRightPointersTree {
    public void usingLevelOrderWithQueue(TreeLinkNode root) {
        //The idea is simple: level-order traversal.
        //use dummy node to point to the leftmost node of level and populate pointers
        Queue<TreeLinkNode> que = new LinkedList<TreeLinkNode>();

        que.add(root);

        while (que.isEmpty() == false) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode current = que.poll();

                if (i == size - 1) {//last or rightmost node of level
                    current.next = null;
                } else
                    current.next = que.peek();

                //adding children to queue
                if (current.left != null) que.add(current.left);
                if (current.right != null) que.add(current.right);
            }
        }

    }

    public void usingLevelOrderWithoutQueue(TreeLinkNode root) {
        // root:
        // this pointer is initialized with the root of the tree, this pointer points to the prev level
        // of the level in which we are populating next pointers
        // dummyhead:
        // this pointer tracks the level in which we are populating the next pointers,
        // this acts as the head of the level and does not iterate trhough the nodes of the level, just
        // points to the leftmost node of the level
        // current:
        // this pointer is used to iterate through the nodes of the current level i.e.,
        // the level pointed by dummyhead and while iterating it populates the next pointers

        TreeLinkNode dummyhead = new TreeLinkNode(0);
        TreeLinkNode current = null;

        // iterate through the tree, level by level
        while (root != null) {

            // iterate through the level node by node and populate pointer
            current = dummyhead;

            // in the inner while loop, root becomes null when it reaches the righmost_node.next of the level
            while (root != null) {
                if (root.left != null) {
                    current.next = root.left;
                    current = current.next;
                }
                if (root.right != null) {
                    current.next = root.right;
                    current = current.next;
                }
                root = root.next;
            }
            // set the pointers for processing next level
            root = dummyhead.next;
            dummyhead.next = null;
        }
    }
}

/**
 * Solutions are tested on InterviewBit
 *
 * interviewbit.com/problems/populate-next-right-pointers-tree/
 *
 * https://www.youtube.com/watch?v=mBVN8G-pIzU
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/37811/Simple-solution-using-constant-space
 * */
