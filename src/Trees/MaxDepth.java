package Trees;

/**
 * @author jakadam on 2019-12-20
 */

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth of a binary tree is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *  NOTE : The path has to end on a leaf node.
 * Example :
 *
 *          1
 *         /
 *        2
 * max depth = 2
 */
public class MaxDepth {
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
        System.out.println("\n\nMax Depth of the tree is: ");
        System.out.println(maxDepth(tree.getRoot()));
    }

    public static int maxDepth(TreeNode A) {

        if(A==null)
            return 0;

        return
                1+ Math.min(maxDepth(A.left),maxDepth(A.right));
    }
}


/**
 *
 * https://www.interviewbit.com/problems/max-depth-of-binary-tree/
 *
 * Refer Evernote for theory
 *
 * https://www.youtube.com/watch?v=_pnqMz5nrRs
 *
 */
