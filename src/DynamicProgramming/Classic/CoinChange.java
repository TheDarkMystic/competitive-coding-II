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
        int amount=16;
        System.out.println(solver.changeLinear(amount,coins));
    }
}

class CoinChangeSolver{


    public int changeLinear(int totalAmount, int[] coins) {
        int noOfCoins=coins.length;


        // each cell of this dp represents, minimum number of coins needed to
        // make sum i given all coins are available for use
        int dp[]= new int[totalAmount+1];// by default all cells have value 0

        //fill the array with arbitrary large number as we have to find min number of coins
        Arrays.fill(dp,totalAmount+1);

        //sum 0 can be made with 0 coins
        //base case
        dp[0]=0;

        for(int coin:coins){
            for(int amt=1; amt<=totalAmount; amt++){
                if(coin<=amt)
                dp[amt]=Math.min(dp[amt],dp[amt-coin]+1);
            }
        }


        /**
         *  dp[amount] has our answer. If we do not have an answer then dp[amount]
         *  will be amount + 1 and hence dp[amount] > amount will be true. We then
         *  return -1.
         *  Otherwise, dp[amount] holds the answer
         */
        return dp[totalAmount] > totalAmount ? -1 : dp[totalAmount];
    }
}
/**
 * https://leetcode.com/problems/coin-change/
 * https://www.youtube.com/watch?v=jgiZlGzXMBw
 */