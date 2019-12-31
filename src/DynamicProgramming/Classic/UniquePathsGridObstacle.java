package DynamicProgramming.Classic;

import java.util.ArrayList;

/**
 * @author jakadam on 2019-12-31
 */

/**
 * Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to
 * reach (m,n). At any instance, if you are on (x,y), you can either go to (x, y + 1) or
 * (x + 1, y).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Example :
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 *
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * The total number of unique paths is 2.
 *
 *  Note: m and n will be at most 100.
 */
public class UniquePathsGridObstacle {

    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {

        int rowNum = A.size();
        int colNum = A.get(0).size();

        int[][] dp = new int[rowNum][colNum];

        for (int i = 0; i < colNum; i++) {
            //First row, once obstacle found, the rest are blocked.
            if (A.get(0).get(i) == 1) {
                dp[0][i] = 0;
                break;
            } else dp[0][i] = 1;
        }

        for (int i = 0; i < rowNum; i++) {
            //on the first column, if there is an obstacle, the rest are blocked.
            //no need to continue.
            if (A.get(i).get(0) == 1) {
                dp[i][0] = 0;
                break;
            } else dp[i][0] = 1;
        }


        for (int i = 1; i < rowNum; i++) {
            for (int j = 1; j < colNum; j++) {
                if (A.get(i).get(j) == 1) {
                    dp[i][j] = 0;
                } else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[rowNum - 1][colNum - 1];

    }
}
/**
 * Optional
 * easy version...just add one if condition
 *
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/NumberOfPathsInMxNMatrix.java
 *
 * https://www.youtube.com/watch?v=GO5QHC_BmvM
 *
 *
 * preprocessing comes from here
 * https://discuss.leetcode.com/topic/4325/my-c-dp-solution-very-simple
 */