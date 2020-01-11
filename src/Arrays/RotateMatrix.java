package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jakadam on 2020-01-11
 */

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * You need to do this in place.
 *
 * Note that if you end up using an additional array, you will only
 * receive partial score.
 *
 * Example:
 *
 * If the array is
 *
 * [
 *     [1, 2],
 *     [3, 4]
 * ]
 * Then the rotated array becomes:
 *
 * [
 *     [3, 1],
 *     [4, 2]
 * ]
 */
public class RotateMatrix {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,2,3)));
        A.add(new ArrayList<>(Arrays.asList(4,5,6)));
        A.add(new ArrayList<>(Arrays.asList(7,8,9)));
        rotate(A);


        System.out.println(Arrays.toString(A.toArray()));

    }
    public static void rotate(ArrayList<ArrayList<Integer>> A){
    /*
        The idea was firstly transpose the matrix and then flip it symmetrically. For instance,

        1  2  3
        4  5  6
        7  8  9
        after transpose, it will be swap(matrix[i][j], matrix[j][i])

        1  4  7
        2  5  8
        3  6  9
        Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])

        7  4  1
        8  5  2
        9  6  3

        */
        //step1: transpose the matrix
        int numRows= A.size();
        int numCols= A.get(0).size();

        for(int i=0; i<numRows; i++){
            for(int j=0; j<i; j++){ //note breaking condition
                int temp=A.get(i).get(j);
                A.get(i).set(j, A.get(j).get(i));
                A.get(j).set(i,temp);
            }
        }

        //System.out.println(Arrays.toString(A.toArray()));
        //step2: swap the columns (last to first)

        for(int i=0; i<numRows; i++){
            for(int j=0; j<numCols/2;j++){ //note breaking condition
                int temp=A.get(i).get(j);
                A.get(i).set(j, A.get(i).get(numCols-1-j));
                A.get(i).set(numCols-1-j, temp);
            }
        }

        //System.out.println(Arrays.toString(A.toArray()));
    }
}

