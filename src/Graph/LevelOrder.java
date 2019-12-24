package Graph;

import Trees.BinaryTree;
import Trees.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author jakadam on 2019-12-24
 */

/**
 * Given a binary tree, return the level order traversal of its nodes’ values.
 * (ie, from left to right, level by level).
 *
 * Example :
 * Given binary tree
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * Also think about a version of the question where you are asked to do a level order
 * traversal of the tree when depth of the tree is much greater than number of nodes on
 * a level.
 */
public class LevelOrder {
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
        System.out.println(Arrays.toString(levelOrder(tree.getRoot()).toArray()));
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        TreeNode root = A;
        //define result container and BFS queue
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        //add root to the queue
        queue.add(root);

        while (!queue.isEmpty()) {
            // for each level use new list to store nodes in that level
            ArrayList<Integer> level = new ArrayList<>();

            //compute the size of the level
            int qsize = queue.size();

            for (int i = 0; i < qsize; i++) {
                // poll node from queue and add it to level list
                TreeNode node = queue.poll();
                level.add(node.val);

                // add children of the node to queue for processing
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            //add level list to result container
            res.add(new ArrayList<Integer>(level));
        }
        return res;
    }
}
/**
 * https://www.interviewbit.com/problems/level-order/
 * Refer Trees.ZigZagLevelOrderTraversal, This problem is almost identical to current, except the zigzag pattern
 */