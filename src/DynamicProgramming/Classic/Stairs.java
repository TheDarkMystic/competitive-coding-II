package DynamicProgramming.Classic;

/**
 * @author jakadam on 2019-12-17
 */

/**
 * You are climbing a stair case and it takes A steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you
 * climb to the top?
 *
 *
 *
 * Input Format:
 *
 * The first and the only argument contains an integer A, the number of steps.
 * Output Format:
 *
 * Return an integer, representing the number of ways to reach the top.
 * Constrains:
 *
 * 1 <= A <= 36
 * Example :
 *
 * Input 1:
 *
 * A = 2 Output 1:
 *
 * 2 Explanation 1:
 *
 * [1, 1], [2] Input 2:
 *
 * A = 3 Output 2:
 *
 * 3 Explanation 2:
 *
 * [1 1 1], [1 2], [2 1]
 */
public class Stairs {
    public static void main(String args[]){
        StairsSolver solver = new StairsSolver();
        int steps=0;
        //test1
        //steps=3;
        //test2
        steps=10;
        System.out.println(solver.solveIterative(steps));
        System.out.println(solver.solveRecursive(steps));
    }
}

class StairsSolver{
    /**
     * Logic is simple, it is classic use of fibonacci series
     * lets say we have to find the ways one can reach 6th steps, steps=6 here
     * as we can take only 1 or 2 steps at a time, the ans can be calculated by adding the
     * ways in which we can reach 5 and ways in which we can reach 4
     *
     * numSteps[6]=numSteps[5]+numSteps[4] => f(n)=f(n-1)+f(n-2)
     *
     * the important point is the base case for the solution
     * we have 2 base cases,
     * 1.we can reach 0th step by only 1 way, (we cannot basically)-> this is
     * a hypothetical case
     * 2.we can reach 1st step in only 1 way that is by taking 1 steps
     *
     * @param steps
     * @return int
     */


    public int solveIterative(int steps){
        int dp[]= new int[steps+1];
        dp[0]=1;//base case1
        dp[1]=1;//base case2

        for(int i=2;i<steps+1; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[steps];
    }

    public int solveRecursive(int steps){
        if(steps<0)
            return 0;
        if(steps==0)
            return 1;

        int ways=solveRecursive(steps-1)+solveRecursive(steps-2);

        return ways;
    }

}