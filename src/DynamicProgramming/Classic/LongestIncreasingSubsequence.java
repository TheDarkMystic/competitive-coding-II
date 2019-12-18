package DynamicProgramming.Classic;

/**
 * @author jakadam on 2019-12-17
 */

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {
   public static void main(String args[]){
       LongestIncreasingSubsequenceSolver solver= new LongestIncreasingSubsequenceSolver();
       int A[]={10,9,2,5,3,7,101,18};
       System.out.println(solver.solve(A));
   }

}
class LongestIncreasingSubsequenceSolver {
    public int solve(int[] A){
        int len=A.length;
        int[] maxLIS=new int[len+1];

        Arrays.fill(maxLIS,1);

        int maxSoFar=1;


        for(int i=1; i<len; i++){
            for(int j=0; j<i; j++){

                if(A[i]>A[j]){
                    maxLIS[i]=Math.max(maxLIS[i],maxLIS[j]+1);
                }
            }
            maxSoFar=Math.max(maxSoFar,maxLIS[i]);
        }
        return maxSoFar;
    }
}