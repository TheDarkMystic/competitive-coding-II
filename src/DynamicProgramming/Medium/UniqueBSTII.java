package DynamicProgramming.Medium;

/**
 * @author jakadam on 2019-12-31
 */

/**
 * Given an integer A, how many structurally unique BST’s (binary search trees) exist that
 * can store values 1…A?
 *
 * Input Format:
 *
 * The first and the only argument of input contains the integer, A.
 * Output Format:
 *
 * Return an integer, representing the answer asked in problem statement.
 * Constraints:
 *
 * 1 <= A <= 18
 * Example:
 *
 * Input 1:
 *     A = 3
 *
 * Output 1:
 *     5
 *
 * Explanation 1:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */


/**
 * Intuition:
 * First note that dp[k] represents the number of BST trees built from 1....k;
 *
 * Then assume we have the number of the first 4 trees: dp[1] = 1 ,dp[2] =2 ,dp[3] = 5, dp[4] =14 ,
 * how do we get dp[5] based on these four numbers is the core problem here.
 *
 * The essential process is: to build a tree, we need to pick a root node, then we need
 * to know how many possible left sub trees and right sub trees can be held under that node,
 * finally multiply them.
 *
 * To build a tree contains {1,2,3,4,5}. First we pick 1 as root, for the left sub tree, there
 * are none; for the right sub tree, we need count how many possible trees are there constructed
 * from {2,3,4,5}, apparently it's the same number as {1,2,3,4}. So the total number of trees
 * under "1" picked as root is dp[0] * dp[4] = 14. (assume dp[0] =1). Similarly, root 2 has
 * dp[1]*dp[3] = 5 trees. root 3 has dp[2]*dp[2] = 4, root 4 has dp[3]*dp[1]= 5 and root 5
 * has dp[0]*dp[4] = 14. Finally sum the up and it's done.
 *
 * Now, we may have a better understanding of the dp[k], which essentially represents the number
 * of BST trees with k consecutive nodes. It is used as database when we need to know how many
 * left sub trees are possible for k nodes when picking (k+1) as root.
 *
 * https://youtu.be/GgP75HAvrlY
 */
public class UniqueBSTII {
    public static void main(String[] args) {
        System.out.println(countUniqueBST(3));
    }

    public static int countUniqueBST(int n) {
        int[] dp = new int[n + 1];
        // with 0 nodes we can create 0 unique BSTs
        dp[0] = 1;

        // with 1 nodes we can create 1 unique BSTs
        dp[1] = 1;

        //for n nodes
        for (int i = 2; i <= n; i++) {
            // for each i in the range [2..n] we try to fix each node as root and try to calculate how
            // many BSTs we can come up with
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
