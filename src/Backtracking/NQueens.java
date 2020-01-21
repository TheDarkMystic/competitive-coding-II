package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * @author jakadam on 2020-01-21
 */

public class NQueens {
    public ArrayList<ArrayList<String>> solveNQueens(int a) {

        int n= a;
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        ArrayList<String> tempBoard = new ArrayList<String>();

        if(n==1) {
            tempBoard.add("Q");
            res.add(tempBoard);
            return res;

        }


        int rowNum=0;
        //refer notebook for explanation
        boolean[] cols= new boolean[n];
        boolean[] diag45= new boolean[2*n];
        boolean[] diag135= new boolean[2*n];

        backTrack(n, res, tempBoard, rowNum,cols, diag45, diag135 );
        return res;
    }

    public static void backTrack(int n,ArrayList<ArrayList<String>> res,
                                 ArrayList<String> tempBoard,int rowNum,boolean[] cols,boolean[] diag45,
                                 boolean[] diag135){

        if(rowNum==n){
            res.add(new ArrayList<String>(tempBoard));
            return;
        }
        //for a given row rowNum, place the queen at every column and recurse for the next row position
        for(int colNum=0; colNum<n; colNum++){
            // calculate diagonal cells and col, explanation in notebook
            int id45= rowNum+colNum;
            int id135= (rowNum-colNum)+(n);

            if(!cols[colNum] && !diag45[id45] && !diag135[id135]){
                char boardRow[] = new char[n];
                Arrays.fill(boardRow,'.');
                boardRow[colNum]='Q';
                tempBoard.add(String.valueOf(boardRow));
                cols[colNum]= true;
                diag45[id45]= true;
                diag135[id135]= true;

                //recursion for next row
                backTrack(n, res, tempBoard, rowNum+1,cols, diag45, diag135 );
                //remove last row in existing board
                tempBoard.remove(tempBoard.size()-1);
                //reset safety vars for removed row
                cols[colNum]= false;
                diag45[id45]= false;
                diag135[id135]= false;

            }
        }


    }
}

/*
https://www.interviewbit.com/problems/nqueens/
https://leetcode.com/problems/n-queens/discuss/19932/clean-back-tracking-java-solution-with-simple-explaination
1. boolean[] cols is for check if the certain column is taken.
2. I use two boolean[2*n] array to keep tracking of two diagonals.
3. for the diagonal in the \ direction (from left up corner to right down corner) the col - row will always be same e.g. (0,1), (1,2), (2,3) are on the same diagonal, the range of col - row can be (0-(n-1)) ~ ((n-1)-0), to make sure we can store the value in one array, we will add n to this, it will become to keep tracking of (col - row + n).
4. for the diagonal in the / direction (from right up corner to left down corner) the col + row will always be same e.g. (0,4), (1,3), (2,2), (3,1), (4,0) are on the same diagonal, the range of row + col can be 0 ~ (2*n-2)
*/