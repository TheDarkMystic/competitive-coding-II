package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jakadam on 2019-12-20



public class PreOrderTraversal {
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
        System.out.println("PreorderRecursive");
        preorderIterative(tree.getRoot());
        System.out.println("\n\nPreorderRecursive");
        preorderRecursive(tree.getRoot());
    }

    public static void preorderIterative(TreeNode A) {
        // Always Imagine a simple 3 node tree for any kind of tree problem.
        // Process root, left and right in required order.



        /*
        -   Recursive Solution uses System stack. For Iterative solution we need to
            define stack explicitly.
        -   Recursive solution may cause overflow. Iterative will Not.
        -   Always ask what is the type of data store in aTree Node. int/ string etc.
        -   Notice we are storing entire TreeNode in the stack and only val in the result list.
            TreeNode has data, left and right pointers.

        TreeNode cur = A;
        Stack<TreeNode> stack = new Stack<>();

        stack.push(cur);

        while(stack.isEmpty()==false){
             /*
            section 1- Process root .

            cur=stack.pop();
            System.out.print(cur.val+" ");

            /* section 2- Process Right Subtree. We are pushing right node before left node because
               Stack is LIFO so while popping we will get left first and will be printed first.

            if(cur.right!=null)
                stack.push(cur.right);

             section 2- Process Left Subtree.
            if(cur.left!=null)
                stack.push(cur.left);

        }
        System.out.println();


    }

    public static void preorderRecursive(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preorderRecursive(root.left);
        preorderRecursive(root.right);
    }

}
/*
https://www.interviewbit.com/problems/preorder-traversal/
https://www.youtube.com/watch?v=gm8DUJJhmY4&list=PL2_aWCzGMAwI3W_JlcBbtYTwiQSsOTa6P&index=35&t=0s

https://leetcode.com/problems/binary-tree-postorder-traversal/#/solutions

https://discuss.leetcode.com/topic/6478/iterative-solution-in-java-simple-and-readable


https://www.youtube.com/watch?v=elQcrJrfObg
 */

//https://leetcode.com/problems/binary-tree-preorder-traversal/submissions/

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
class PreOrderTraversal {
    /*
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrd= new LinkedList<>();
        Stack<TreeNode> stack= new Stack<>();

        if(root==null)
            return preOrd;

        stack.push(root);
        while(stack.isEmpty()==false){
            TreeNode node = stack.pop();
            preOrd.add(node.val);
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }

        return preOrd;
    }
    */
    List<Integer> inOrd= new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {

        helper(inOrd,root);
        return inOrd;
    }

    public void helper(List<Integer> list, TreeNode root) {
        if(root!=null){
            inOrd.add(root.val);
            helper(inOrd,root.left);
            helper(inOrd,root.right);
        }
    }
}