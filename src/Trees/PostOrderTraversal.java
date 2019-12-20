package Trees;

import java.util.Stack;

/**
 * @author jakadam on 2019-12-20
 */



public class PostOrderTraversal {
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
        //System.out.println("PostorderRecursive");
        //postorderRecursive(tree.getRoot());
        System.out.println("\n\nPostorderRecursive");
        postorderRecursive(tree.getRoot());
    }



    public static void postorderRecursive(TreeNode root) {
        if (root == null)
            return;

        postorderRecursive(root.left);
        postorderRecursive(root.right);
        System.out.print(root.val + " ");
    }

}
/**
 https://leetcode.com/problems/binary-tree-postorder-traversal/#/solutions

 https://discuss.leetcode.com/topic/6478/iterative-solution-in-java-simple-and-readable

 http://www.java67.com/2015/01/how-to-reverse-arraylist-in-java-with.html

 https://leetcode.com/problems/binary-tree-postorder-traversal/#/solutions


 using 2 stacks(easy)
 https://www.youtube.com/watch?v=G7tvjUGMBJ4
 */