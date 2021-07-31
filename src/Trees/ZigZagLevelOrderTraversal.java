package Trees;

import apple.laf.JRSUIUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jakadam on 2019-12-20
 */

/**
 * https://www.interviewbit.com/problems/zigzag-level-order-traversal-bt/
 * Given a binary tree, return the zigzag level order traversal of its nodes’ values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * Example :
 * Given binary tree
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return
 *
 * [
 *          [3],
 *          [20, 9],
 *          [15, 7]
 * ]
 */
public class ZigZagLevelOrderTraversal {
    public static void main(String[] args) {

        /*
                   1
                /     \
               2        5
             /   \     /  \
            3    4   null null
           /  \   \
        null null null
         */

        BinaryTree tree = new BinaryTree();
        System.out.println("\n\nZigZagOrderRecursive");
        zigzagLevel(tree.getRoot());


    }

    public static void zigzagLevel(TreeNode root){

        /*
        -   In java Queue, LinkedList are implemented as per DoublyLL.
        -   Doubly-linked list implementation of the List and Deque interfaces.
            Implements all optional list operations, and permits all elements (including null).
            All of the operations perform as could be expected for a doubly-linked list.
            Operations that index into the list will traverse the list from the beginning or the end,
            whichever is closer to the specified index.(From JavaDoc)
        -   Hence addFirst() and addLast() are both O(1)
        -   res is the result arayList
        -   q is a Queue which will be used to store and process treeNodes as we
            traverse the tree
        */
        Queue<TreeNode> queue= new LinkedList<>();

        queue.add(root);//added root to Queue to initialize the process.
        boolean addLast=true;//invert flag

         /*
        -   q.isEmpty()==false -> While there are nodes in the tree which are unprocessed
        */

        while(queue.isEmpty()==false){
            // create a new LL for processing each level of tree
            LinkedList<TreeNode> level= new LinkedList<>();

            // Process the Level
            int qSize=queue.size();
            for(int i=0; i<qSize; i++){
                //pop the node from tree and add it to front or end acc. to zigZag
                TreeNode cur= queue.poll();
                if(addLast==true)
                    level.addLast(cur);
                else
                    level.addFirst(cur);
                // push the children of the Node to the que for processing in next level
                if(cur.left!=null)
                    queue.offer(cur.left);
                if(cur.right!=null)
                    queue.offer(cur.right);

            }
            //end of for

            //invert the zigZag
            addLast=!addLast;

            //print level linkedlist
            for(TreeNode node:level)
                System.out.print(node.val+" ");
            System.out.println();
        }

    }
}
/**
 CTRL+F -> marcusgao

 https://discuss.leetcode.com/topic/3413/my-accepted-java-solution/13

 https://www.tutorialspoint.com/java/util/linkedlist_addfirst.htm
 */