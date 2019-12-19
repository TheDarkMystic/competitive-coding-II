package DynamicProgramming.Easy;

/**
 * @author jakadam on 2019-12-19
 */

/**
 * Given an array of non-negative integers, A, of length N, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Return the minimum number of jumps required to reach the last index.
 *
 * If it is not possible to reach the last index, return -1.
 *
 * Input Format:
 *
 * The first and the only argument contains an integer array, A.
 * Output Format:
 *
 * Return an integer, representing the answer as described in the problem statement.
 * Constraints:
 *
 * 1 <= N <= 1e6
 * 0 <= A[i] <= 50000
 * Examples:
 *
 * Input 1:
 *     A = [2, 1, 1]
 *
 * Output 1:
 *     1
 *
 * Explanation 1:
 *     The shortest way to reach index 2 is
 *         Index 0 -> Index 2
 *     that requires only 1 jump.
 *
 * Input 2:
 *     A = [2,3,1,1,4]
 *
 * Output 2:
 *     2
 *
 * Explanation 2:
 *     The shortest way to reach index 4 is
 *         Index 0 -> Index 1 -> Index 4
 *     that requires 2 jumps.
 */
public class MinJumpArray {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 1, 1}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));

    }

    public static int canJump(int[] A) {
        /**
         * we start from the
         */

        if (A.length == 1) {
            return 0;
        }
        int jumps = 1; //at least one jump is always needed to reach the end
        int lastReach = A[0];//how far we can go from here without taking a jump
        int maxReach = A[0];//max distance we can go from here without jump

        /**
         * we start from the 1st index of array and keep updating the maxReach at every index if we find larger
         * maxReach from that point
         *
         * for traversal we use lastReach, similar to consuming a step ,
         * once lastReach > i, we have to take a jump, so we pull the maxReach into lastReach
         */
        for (int i = 1; i < A.length; i++) {
            //current index is beyond maxReach so it cannot be reached to, return -1
            if (i>maxReach) {
                return -1;
            }
            //current index is beyond lastReach, we need to take a jump
            if (i>lastReach) {
                jumps++;
                lastReach = maxReach;
            }
            // at every step keep updating maxReach
            maxReach = Math.max(maxReach, i + A[i]);
        }
        return jumps;
    }
}

/**
 * http://www.geeksforgeeks.org/minimum-number-jumps-reach-endset-2on-solution/
 *
 * https://www.youtube.com/watch?v=vBdo7wtwlXs
 */