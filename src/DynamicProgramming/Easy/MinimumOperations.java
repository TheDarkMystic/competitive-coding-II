package DynamicProgramming.Easy;

import java.util.Scanner;

/**
 * @author jakadam on 2019-12-27
 */

/**
 * You are given a number N. You have to find the number of operations required to reach N from 0.
 * You have 2 operations available:
 *
 * Double the number
 * Add one to the number
 * Input:
 * The first line of input contains an integer T denoting the number of test cases.
 * Then T test cases follow. Each test case contains an integer N.
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

class MinimumOperations {
    public static void main(String[] args) {
        /**
         *  Instead of going from 0 to N we will start reducing the number from N and try to reach to 0.
         */
        Scanner src = new Scanner(System.in);
        int testCases = src.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = src.nextInt();
            int count = 0;
            while (n != 0) {

                if (n == 0)
                    break;
                else if (n % 2 == 0) {
                    while (n % 2 == 0) {
                        n = n / 2;
                        count++;
                    }
                }

                if (n % 2 == 1) {
                    n--;
                    count++;
                }
            }
            System.out.println(count);

        }
    }
}

/**
 * Tested on GFG
 * https://practice.geeksforgeeks.org/problems/find-optimum-operation/0
 **/
