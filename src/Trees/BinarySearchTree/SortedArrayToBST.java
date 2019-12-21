package Trees.BinarySearchTree;

/**
 * @author jakadam on 2019-12-21
 */

import Trees.TreeNode;

import java.util.List;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 *  Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of
 *  the two subtrees of every node never differ by more than 1.
 *  Example :
 *
 *
 *  Given A : [1, 2, 3]
 *  A height balanced BST  :
 *
 *       2
 *     /   \
 *    1     3
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(final List<Integer> a) {
        int len = a.size();
        if (len == 0 || a == null)
            return null;
        int start = 0, end = len - 1;
        return sortedArrayToBST(a, start, end);
    }

    public TreeNode sortedArrayToBST(final List<Integer> a, int start, int end) {
        /**
         * Idea is to make the mid element of the array as the root of the node and recursively making
         * mid of left half of array as root of left subtree and mid of right half of the array
         * as root of right subtree
         **/

        //only think of 1 node tree and the 3 node tree for imagination purpose

        if (start > end)
            return null;

        int mid = (start + end) / 2;

        //make mid element as root of the tree
        TreeNode root = new TreeNode(a.get(0));

        // recursively create left and right subtree
        root.left = sortedArrayToBST(a, start, mid - 1);
        root.right = sortedArrayToBST(a, mid + 1, end);

        //return the root
        return root;
    }
}

/**
 * https://www.youtube.com/watch?v=VCTP81Ij-EM
 **/