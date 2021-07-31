package Trees;

/**
 * @author jakadam on 2020-01-24
 */


/**
 * A binary search tree (BST) is a node based binary tree data structure which has the following
 *  properties.
 * • The left subtree of a node contains only nodes with keys less than the node’s key.
 * • The right subtree of a node contains only nodes with keys greater than the node’s key.
 * • Both the left and right subtrees must also be binary search trees.
 *
 * From the above properties it naturally follows that:
 * • Each node (item in the tree) has a distinct key.
 *
 */


//Java implementation to check if given Binary tree
//is a BST or not

/* Class containing left and right child of current
node and key value*/
class Node
{
    int data;
    Node left, right;

    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class IsBST
{
    //Root of the Binary Tree
    Node root;

	/* can give min and max value according to your code or
	can write a function to find min and max value of tree. */

    /* returns true if given search tree is binary
    search tree (efficient version) */
    boolean isBST() {
        return isBSTUtil(root, Integer.MIN_VALUE,
                Integer.MAX_VALUE);
    }

    /* Returns true if the given tree is a BST and its
    values are >= min and <= max. */
    boolean isBSTUtil(Node node, int min, int max)
    {
        /* an empty tree is BST */
        if (node == null)
            return true;

        /* false if this node violates the min/max constraints */
        if (node.data < min || node.data > max)
            return false;

		/* otherwise check the subtrees recursively
		tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.data-1) &&
                isBSTUtil(node.right, node.data+1, max));
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        IsBST tree = new IsBST();

        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);


        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}
/**
 IS BST
 Time Complexity: O(n)
 Auxiliary Space : O(1) if Function Call Stack size is not considered, otherwise O(n)
 */


//Inorder traversal of a BST returns sorted list,, using that property to check if the tree is BST or not

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*
class Solution {
    List<Integer> inorder = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {

        Stack<TreeNode> stack= new Stack<>();
        double inorder=-Double.MAX_VALUE;
        while(root!=null || stack.isEmpty()==false){
            while(root!=null){
                stack.push(root);
                root=root.left;

            }
            root=stack.pop();
            if(inorder>=root.val) return false;
            inorder=root.val;
            root=root.right;
        }
        return true;
    }

    public boolean isSorted(List<Integer> list){
        int prev=Integer.MIN_VALUE;
        for(int i=0; i<list.size(); i++){
            if(list.get(i)<prev)
                return false;

        }

        return true;
    }
}

// first solution runs into boundry problems, hence alternate approach to avoid Int, double, long  max min hardcoding
class Solution {
    public boolean isValidBST(TreeNode root) {
       return helper(root, null, null);
    }

    public boolean helper(TreeNode node, Integer min, Integer max){
        if(node==null)
            return true;
        if((min!=null && node.val<min) || (max!=null && node.val>max)) return false;

        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }
}

*/