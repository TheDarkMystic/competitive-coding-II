package Trees;

/**
 * @author jakadam on 2019-12-20
 */

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * <p>
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * <p>
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * <p>
 * Example :
 * <p>
 * Input :
 * <p>
 * 1       1
 * / \     / \
 * 2   3   2   3
 * <p>
 * Output :
 * 1 or True
 */
public class IdenticalBinaryTrees {
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
        System.out.println(isSameTree(tree.getRoot(), tree.getRoot()));
        System.out.println(isSameTree(tree.getRoot(), null));

    }

    public static boolean isSameTree(TreeNode A, TreeNode B) {
        /**
         * At the given nodes following cases can arise
         * 1. both nodes are null and hence equal, return true
         * 2. both nodes have equal val, in this case we need to recurse and see
         *      if left and right subtrees are equal or not
         *
         *
         */

        // null trees are identical
        if (A == null && B == null)
            return true;
        else if (A != null && B != null) {// if both nodes are not null-> avoids nullPointerException

            if (A.val == B.val)
                return isSameTree(A.left, B.left) && isSameTree(A.right, B.right);
        }
        return false;
    }
}


/**
 * https://www.interviewbit.com/problems/identical-binary-trees/
 * https://www.youtube.com/watch?v=kL5Gs1YTwMM
 */

