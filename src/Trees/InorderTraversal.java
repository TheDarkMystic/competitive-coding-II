package Trees;

import java.util.Stack;

/**
 * @author jakadam on 2019-12-20
 */
public class InorderTraversal {
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
        System.out.println("InorderIterative");
        inorderIterative(tree.getRoot());
        System.out.println("\n\nInorderRecursive");
        inorderRecursive(tree.getRoot());
    }

    public static void inorderIterative(TreeNode A) {
        // Always Imagine a simple 3 node tree for any kind of tree problem.
        // Process left, root and right in required order.


        TreeNode cur = A;
        Stack<TreeNode> stack = new Stack<>();
        /*
        -   Recursive Solution uses System stack. For Iterative solution we need to
            define stack explicitly.
        -   Recursive solution may cause overflow. Iterative will Not.
        -   Always ask what is the type of data store in Tree Node. int/ string etc.
        -   Notice we are storing entire TreeNode in the stack and only val in the result list.
            TreeNode has data, left and right pointers.
        */

         /*
        -   cur!=null -> There are undiscovered Nodes in the Tree.
        -   !stack.empty() -> There exist nodes which have been discoved but not processed yet.
        */
        while (cur != null || stack.isEmpty() == false) {

             /*
            section 1- Process left subtree. Keep pushing nodes to stack until you find
            leftmost node.
            */
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            /*section 2- Process Root Node. Print the value in this case.
             */
            cur = stack.pop();
            System.out.print(cur.val + " ");
            /*Section 3- Process Right Subtree*/
            cur = cur.right;
        }

    }

    public static void inorderRecursive(TreeNode root) {
        if (root == null)
            return;

        inorderRecursive(root.left);
        System.out.print(root.val + " ");
        inorderRecursive(root.right);
    }

}
/*
https://www.interviewbit.com/problems/inorder-traversal/
https://www.youtube.com/watch?v=gm8DUJJhmY4&list=PL2_aWCzGMAwI3W_JlcBbtYTwiQSsOTa6P&index=35&t=0s
 */