package DynamicProgramming.Classic;

/**
 * @author jakadam on 2019-12-17
 */

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 *  https://leetcode.com/problems/coin-change-2/
 *
 *  You are given coins of different denominations and a total amount of money.
 *  Write a function to compute the number of combinations that make up that amount.
 *  You may assume that you have infinite number of each kind of coin.
 *
 *
 *
 *  Example 1:
 *
 *  Input: amount = 5, coins = [1, 2, 5]
 *  Output: 4
 *  Explanation: there are four ways to make up the amount:
 *  5=5
 *  5=2+2+1
 *  5=2+1+1+1
 *  5=1+1+1+1+1
 *  Example 2:
 *
 *  Input: amount = 3, coins = [2]
 *  Output: 0
 *  Explanation: the amount of 3 cannot be made up just with coins of 2.
 *  Example 3:
 *
 *  Input: amount = 10, coins = [10]
 *  Output: 1
 *
 *
 *  Note:
 *
 *  You can assume that
 *
 *  0 <= amount <= 5000
 *  1 <= coin <= 5000
 *  the number of coins is less than 500
 *  the answer is guaranteed to fit into signed 32-bit integer
 */

class CoinChangeII {
    public static void main(String args[]){
        CoinChangeIISolver solver= new CoinChangeIISolver();
        int[] coins={1, 2, 5};
        int amount=12;
        System.out.println(solver.changeQuadratic(amount,coins));
        System.out.println(solver.changeLinear(amount,coins));
    }
}

class CoinChangeIISolver{
    public int changeQuadratic(int totalAmount, int[] coins) {
        int noOfCoins=coins.length;
        int amt=totalAmount;
        int dp[][] = new int[noOfCoins+1][amt+1];

        //sum 0 can be made by 0 coins in 1 way
        dp[0][0]=1;

        for(int i=1;i<=noOfCoins;i++){
            //whatever number of coins are available, sum 0 can be made only by excluding all the
            // available coins hence it can be achieved in 1 way
            dp[i][0]=1;
            //filling the DP table
            for(int j=1;j<=amt;j++){
                // if the value of coin is greater than the amount to be made, exclude the coin, copy value
                // from above row which represents ways to make that sum excluding current coin
                if(j<coins[i-1])
                    dp[i][j]=dp[i-1][j];
                else{//value of coin is smaller or equal to the amount to be made

                    dp[i][j]=(dp[i][j-coins[i-1]]+dp[i-1][j]);
                    //dp[i][j-coins[i-1] = no. of ways to make amount including current coin
                    //dp[i-1][j] = no. of ways to make amount excluding current coin
                }
            }
        }
        return dp[noOfCoins][amt];
    }

    public int changeLinear(int totalAmount, int[] coins) {
        int noOfCoins=coins.length;


        // each cell of this dp represents, the number of ways in which amount i can be made with given coins
        // where i is the index of cell
        int dp[]= new int[totalAmount+1];// by default all cells have value 0


        //sum 0 can be made in 1 way, not including any coin
        //base case
        dp[0]=1;

        //outer for represents a coin, inner for represents amount to be made
        //we will take each coin and if the amount to be made is greater than the coin value we will
        //calculate the number of ways using solutions of smaller sub problem

        for(int coin:coins){
            //if coin value is smaller than amount to be made, we cannot use that coin
            for(int amt=1; amt<=totalAmount; amt++){ //j=> amount to be made
                if(coin<=amt)
                    dp[amt]=dp[amt]+dp[amt-coin];
            }
        }


        return dp[totalAmount];
    }
}

/**
 *  This problem is also called Integer Partition problem. Given integer, in how many ways it can be represented
 *  as a sum of other integers
 *
 *  O(n^2) solution: https://www.youtube.com/watch?v=PafJOaMzstY
 *  O(n) solution : https://www.youtube.com/watch?v=ZaVM057DuzE
 */