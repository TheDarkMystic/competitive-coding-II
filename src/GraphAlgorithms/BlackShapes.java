package GraphAlgorithms;

/**
 * @author jakadam on 2019-12-24
 */


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given N x M character grid A of O's and X's, where O = white, X = black.
 * <p>
 * Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)
 * <p>
 * <p>
 * <p>
 * Input Format:
 * <p>
 * The First and only argument is a N x M character grid.
 * Output Format:
 * <p>
 * Return a single integer denoting number of black shapes.
 * Constraints:
 * <p>
 * 1 <= N,M <= 1000
 * A[i][j] = 'X' or 'O'
 * Example:
 * <p>
 * Input 1:
 * A = [ OOOXOOO
 * OOXXOXO
 * OXOOOXO  ]
 * Output 1:
 * 3
 * Explanation:
 * 3 shapes are  :
 * (i)    X
 * X X
 * (ii)
 * X
 * (iii)
 * X
 * X
 * Note: we are looking for connected shapes here.
 * <p>
 * XXX
 * XXX
 * XXX
 * is just one single connected black shape.
 */
public class BlackShapes {
    public static void main(String[] args) {
        /**
         *  A = [ OOOXOOO
         *        OOXXOXO
         *        OXOOOXO  ]
         */
        ArrayList<String> A = new ArrayList<>(Arrays.asList("OOOXOOO",
                "OOXXOXO",
                "OXOOOXO"));

        System.out.println(black(A));
    }

    public static int black(ArrayList<String> A) {
        // convert List of strings to 2D grid for easier indexing and grid population purpose,
        // replace X with 1 and O with 0

        int numRows = A.size();
        int numCols = A.get(0).length();

        int[][] grid = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (A.get(i).charAt(j) == 'X')
                    grid[i][j] = 1;
                else
                    grid[i][j] = 0;
            }
        }

        //for every 1 we encounter in the grid, we set it to 0 and search all it's adjacent 1's to 0 using DFS recursively
        //that marks the island and we DFS because we want to perform exhaustive search and not the optimal path
        int islandCount = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == 1) {
                    islandCount++;
                    dfs(grid, i, j, numRows, numCols);
                }
            }
        }
        return islandCount;
    }

    public static void dfs(int[][] grid, int i, int j, int numRows, int numCols) {

        //if the given point falls within the boundaries of the grid, check all it neighbours recursively and mark them as
        // 0
        if ((i >= 0 && i < numRows) && (j >= 0 && j < numCols) && grid[i][j] == 1) {

            //first mark the found island as 0, that avoids cyclical work
            grid[i][j] = 0;

            //recursively mark the neighbours
            dfs(grid, i, j + 1, numRows, numCols);
            dfs(grid, i, j - 1, numRows, numCols);
            dfs(grid, i - 1, j, numRows, numCols);
            dfs(grid, i + 1, j, numRows, numCols);
        }
    }
}
/**
 * Simple problem
 * https://discuss.leetcode.com/topic/13248/very-concise-java-ac-solution
 */