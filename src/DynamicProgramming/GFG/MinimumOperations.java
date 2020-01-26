package DynamicProgramming.GFG;

/**
 * @author jakadam on 2020-01-17
 */


/**
 * You are given a number N. You have to find the number of operations required to reach N from 0.
 * You have 2 operations available:
 *
 * Double the number
 * Add one to the number
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.
 * Each test case contains an integer N.
 *
 * Output:
 * For each test case, in a new line, print the minimum number of operations required to reach N from 0.
 *
 * Constraints:
 * 1<=T<=100
 * 1<=N<=104
 *
 * Example:
 * Input:
 * 2
 * 8
 * 7
 * Input:
 * 4
 * 5
 *
 * Explanation:
 * Testcase1:
 * Input  : N = 8
 * Output : 4
 * 0 + 1 = 1, 1 + 1 = 2, 2 * 2 = 4, 4 * 2 = 8
 * Testcase2:
 * Input  : N = 7
 * Output : 5
 * 0 + 1 = 1, 1 + 1 = 2, 1 + 2 = 3, 3 * 2 = 6, 6 + 1 = 7
 */

//problem is very similar to stairs problem from DP
class MinimumOperations {
    public static void main(String[] args) {
        // N=8->4, N=7->5
        System.out.println(solveIterative(8));
        System.out.println(solveIterative(7));
        System.out.println(minOps(8));
        System.out.println(minOps(7));


    }

    public static int minOps(int N){

        if (N==0)
            return 0;
        if (N==1)
            return 1;
        if (N%2 == 0)
            return Math.min(minOps(N-1), minOps(N/2))+1;
        else
            return minOps(N-1)+1;
    }


    public static  int solveIterative(int steps){
        int dp[]= new int[steps+1];
        dp[0]=1;//base case1
        dp[1]=1;//base case2

        for(int i=2;i<steps+1; i++){
            if((i&1)==0)// even
                dp[i]=Math.min(dp[i-1],dp[i/2])+1;
            else
                dp[i]=dp[i-1]+1;
        }

        return dp[steps];
    }
}


// ops(N) = min(ops(N-1),ops(N/2)) + 1
