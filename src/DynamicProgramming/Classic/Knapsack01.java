package DynamicProgramming.Classic;

/**
 * @author jakadam on 2019-12-17
 */

/**
 * https://www.interviewbit.com/problems/0-1-knapsack/
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two
 * subsets such that the sum of elements in both subsets is equal.
 *
 * Note:
 *
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 *
 *
 * Example 1:
 *
 * Input: [1, 5, 11, 5]
 *
 * Output: true
 *
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 *
 * Example 2:
 *
 * Input: [1, 2, 3, 5]
 *
 * Output: false
 *
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class Knapsack01 {
    public static void main(String args[]) {
        Knapsack01Solver solver = new Knapsack01Solver();
        int val[] = {22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
        int wt[] = {4, 2, 3, 5, 5, 6, 9, 7, 8, 10};

        int r = solver.solveBottomUpDP(val, wt, 30);
        //int r1 = solver.topDownRecursive(val, wt, 30);

        System.out.println(r);
        //System.out.println(r1);
    }
}

class Knapsack01Solver {
    public int solveBottomUpDP(int[] A, int[] B, int C) {
        int valLen=A.length;
        int wtLen=B.length;
        int bagSize=C;

        int dp[][] = new int[valLen+1][bagSize+1];

        for(int i=1; i<wtLen+1; i++){
            for(int j=1; j<bagSize+1; j++){
                //wt is greater than the bagSize,, exclude the weight
                if(B[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-B[i-1]]+A[i-1]);
                }
            }
        }

        return dp[valLen][bagSize];

    }
}
