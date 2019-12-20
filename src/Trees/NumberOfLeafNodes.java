package Trees;

/**
 * @author jakadam on 2019-12-21
 */
public class NumberOfLeafNodes {
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
        System.out.println("\n\nLeaf Node Count: ");
        System.out.println(countLeafNodes(tree.getRoot()));
    }

    public static int countLeafNodes(TreeNode A){
        // leaf node is a node which has node.left==null and node.right==null

        // null tree has no leaf nodes
        if(A==null)
            return 0;

        // leaf node found
        if(A.left==null && A.right==null)
            return 1;

        //recurse for left and right subtrees
        return countLeafNodes(A.left)+countLeafNodes(A.right);
    }
}


/**
 * https://www.youtube.com/watch?v=PArGIFNfIDk
 * https://www.geeksforgeeks.org/write-a-c-program-to-get-count-of-leaf-nodes-in-a-binary-tree/
 */