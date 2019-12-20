package Trees;

/**
 * @author jakadam on 2019-12-20
 */

/**
 * Find the lowest common ancestor in an unordered binary tree given two values in the tree.
 *
 *  Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph
 *  (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.
 * Example :
 *
 *
 *         _______3______
 *        /              \
 *     ___5__          ___1__
 *    /      \        /      \
 *    6      _2_     0        8
 *          /   \
 *          7    4
 * For the above tree, the LCA of nodes 5 and 1 is 3.
 *
 *  LCA = Lowest common ancestor
 * Please note that LCA for nodes 5 and 4 is 5.
 *
 * You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
 * No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
 * There are no duplicate values.
 * You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.
 */
public class LowestCommonAncestor {
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

        System.out.println("\n\nLCA");

        System.out.println(lcaHelper(tree.getRoot(), 4, 5) == -1 ? "Nodes Not Found" :
                lcaHelper(tree.getRoot(), 4, 5));
        System.out.println(lcaHelper(tree.getRoot(), 2, 3) == -1 ? "Nodes Not Found" :
                lcaHelper(tree.getRoot(), 2, 3));
        System.out.println(lcaHelper(tree.getRoot(), 6, 7) == -1 ? "Nodes Not Found" :
                lcaHelper(tree.getRoot(), 6, 7));
        System.out.println(lcaHelper(tree.getRoot(), 6, 5) == -1 ? "Nodes Not Found" :
                lcaHelper(tree.getRoot(), 6, 5));

    }

    public static int lcaHelper(TreeNode root, int n1, int n2) {
        // There is a possibility that both nodes are not present in the tree
        // Make sure both node exist by doing a DFS for each node
        // instead of calling DFS 2 times, you can populate node list and one call and check
        // the list for both nodes

        boolean n1Exists = dfs(root, n1);
        boolean n2Exists = dfs(root, n2);

        if (n1Exists && n2Exists) {

            TreeNode node = lca(root, n1, n2);
            if (node == null)
                return -1;
            else
                return node.val;
        } else// nodes not present in the tree
            return -1;

    }

    public static TreeNode lca(TreeNode root, int A, int B) {

        /**
         * Algorithms covers a list of possibilities that can occur at the current node
         * 1. node is null, return null as we have reached leaf node and did not find what we were looking for
         * 2. node is either A or B, return node to calling node, indicating one of the nodes have been discovered
         * 3. if 1 and 2 are not the cases, we need to call the child nodes and ask them to see if they can find A and B
         *    calling child nodes recursively, following cases can occur at the calling node
         * 4. node receives null values from both the children, indicating both did not find A and B, return null
         * 5. node receives non-null from both the children, indicating both A and B were found and current node is the LCA
         *      return node,
         * 6. node receives not-null from one of the nodes, indicating only one of the A and B has been found, indicates this
         *      node is not the LCA, return the child node which returned not-null
         */

        if (root == null)
            return null;

        if (root.val == A || root.val == B)
            return root;

        TreeNode leftSearch = lca(root.left, A, B);
        TreeNode rightSearch = lca(root.right, A, B);

        if (leftSearch == null && rightSearch == null)
            return null;

        if (leftSearch != null && rightSearch != null)
            return root;

        if (leftSearch != null)
            return leftSearch;
        else
            return rightSearch;

    }

    public static boolean dfs(TreeNode root, int key) {
        //implementing preOrder traversal for search

        if (root == null)
            return false;
        if (root.val == key)
            return true;


        return dfs(root.left, key) || dfs(root.right, key);

    }
}
/**
 * https://www.interviewbit.com/problems/least-common-ancestor/
 * https://www.youtube.com/watch?v=NBcqBddFbZw
 *
 * Best Explainations
 * LCA-https://www.youtube.com/watch?v=13m9ZCB8gjw
 *
 * DFS-https://www.geeksforgeeks.org/search-a-node-in-binary-tree/
 *
 */