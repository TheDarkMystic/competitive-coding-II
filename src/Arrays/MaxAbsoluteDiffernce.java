package Arrays;

import java.util.Arrays;
import java.util.List;

/**
 *  maximise |A[i] - A[j]| + |i - j|
 *  max( A[i] +i - A[j] +j)
 *  max( (A[i]+i) - (A[j]-j) )
 **/
public class MaxAbsoluteDiffernce {

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