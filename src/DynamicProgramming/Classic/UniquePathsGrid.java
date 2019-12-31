package DynamicProgramming.Classic;

/**
 * @author jakadam on 2019-12-31
 */

/**
 * A robot is located at the top-left corner of an A x B grid (marked ‘Start’ in the diagram below).
 *
 * Path Sum: Example 1
 *
 * The robot can only move either down or right at any point in time. The robot is trying to
 * reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.
 *
 * Example :
 *
 * Input : A = 2, B = 2
 * Output : 2
 *
 * 2 possible routes : (0, 0) -> (0, 1) -> (1, 1)
 *               OR  : (0, 0) -> (1, 0) -> (1, 1)
 *
 * https://www.youtube.com/watch?v=6qMFjFC9YSc&list=PLlxS_AS24uwUp_K3SYKncT4QH8zYH-hiJ&index=2&t=0s
 */
public class UniquePathsGrid {
    public int uniquePaths(int a, int b) {
        int dp[][] = new int[a][b];

        //init 1st col
        for (int i = 0; i < a; i++)
            dp[i][0] = 1;

        //init 1st row
        for (int i = 0; i < b; i++)
            dp[0][i] = 1;

        for (int i = 1; i < a; i++) {
            for (int j = 1; j < b; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }


        return dp[a - 1][b - 1];
    }
}
