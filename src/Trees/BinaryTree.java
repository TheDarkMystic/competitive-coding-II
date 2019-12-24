package Trees;

/**
 * @author jakadam on 2019-12-20
 */


// A Java program to introduce Binary Tree
public class BinaryTree {
    // Root of Binary Tree 

    TreeNode root;
    // Constructors 
    public BinaryTree() {

        /*create root*/
        root = new TreeNode(1);

        /* following is the tree after above statement

              1
            /   \
          null  null     */

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        /* 2 and 3 become left and right children of 1
               1
             /   \
            2      5
          /    \    /  \
        null null null null  */
        root.left.right = new TreeNode(4);
        /*
                   1
                /     \
               2        5
             /   \     /  \
         null    4   null null
                  \
                 null
         */

        root.left.left = new TreeNode(3);
        /*
                   1
                /     \
               2        5
             /   \     /  \
            3    4   null null
           /  \   \
        null null null
         */
    }

    public TreeNode getRoot(){
        return root;
    }

}