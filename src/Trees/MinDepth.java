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

            // min depth is is the distance of the root node to nearest leaf node
            // so the task boils down to finding the nearest leaf node
            // 1. using DFS
            //check if root is null
            if(root==null)
                return 0;
            // check if root is leaf node, return 1, as depth of leaf node is 1
            if(root.left==null && root.right==null)
                return 1;

            //if left subtree is null, explore right subtree for nearest leaf node
            if(root.left==null)
                return 1+minDepth(root.right);
            //if right subtree is null, explore left subtree for nearest leaf node
            if(root.right==null)
                return 1+minDepth(root.left);
            // if both subtrees are not null, return minimum of both the subtree depths
            return 1+Math.min(minDepth(root.left),minDepth(root.right));

            // 2. using BSF, use level order traversal and explore nodes levelwise,
            // stop as soon as we find leaf node, return the level number
    }
}


/**
 * https://www.interviewbit.com/problems/min-depth-of-binary-tree/
 * https://www.youtube.com/watch?v=hmWhJyz5kqc
 * Refer Evernote for theory
 */
