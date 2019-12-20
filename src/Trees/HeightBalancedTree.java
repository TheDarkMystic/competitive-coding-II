package Trees;

/**
 * @author jakadam on 2019-12-21
 */

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 *  Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every
 *  node never differ by more than 1.
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 *
 * Example :
 *
 * Input :
 *           1
 *          / \
 *         2   3
 *
 * Return : True or 1
 *
 * Input 2 :
 *          3
 *         /
 *        2
 *       /
 *      1
 *
 * Return : False or 0
 *          Because for the root node, left subtree has depth 2 and right subtree has depth 0.
 *          Difference = 2 > 1.
 */
public class HeightBalancedTree {
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

        /*

         A tree is called height balanced, when the diff between the heights of its
         both subtrees is <=1.
         Also, this property should hold for all its nodes.

         HeightBalanced Tree property
         Math.abs(leftSubTreeHeight - rightSubTreeHeight)<=1

        */
        BinaryTree tree = new BinaryTree();
        System.out.println("\n\nHeight Balanced Tree: ");
        System.out.println(checkBalance(tree.getRoot()));
    }

    public static int checkBalance(TreeNode root) {
        // null tree is balanced
        if(root==null)
            return 1;

        //calculate heights of subtrees
        int leftHeight=maxDepth(root.left);
        int rightHeight=maxDepth(root.right);

        //if tree rooted at current node is balanced, check if both its subtrees are balanced or not
        if(Math.abs(leftHeight-rightHeight)<=1)
            return (checkBalance(root.left) & checkBalance(root.right));
                    //& is a bitwise operator hence returns 0/1

        return 0;


    }

    /**
     * calculates height of the tree
     * height of tree==max depth of the tree
     *
     * This function is reused from MaxDepth.java
     *
     * @param A
     * @return
     */
    public static int maxDepth(TreeNode A) {

        if(A==null)
            return 0;

        return (1+ Math.min(maxDepth(A.left),maxDepth(A.right)));
    }
}
/**
 * Tested on InterviewBit
 * https://www.interviewbit.com/problems/balanced-binary-tree/
 *
 * https://www.youtube.com/watch?v=TWDigbwxuB4
 */
