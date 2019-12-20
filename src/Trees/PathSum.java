package Trees;

/**
 * @author jakadam on 2019-12-20
 */

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Example :
 *
 * Given the below binary tree and sum = 22,
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */

public class PathSum {
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

        System.out.println("\n\nHasPathSum");
        System.out.println(hasPathSum(tree.getRoot(), 6));
        System.out.println(hasPathSum(tree.getRoot(), 5));
        System.out.println(hasPathSum(tree.getRoot(), 100));
    }


    public static boolean hasPathSum(TreeNode root, int sum) {
        // we have not found the path with given sum, that why we are the end of leaf node
        // and trying to check the value of that node
        if (root == null)
            return false;
        else {
            // we found a leaf node where the path sum is equal to given number
            // return true
            if (root.left == null && root.right == null && sum - root.val == 0)
                return true;
            else {
                //make a recursive call to each child node asking them that from this node
                //there exists a path with given sum or not
                return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
            }
        }
    }
}

/**
 * https://www.interviewbit.com/problems/path-sum/
 * https://www.youtube.com/watch?v=Hg82DzMemMI
 * https://leetcode.com/problems/path-sum/#/solutions
 */