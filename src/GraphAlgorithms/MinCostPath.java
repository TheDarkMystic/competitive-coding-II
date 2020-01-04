package GraphAlgorithms;

/**
 * @author jakadam on 2020-01-02
 */
public class MinCostPath {

    /**
     * 1) Optimal Substructure
     * The path to reach (m, n) must be through one of the 3 cells: (m-1, n-1) or (m-1, n) or (m, n-1).
     * So minimum cost to reach (m, n) can be written as “minimum of the 3 cells plus cost[m][n]”.
     *
     * minCost(m, n) = min (minCost(m-1, n-1), minCost(m-1, n), minCost(m, n-1)) + cost[m][n]
     *
     * 2) Overlapping Subproblems
     * Following is simple recursive implementation of the MCP (Minimum Cost Path) problem.
     * The implementation simply follows the recursive structure mentioned above.
     * Without memoization recursive approach:
     * Since at every cell we have 3 options the time complexity will O(n^3).
     *
     * Where as DP solution is O(n^2)
     *
     * @param grid
     */
    public static void minCost(int[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        int dp[][] = new int[numRows][numCols];

        dp[0][0]=grid[0][0];
        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                if(i==0 && j==0)
                    continue;
                if (i == 0)
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                else if (j == 0)
                    dp[i][j] = dp[i - 1][j] + grid[i][j ];
                else
                    dp[i][j] = grid[i][j] + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),dp[i - 1][j-1]);


            }
        }

        System.out.println("Minimum Cost Path "+ dp[numRows-1][numCols-1]);

    }


    public static void main(String[] args) {
        int[][] A = {{1, 7, 9, 2}, {8, 6, 3, 2}, {1, 6, 7, 8},
                {2, 9, 8, 2}};

        minCost(A);


        int[][] B = { {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} };
        minCost(B);
    }
}

/**
 * https://www.geeksforgeeks.org/min-cost-path-dp-6/
 *https://algorithms.tutorialhorizon.com/dynamic-programming-minimum-cost-path-problem/
 */