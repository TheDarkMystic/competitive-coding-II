package Trees;

/**
 * @author jakadam on 2019-12-21
 */
public class DiameterOfBinaryTree {

    //solution based on the approach given in the video https://www.youtube.com/watch?v=ey7DYc9OANo&t=872s

    /**
     * this solution is intuitive but the performance is not good because of the overlapping subproblems when calculate depth.
     *
     * diameterOfBinaryTree is called on every node. In each call, it traverses all descendants of that node to get the depth.
     *
     * for root node, it is n => n + 1 - 2^0
     * for all nodes on 2nd level, it is 2 * (n - 1) / 2 => n - 1 => n + 1 - 2^1
     * for all nodes on 3rd level, it is 4 * (n - 3) / 4 => n - 3 => n + 1 - 2^2
     * for all nodes on 4th level, it is 8 * (n - 7) / 8 => n - 7 => n + 1 - 2^3
     * ...
     * for all nodes on last level, it is n + 1 - 2^(h-1). h is max tree depth.
     * Add them up, the result is (n+1) * h - (1 + 2 + 4 ... + 2^(h-1)). In worst case, the latter part is n (all nodes in the tree),
     * so time complexity is O(n*logn).
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int dia = depth(root.left) + depth(root.right);
        int ldia = diameterOfBinaryTree(root.left);
        int rdia = diameterOfBinaryTree(root.right);
        return Math.max(dia, Math.max(ldia, rdia));

    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}


/**
 * https://leetcode.com/problems/diameter-of-binary-tree/discuss/101132/Java-Solution-MaxDepth
 *
 * The longest path doesn't have to go through the root node, it has to pass the root node of
 * some subtree of the tree (because it has to be from one leaf node to another leaf node,
 * otherwise we can extend it for free). The longest path that passes a given node as the
 * ROOT node is T = left_height+right_height. So you just calculate T for all nodes
 * and output the max T.
 */
class EfficientSolution {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);

        //return the max of the subtree heights + 1 (for root Node)
        return Math.max(left, right) + 1;
    }
}


/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * https://www.youtube.com/watch?v=ey7DYc9OANo&t=872s
 **
 */