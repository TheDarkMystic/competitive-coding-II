package DynamicProgramming.Classic;

/**
 * @author jakadam on 2019-12-24
 */

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/
 *
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */

class CoinChange {
    public static void main(String args[]){
        CoinChangeSolver solver= new CoinChangeSolver();
        int[] coins={1, 2, 5};
        int amount=11;
        System.out.println(solver.changeLinear(amount,coins));
    }
}

class CoinChangeSolver{
    /**
     * If totalAmount== 0, then 0 coins required.
     * If totalAmount > 0
     *    minCoins(coins[0..m-1], totalAmount) = min {1 + minCoins(totalAmount-coin[i])}
     *                                where i varies from 0 to m-1
     *                                and coin[i] <= totalAmount
     * @param coins
     * @param totalAmount
     * @return
     */

    // m is size of coins array (number of different coins) 
    public static int changeRec(int coins[], int totalAmount)
    {
        // base case 
        if (totalAmount == 0)
            return 0;

        // Initialize result 
        int res = Integer.MAX_VALUE;

        // Try every coin that has smaller value than totalAmount 
        for (int i=0; i<coins.length; i++){
            if (coins[i] <= totalAmount){
                int resForRemSum = changeRec(coins, totalAmount-coins[i]);

                // Check for INT_MAX to avoid overflow and see if 
                // result can minimized 
                if (resForRemSum != Integer.MAX_VALUE && resForRemSum + 1 < res)
                    res = resForRemSum + 1;
            }
        }
        return res;
    }
    
    
    public int changeLinear(int totalAmount, int[] coins) {

        // dp[i] will be storing  
        // the minimum number of coins 
        // required for i value. So  
        // dp[totalAmount] will have result 
        int dp[] = new int[totalAmount + 1];

        // Base case (If given value totalAmount is 0) 
        dp[0] = 0;

        // Initialize all dp values as Infinite 
        for (int i = 1; i <= totalAmount; i++)
            dp[i] = Integer.MAX_VALUE;

        // Compute minimum coins required for all 
        // values from 1 to totalAmount 
        for (int amount = 1; amount <= totalAmount; amount++){
            // Go through all coins smaller than amount
            for (int j = 0; j < coins.length; j++)
                if (coins[j] <= amount){
                    int resForRemSum = dp[amount - coins[j]];
                    //if dp[amount]== Integer.MAX_VALUE, that amount cannot be formed using given coins
                    if (resForRemSum != Integer.MAX_VALUE && resForRemSum + 1 < dp[amount])
                        dp[amount] = resForRemSum + 1;
                }
        }
        return dp[totalAmount];
    }
}
/**
 * https://leetcode.com/problems/coin-change/
 * https://www.youtube.com/watch?v=jgiZlGzXMBw
 */