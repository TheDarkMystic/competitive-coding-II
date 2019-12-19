package DynamicProgramming.Easy;

/**
 * @author jakadam on 2019-12-19
 */

import java.util.Arrays;

/**
 * https://www.interviewbit.com/problems/jump-game-array/
 * Given an array of non-negative integers, A, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 *
 * Input Format:
 *
 * The first and the only argument of input will be an integer array A.
 * Output Format:
 *
 * Return an integer, representing the answer as described in the problem statement.
 *     => 0 : If you cannot reach the last index.
 *     => 1 : If you can reach the last index.
 * Constraints:
 * 1 <= len(A) <= 1e6
 * 0 <= A[i] <= 30
 *
 * Examples:
 *
 * Input 1:
 *     A = [2,3,1,1,4]
 *
 * Output 1:
 *     1
 *
 * Explanation 1:
 *     Index 0 -> Index 2 -> Index 3 -> Index 4 -> Index 5
 *
 * Input 2:
 *     A = [3,2,1,0,4]
 *
 * Output 2:
 *     0
 *
 * Explanation 2:
 *     There is no possible path to reach the last index.
 */
public class JumpGameArray {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }
    public static int canJump(int[] A) {
        /**
         * We iterate through the array and at each index we check if we can go beyond the maxReachableFromHere
         * by using (currentStop+A[currentStop]), if yes then we update maxReachableFromHere,
         */


        int maxReachableFromHere=0;
        System.out.println(Arrays.toString(A));
        for(int currentStop=0;currentStop<A.length;currentStop++){
            // we exhausted the maxReachableFromHere
            if(currentStop>maxReachableFromHere){
                return 0;
            }

            maxReachableFromHere=Math.max(maxReachableFromHere,currentStop+A[currentStop]);
            System.out.println("currentStop=>"+currentStop+" maxReachableFromHere=>"+maxReachableFromHere);
        }
        return 1;
    }
}
