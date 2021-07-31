package Arrays;

import java.util.ArrayList;

/**
 * @author jakadam on 2020-01-31
 */

/**
 * Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.
 *
 *
 *
 * Input Format:
 *
 * The first and the only argument contains an integer, A.
 * Output Format:
 *
 * Return a 2-d matrix of size A x A satisfying the spiral order.
 * Constraints:
 *
 * 1 <= A <= 1000
 * Examples:
 *
 * Input 1:
 *     A = 3
 *
 * Output 1:
 *     [   [ 1, 2, 3 ],
 *         [ 8, 9, 4 ],
 *         [ 7, 6, 5 ]   ]
 *
 * Input 2:
 *     4
 *
 * Output 2:
 *     [   [1, 2, 3, 4],
 *         [12, 13, 14, 5],
 *         [11, 16, 15, 6],
 *         [10, 9, 8, 7]   ]
 */

public class SpiralOrderMatrixII {
    public ArrayList<ArrayList<Integer>> generateMatrix(int n) {
        int mat[][] = new int[n][n];
        int top=0;
        int bottom=n-1;
        int right=n-1;
        int left=0;
        int dir=0;
        int counter=1;
        while(top<=bottom && left<=right){

            if(dir==0){
                for(int i=left; i<=right; i++){
                    mat[top][i]=counter++;
                }
                top++;
                dir=1;
            }
            else if(dir==1){
                for(int i=top; i<=bottom; i++){
                    mat[i][right]=counter++;
                }
                right--;
                dir=2;
            }
            else if(dir==2){
                for(int i=right; i>=left; i--){
                    mat[bottom][i]=counter++;
                }
                bottom--;
                dir=3;
            }
            else if(dir==3){
                for(int i=bottom; i>=top; i--){
                    mat[i][left]=counter++;
                }
                left++;
                dir=0;
            }
        }


        ArrayList<ArrayList<Integer>> sol= new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++){
            sol.add(new ArrayList<Integer>());
            for(int j=0; j<n;j++){
                sol.get(i).add(mat[i][j]);
            }
        }


        return sol;

    }
}

/*
https://www.interviewbit.com/problems/spiral-order-matrix-ii/
 */