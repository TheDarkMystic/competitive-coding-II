package Arrays;

import java.util.Arrays;
import java.util.List;

/**
 *  maximise |A[i] - A[j]| + |i - j|
 *  max( A[i] +i - A[j] +j)
 *  max( (A[i]+i) - (A[j]-j) )
 *
 *  You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j)
 *  for all 1 ≤ i, j ≤ N.
 *  f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
 *
 *  A=[1, 3, -1]
 *
 * f(1, 1) = f(2, 2) = f(3, 3) = 0
 * f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
 * f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
 * f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5
 *
 * So, we return 5.
 **/
public class MaxAbsoluteDifference {

    public static void main(String args[]) {
        List<Integer> nums= Arrays.asList(1,10,5);
        final MaxAbsoluteDifferenceSolver solver= new MaxAbsoluteDifferenceSolver();
        System.out.println(solver.solve(nums)) ;
    }
}


class MaxAbsoluteDifferenceSolver{
    public int solve(List<Integer> A) {
        int tempSum = -1, tempDiff = -1;
        int minOfSum = Integer.MAX_VALUE, minOfDiff = Integer.MAX_VALUE;
        int maxOfSum = Integer.MIN_VALUE, maxOfDiff = Integer.MIN_VALUE;

        for(int i = 0; i < A.size(); i++){
            // Calculating Min and Max values for A[i] + i
            tempSum = A.get(i) + i;

            if(tempSum > maxOfSum){
                maxOfSum = tempSum;
            }
            if(tempSum < minOfSum){
                minOfSum = tempSum;
            }
            // Calculating Min and Max values for A[i] - i
            tempDiff = A.get(i) - i;
            if(tempDiff > maxOfDiff){
                maxOfDiff = tempDiff;
            }
            if(tempDiff < minOfDiff){
                minOfDiff = tempDiff;
            }
        }



        return Math.max((maxOfSum - minOfSum), (maxOfDiff - minOfDiff));
    }
}