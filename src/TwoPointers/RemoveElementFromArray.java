package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jakadam on 2019-12-16
 */

/**
 * Remove Element
 *
 * Given an array and a value, remove all the instances of that value in the array.
 * Also return the number of elements left in the array after the operation.
 * It does not matter what is left beyond the expected length.
 *
 *  Example:
 * If array A is [4, 1, 1, 2, 1, 3]
 * and value elem is 1,
 * then new length is 3, and A is now [4, 2, 3]
 * Try to do it in less than linear additional space complexity.
 */
public class RemoveElementFromArray {
    public static void main(String args[]) {
        RemoveElementFromArraySolver solver = new RemoveElementFromArraySolver();

        //test1
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4, 1, 1, 2, 1, 3));
        //test2
        //ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,1,2));
        //test3
        //ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0, 0, 0, 1, 1, 2, 2, 3));
        System.out.println((solver.solve(A,1)));
    }
}

class RemoveElementFromArraySolver{
    public int solve(ArrayList<Integer> A, int num){

        int len=A.size();
        int count=0;

        for(int i=0; i<len; i++){

            int val=A.get(i);

            if(val!=num){
                A.set(count,val);
                count++;
            }
        }

        return count;
    }
}