package DynamicProgramming.Easy;


/**
 * @author jakadam on 2019-12-18
 */

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the
 * divide and conquer approach, which is more subtle.
 */
public class MaximumContiguousSubarraySum {
    public static void main(String args[]) {
        final MaximumContiguousSubarraySumSolver solver = new MaximumContiguousSubarraySumSolver();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solver.cubicTimeSol(nums));
        System.out.println(solver.quadraticTimeSol(nums));
        System.out.println(solver.linearTimeSol(nums));
    }


}

class MaximumContiguousSubarraySumSolver {
    public int cubicTimeSol(int[] nums) {
        int len = nums.length;
        int maxSum = Integer.MIN_VALUE;

        /**
         *  here we try to generate each possible sub array of the given array using the outer 2 loops
         *  we set i to index 0 and j to index, an then keep moving for j till the end of the array for
         *  each value of i
         *  once the boundaries of the sub array are defined by i an j, innermost loop iterates over the
         *  subset and calculates the sum of the sub array.
         */
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {

                //iterate over the subarray and calculate the sum
                int runningWindowSum = 0;
                //uncomment the following line to understand the possible subarrays
                //System.out.println(left+" "+right);
                for (int k = left; k <= right; k++) {
                    runningWindowSum = runningWindowSum + nums[k];
                }
                // update the maximum subarray sum
                maxSum = Math.max(maxSum, runningWindowSum);
            }

        }

        return maxSum;
    }

    public int quadraticTimeSol(int[] nums) {
        /**
         * The innermost loop in cubic solution is doing a repetitive work.
         * we can adjust the j loop and calculate runningSum more efficiently
         */
        int len = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for (int left = 0; left < len; left++) {
            int runningWindowSum = 0;
            for (int right = left; right < len; right++) {
                //uncomment the following line to understand the possible subarrays
                //System.out.println(left+" "+right);
                runningWindowSum = runningWindowSum + nums[right];

                // update the maximum subarray sum
                maxSum = Math.max(maxSum, runningWindowSum);
            }
        }

        return maxSum;
    }

    public int linearTimeSol(int[] nums) {
        int len = nums.length;
        /**
         * We default to say the the best maximum seen so far is the first
         * element.
         * We also default to say the the best max ending at the first element
         * is...the first element. (this is because on Leetcode we must choose a
         * subarray of at least one item, we cannot choose nothing)
         */


        /**
         * We are inspecting the item at index i.
         * We want to answer the question:
         * "What is the Max Contiguous Subarray Sum we can achieve ending at index i?"
         * We have 2 choices:
         * maxEndingHere + nums[i] (extend the previous subarray best whatever it was)
         *  1.) Let the item we are sitting at contribute to this best max we achieved
         *  ending at index i - 1.
         *  nums[i] (start and end at this index)
         *  2.) Just take the item we are sitting at's value.
         * The max of these 2 choices will be the best answer to the Max Contiguous
         * Subarray Sum we can achieve for subarrays ending at index i.
         * Example:
         * index     0  1   2  3   4  5  6   7  8
         * Input: [ -2, 1, -3, 4, -1, 2, 1, -5, 4 ]
         * -2, 1, -2, 4,  3, 5, 6,  1, 5    'maxEndingHere' at each point
         *
         * The best subarrays we would take if we took them:
         * ending at index 0: [ -2 ]           (snippet from index 0 to index 0)
         * ending at index 1: [ 1 ]            (snippet from index 1 to index 1) [we just took the item at index 1]
         *  ending at index 2: [ 1, -3 ]        (snippet from index 1 to index 2)
         * ending at index 3: [ 4 ]            (snippet from index 3 to index 3) [we just took the item at index 3]
         *  ending at index 4: [ 4, -1 ]        (snippet from index 3 to index 4)
         *  ending at index 5: [ 4, -1, 2 ]     (snippet from index 3 to index 5)
         *  ending at index 6: [ 4, -1, 2, 1 ]  (snippet from index 3 to index 6)
         *  ending at index 7: [ 4, -1, 2, 1, -5 ]    (snippet from index 3 to index 7)
         *  ending at index 8: [ 4, -1, 2, 1, -5, 4 ] (snippet from index 3 to index 8)
         *  Notice how we are changing the end bound by 1 everytime.
         *
         */
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < len; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

}

/*
LeetCode: https://leetcode.com/problems/maximum-subarray/
https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
*/