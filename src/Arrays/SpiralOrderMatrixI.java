package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jakadam on 2020-01-31
 */

/**
 * Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example:
 *
 * Given the following matrix:
 *
 * [
 *     [ 1, 2, 3 ],
 *     [ 4, 5, 6 ],
 *     [ 7, 8, 9 ]
 * ]
 * You should return
 *
 * [1, 2, 3, 6, 9, 8, 7, 4, 5]
 * Problem Approach :
 */


public class SpiralOrderMatrixI {
    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        //ArrayList<Integer> result = new ArrayList<Integer>();
        int rows=a.size(),
                cols=a.get(0).size();
        int[][] matrix= new int[rows][cols];
        ArrayList<Integer> sol= new ArrayList<Integer>();

        //convert ArrayList to Array
        for(int i=0; i<rows;i++)
            for(int j=0;j<cols; j++)
                matrix[i][j]=a.get(i).get(j);

        //define boundaries
        int top=0,

                bottom=rows-1,
                left=0,
                right=cols-1,
                dir=0;

        //traversal
        while(top<=bottom && left<=right){
            if(dir==0){//left->right
                for(int i=left; i<=right;i++){
                    sol.add(matrix[top][i]);
                }
                top++;
                dir=1;

            }else if(dir==1){//top->bottom
                for(int i=top; i<=bottom;i++){
                    sol.add(matrix[i][right]);
                }
                right--;
                dir=2;
            }else if(dir==2){//right->left
                for(int i=right; i>=left;i--){
                    sol.add(matrix[bottom][i]);
                }
                bottom--;
                dir=3;
            }else if(dir==3){//bottom->top
                for(int i=bottom; i>=top;i--){
                    sol.add(matrix[i][left]);
                }
                left++;
                dir=0;
            }

        }

        // Populate result;
        return sol;
    }
}