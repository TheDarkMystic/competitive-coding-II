package GraphAlgorithms;

/**
 * @author jakadam on 2019-12-25
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * How many minimum numbers from fibonacci series are required such that sum of numbers should be equal
 * to a given Number N?
 * Note : repetition of number is allowed.
 * <p>
 * Example:
 * <p>
 * N = 4
 * Fibonacci numbers : 1 1 2 3 5 .... so on
 * here 2 + 2 = 4
 * so minimum numbers will be 2
 */
public class SumOfFibonacciNumbers {
    public static void main(String[] args) {

        int N = 4;
        fibsum(4);


    }

    public static int fibsum(int N) {
        ArrayList<Integer> fibList = new ArrayList<>();
        generateFibList(fibList, N);

        int dp[] = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int fibNum : fibList) {
            for (int j = 0; j <= N; j++) {
                if (fibNum <= j)
                    dp[j] = Math.min(dp[j], dp[j - fibNum] + 1);

            }
        }

        return dp[N];

    }

    public static void generateFibList(ArrayList<Integer> fibList, int N) {
        int a = 1;
        int b = 1;
        int c;
        fibList.add(a);
        fibList.add(b);

        while (true) {
            c = a + b;
            if (c <= N)
                fibList.add(c);
            else
                break;
            a = b;
            b = c;
        }

    }

}
