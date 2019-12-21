package Trees;

/**
 * @author jakadam on 2019-12-21
 */

import javax.sound.midi.Soundbank;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static Trees.PreOrderTraversal.preorderRecursive;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * Example :
 * Given
 *
 *
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * Note that the left child of all nodes should be NULL.
 */

public class FlattenBinaryTree {
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
        System.out.println("\n\n Before flattenBinaryTree: ");
        preorderRecursive(tree.getRoot());
        System.out.println("\n\n After flattenBinaryTree: ");
        preorderRecursive(flattenBinaryTree(tree.getRoot()));
    }

    public static TreeNode flattenBinaryTree(TreeNode root) {
        /**
         * Algorithm is simple. We use a stack to store nodes.
         *
         * Dry run the below code on example given in question to better understand the algorithm.
         *
         * 1. Add root to stack
         * perform following until stack becomes empty(i.e., all the nodes are processed)
         * 2. pop the node, push its right and left to stack. we push right first because stack is LIFO and
         *      we intend to connect current nodes right pointer to its left. pushing right first facilitates
         *      use to process left first
         * 3. connect current nodes right to stack top and left to null
         */
        if(root ==null)
            return null;

        Stack<TreeNode> stack= new Stack<>();
        stack.add(root);

        while(stack.isEmpty()==false){
            TreeNode node= stack.pop();

            // push right and left child to stack
            if(node.right!=null)
                stack.push(node.right);
            if(node.left!=null)
                stack.push(node.left);

            //set right of node to stack top and left to null
            if(stack.isEmpty()==false)
                node.right=stack.peek();

            node.left=null;
        }

        //return the root of the tree
        return root;
    }


}


/**
 * Tested on InterviewBit
 * https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/
 */
