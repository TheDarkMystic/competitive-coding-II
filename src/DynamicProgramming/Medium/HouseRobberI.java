package DynamicProgramming.Medium;

/**
 * @author jakadam on 2019-12-27
 */

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping
 * you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses were
 * broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 */


public class HouseRobberI {
    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int len=nums.length;
        if(len==1)
            return nums[0];
        if(len==2)
            return Math.max(nums[0],nums[1]);

        int[] dp= new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2; i<dp.length; i++){
            /**
             * We will solve smaller sub problems to get answer to final problem
             * At each house/ dp[i], we have 2 choices
             * 1. To rob the house, if we rob ith house we cannot rob (i-1)th house and we can take the max robbed
             * amount from (i-2)th house hence the robbed amount becomes (dp[i] + dp[i-2])
             *
             * 2. Not to rob the house, if we don't rob ith house, we have to continue with the max robbed amount till
             *  (i-1)th house
             *
             *  We take max of choice 1, choice 2 and assign it to dp[i]
             */
            dp[i]=Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[len-1];
    }

    public static int robOptimizedMem(int[] nums) {
        /**
         * For every house k, there are two options: either to rob it (include this house: i) or not rob it (exclude this house: e).
         *
         * Include this house:
         * i = num[k] + e (money of this house + money robbed excluding the previous house)
         *
         * Exclude this house:
         * e = max(i, e) (max of money robbed including the previous house or money robbed excluding the previous house)
         * (note that i and e of the previous step, that's why we use tmp here to store the previous i when calculating e, to make O(1) space)
         *
         * Here is the code:
         */
        int i = 0;
        int e = 0;
        for (int k = 0; k<nums.length; k++) {
            int tmp = i;
            i = nums[k] + e;
            e = Math.max(tmp, e);
        }
        return Math.max(i,e);
    }
}

/**
 * Tested on Leetcode
 * https://leetcode.com/problems/house-robber/
 */