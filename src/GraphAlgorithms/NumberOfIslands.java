package GraphAlgorithms;

/**
 * @author jakadam on 2020-01-01
 */

/**
 * Given a 2d grid map of ‘1’s (land) and ‘0’s (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * Assume all four edges of the grid are all surrounded by water. Given such a grid, write an algorithm to
 * find the number of islands in it.
 */

/**
 * Approach:
 *
 * Use Depth-First Search
 *
 * If all the nodes in the grid are connected then after DFS all the nodes will be visited and there will be
 * only one Island in the grid. If there are more islands in the grid we need to multiple DFS to visit them all.
 * So Number of Islands will be equal to the number of DFS required to visit all isLands (1’s)
 *
 * Start the DFS from the node with value 1 and try all four directions (right, left, up and down) to find any
 * connected 1’s. Once DFS is completed, check if there is an unvisited node with value 1 exists in the given
 * grid, if yes then start another DFS from that node. Keep counting no of DFS’s, this will be our answer-
 * Number of Islands.
 */
public class NumberOfIslands {
    public static void dfs(char[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        int numOfIslands=0;

        for(int i=0; i<numRows; i++){
            for(int j=0; j<numCols;j++){
                if(grid[i][j]=='1'){
                    dfsUtil(grid, i,j);
                    numOfIslands++;
                }
            }
        }

        System.out.println(numOfIslands);

    }
    public static void dfsUtil(char[][] grid, int row, int col) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        if(row<0 || row>=numRows || col<0 || col>=numCols || grid[row][col]=='0')
            return;
        grid[row][col]='0';
        dfsUtil(grid, row+1,col);
        dfsUtil(grid, row-1,col);
        dfsUtil(grid, row,col+1);
        dfsUtil(grid, row,col-1);

    }

    public static void main(String[] args) {

        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        dfs(grid);

        grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        dfs(grid);
    }
}

/**
 * https://algorithms.tutorialhorizon.com/number-of-islands/
 */