package Trees;

/**
 * @author jakadam on 2019-12-20
 */

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * Example :
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * The above binary tree is symmetric.
 * But the following is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */


public class SymmetricalTree {

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

        System.out.println("\n\nIdentical Tree");
        System.out.println(isSymmetric(tree.getRoot()));
        System.out.println(isSymmetric(null));
    }
    public static int isSymmetric(TreeNode A) {

        // null tree is symmetrical
        if(A==null)
            return 1;

        return checkSym(A.left, A.right);
    }

    /**
     * This function is very similar to IdenticalBinaryTrees.isSameTree(TreeNode A, TreeNode B)
     */
    public static int checkSym(TreeNode n1, TreeNode n2){
        //both trees are null and hence symmetrical
        if(n1==null && n2==null)
            return 1;

        //one of the tree is null and hence trees are non-sym
        if(n1==null || n2==null){
            return 0;
        }

        // check root values or not
        if(n1.val == n2.val){

            // check for symmetry of subtrees
            if(checkSym(n1.left,n2.right)==1 &&
                    checkSym(n1.right,n2.left)==1)
                return 1;
        }

        return 0;
    }
}

/**
 https://www.youtube.com/watch?v=XV7Sg2hJO3Q

 https://www.youtube.com/watch?v=8t4KCaDB108

 https://www.youtube.com/watch?v=9jH2L2Ysxko

*/