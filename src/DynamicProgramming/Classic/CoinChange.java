package DynamicProgramming.Classic;

/**
 * @author jakadam on 2019-12-17
 */

/**
 *
 You are given coins of different denominations and a total amount of money.
 Write a function to compute the number of combinations that make up that amount.
 You may assume that you have infinite number of each kind of coin.



 Example 1:

 Input: amount = 5, coins = [1, 2, 5]
 Output: 4
 Explanation: there are four ways to make up the amount:
 5=5
 5=2+2+1
 5=2+1+1+1
 5=1+1+1+1+1
 Example 2:

 Input: amount = 3, coins = [2]
 Output: 0
 Explanation: the amount of 3 cannot be made up just with coins of 2.
 Example 3:

 Input: amount = 10, coins = [10]
 Output: 1


 Note:

 You can assume that

 0 <= amount <= 5000
 1 <= coin <= 5000
 the number of coins is less than 500
 the answer is guaranteed to fit into signed 32-bit integer
 */

class CoinChange {
    public static void main(String args[]){
        CoinChangeSolver solver= new CoinChangeSolver();
        int[] coins={1, 2, 5};
        int amount=5;
        System.out.println(solver.change(amount,coins));
        //System.out.println(solver.solveRecursive(steps));
    }
}

class CoinChangeSolver{
    public int change(int totalAmount, int[] coins) {
        // the solution is very similar to the knapsack problem
        int numOfCoins=coins.length;
        // we will take amount on the X axis and available coins on the Y axis
        int dp[][]=new int[numOfCoins+1][totalAmount+1];

        for(int avlblCoins=0;avlblCoins<=numOfCoins; avlblCoins++){
            for(int amountToMake=0; amountToMake<=totalAmount; amountToMake++){

                // when we don't have any coins and we want to make amount 0, this can be done in
                // one way, not including anything
                if(avlblCoins==0 && amountToMake==0){
                    dp[avlblCoins][amountToMake]=1;
                    continue;
                }
                // we have no coins and we want to make amounts in the range 1..amount
                // this cannot be achieved
                if(avlblCoins==0 && amountToMake!=0){
                    dp[avlblCoins][amountToMake]=0;
                    continue;
                }
                // when we have coins ranging from coins[0] to coins[len-1] and we have to
                // make amount=0, this is possible in one way, not including any coin
                if(avlblCoins!=0 && amountToMake==0){
                    dp[avlblCoins][amountToMake]=1;
                    continue;
                }
                int currentCoinValue = coins[avlblCoins-1];
                // number of ways in which amount can be formed without using current coin
                int withoutThisCoin = dp[avlblCoins-1][amountToMake];

                // number of ways in which amount can be formed using current coin
                int withThisCoin=0;
                if(amountToMake>=currentCoinValue){
                    withThisCoin =dp[avlblCoins][amountToMake-currentCoinValue];
                }
                else
                    withThisCoin=0;

                //total number of ways in which amount can be formed
                dp[avlblCoins][amountToMake]=withoutThisCoin+withThisCoin;
            }
        }


        return dp[numOfCoins][totalAmount];
    }
}