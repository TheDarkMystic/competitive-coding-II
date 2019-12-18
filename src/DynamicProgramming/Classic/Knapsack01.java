package DynamicProgramming.Classic;

/**
 * @author jakadam on 2019-12-17
 */

/**
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
        int r1 = solver.topDownRecursive(val, wt, 30);

        System.out.println(r);
        System.out.println(r1);
    }
}

class Knapsack01Solver {
    public int solveBottomUpDP(int val[], int itemWt[], int knapSackSize) {
        int itemWtLength = itemWt.length;


        //we take wts of the items on Y axis and knapsack sizes on X axis,
        // for populating the dp table, we do a lookup on val array for corresponding item
        // to get its value
        int dp[][] = new int[itemWtLength + 1][knapSackSize + 1];

        //if knapsack size is zero, no item can be fit into the bag, hence the entire col
        //will become 0, also when we have only one item of weight 0, hence 0th row will be entirely 0.

        // at any given point we will have 2 choices, to add the item to bag or not to add it
        // if we add it lookup(row wise) the value obtained by adding item with weight equal to remaining capacity
        //else just lookup(column wise) the max value obtained adding itema excluding current item

        for (int itemNo = 0; itemNo <= itemWtLength; itemNo++) {
            for (int bagSize = 0; bagSize <= knapSackSize; bagSize++) {
                if (itemNo == 0 || bagSize == 0)
                    continue;

                if (bagSize - itemWt[itemNo - 1] >= 0)
                    dp[itemNo][bagSize] = dp[itemNo][bagSize - itemWt[itemNo - 1]] + val[itemNo - 1];
                else
                    dp[itemNo][bagSize] = dp[itemNo - 1][bagSize];
            }
        }


        return dp[itemWtLength][knapSackSize];
    }

    public int topDownRecursive(int val[], int wt[], int knapSackSize) {
        https:
//www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
        return 0;
    }
}