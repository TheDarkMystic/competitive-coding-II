package Trees;

/**
 * @author jakadam on 2019-12-20
 */

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to
 * the nearest leaf node.
 *
 *  NOTE : The path has to end on a leaf node.
 * Example :
 *
 *          1
 *         /
 *        2
 * min depth = 2.
 */
public class MinDepth {


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

        System.out.println("\n\nMinDepth");
        System.out.println(minDepth(tree.getRoot()));
    }


    public static int minDepth(TreeNode root) {
        //check if root is null
        if(root==null)
            return 0;
        // check if root is leaf node, return 1, as depth of leaf node is 1
        if(root.left==null && root.right==null)
            return 1;

        int leftMinDepth= root.left!=null ? minDepth(root.left) : Integer.MAX_VALUE;
        int rightMinDepth= root.right!=null ? minDepth(root.right) : Integer.MAX_VALUE;

        return 1+Math.min(leftMinDepth,rightMinDepth);
    }
}


/**
 * https://www.interviewbit.com/problems/min-depth-of-binary-tree/
 * https://www.youtube.com/watch?v=hmWhJyz5kqc
 * Refer Evernote for theory
 */
