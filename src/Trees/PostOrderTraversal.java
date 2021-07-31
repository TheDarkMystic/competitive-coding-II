package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jakadam on 2019-12-20
 */

/*



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

}*/
/**
 https://leetcode.com/problems/binary-tree-postorder-traversal/#/solutions

 https://discuss.leetcode.com/topic/6478/iterative-solution-in-java-simple-and-readable

 http://www.java67.com/2015/01/how-to-reverse-arraylist-in-java-with.html

 https://leetcode.com/problems/binary-tree-postorder-traversal/#/solutions


 using 2 stacks(easy)
 https://www.youtube.com/watch?v=G7tvjUGMBJ4
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class PostOrderTraversal {
    /*
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrd= new ArrayList<Integer>();

        if(root==null)
            return postOrd;

        Stack<TreeNode>stack= new Stack<>();
        stack.push(root);
        while(stack.isEmpty()==false){
            TreeNode node=stack.pop();
            postOrd.add(0, node.val);
            if(node.left!=null) stack.push(node.left);
            if(node.right!=null)stack.push(node.right);

        }


        return postOrd;
    }
    */

    // recursive
    List<Integer> inOrd= new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {

        helper(inOrd,root);
        return inOrd;
    }

    public void helper(List<Integer> list, TreeNode root) {
        if(root!=null){
            helper(inOrd,root.left);
            helper(inOrd,root.right);
            inOrd.add(root.val);
        }
    }
}