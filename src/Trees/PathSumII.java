package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jakadam on 2019-12-20
 */

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 */
public class PathSumII {
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

        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayList<Integer> curPath = new ArrayList<>();

        System.out.println("\n\nHasPathSum");
        hasPathSum(tree.getRoot(), 6, paths, new ArrayList<Integer>(curPath));

        System.out.println(Arrays.toString(paths.toArray()));
    }




    public static void hasPathSum(TreeNode root, int sum, ArrayList<ArrayList<Integer>> paths,
                                  ArrayList<Integer> curPath) {

        // we have not found the path with given sum, that why we are the end of leaf node
        // and trying to check the value of that node
        if (root == null)
            return;

        // we found a leaf node where the path sum is equal to given number
        // add found path and return control
        curPath.add(root.val);

        if (root.left == null && root.right == null && sum - root.val == 0) {
            paths.add(curPath);
            return;
        }
        //make a recursive call to each child node asking them that from this node
        //there exists a path with given sum or not

        //pass a new copy of curpath to each node instead of passing the same list
        hasPathSum(root.left, sum - root.val, paths, new ArrayList<>(curPath));
        hasPathSum(root.right, sum - root.val, paths, new ArrayList<>(curPath));


    }
}
/**
 *  check out SumRootToLeafNumbers, it is very similar to this one
 *
 * https://leetcode.com/problems/path-sum-ii/
 * https://www.youtube.com/watch?v=3B5gnrwRmOA
 */
