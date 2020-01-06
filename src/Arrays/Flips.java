package Arrays;

/**
 * @author jakadam on 2020-01-05
 */
/**
 * You are given a binary string(i.e. with characters 0 and 1) S consisting of characters
 * S1, S2, …, SN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N
 * and flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.
 *
 * Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised.
 * If you don’t want to perform the operation, return an empty array. Else, return an array consisting
 * of two elements denoting L and R. If there are multiple solutions, return the lexicographically
 * smallest pair of L and R.
 *
 * Notes:
 *
 * Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
 * For example,
 *
 * S = 010
 *
 * Pair of [L, R] | Final string
 * _______________|_____________
 * [1 1]          | 110
 * [1 2]          | 100
 * [1 3]          | 101
 * [2 2]          | 000
 * [2 3]          | 001
 *
 * We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
 * Another example,
 *
 * If S = 111
 *
 * No operation can give us more than three 1s in final string. So, we return empty array [].
 */


/**
 *  Crux of the problem :
 *  We need to find a subarray where there are max number of 0's and least number of 1's.
 *  That is, we need to find a subarray, which has minimum sum
 *  If we convert all the 0'->1 and all the 1's -> -1, now we need to find the subarray with maximum sum
 *  we know the solution to this problem already -> Kadane's algorithm
 *
 *  Why we replace 1's -> -1 and not with 0's, if we replace 1's with 0's, the subarray sum will never go -ve
 *  and we will get complete array as the subarray
 *
 *          // notes from Arrays/MaximumContiguousSubarraySum.java
 *          *  (maxEndingHere + nums[i]) will be lesser than nums[i] only when the maxEndingHere is
 *          *  -ve, that is the sum accumulated till now is -ve so we start over the subarray from
 *          *  current element.
 *          *
 *          *  So the gist of the solution is :
 *          *  keep accumulating sum till the sum becomes < 0,
 *          *  at which point you start over again, discarding the accumulated sum.
 *          *
 *          *
 *
 *  the only modification is, in kadane's algo we return the sum of the subarray, here we need to return the
 *  starting and ending of the subarray
 *
 *
 */

import java.util.Arrays;

public class Flips {
    public static void main(String args[]) {
        System.out.println(Arrays.toString(flip("111")));
        System.out.println(Arrays.toString(flip("010")));
    }

    public static int[] flip(String str) {

        if (str.length() == 0)
            return new int[]{};

        boolean zeroPresent = false;

        //create another array by replacing 1-> -1 and 0-> 1
        int arr[] = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = (str.charAt(i) == '1') ? -1 : 1;
            // check if we encounter any 0s
            if (str.charAt(i) == '0')
                zeroPresent = true;

        }
        // if all the chars are 1 already, present empty array, we need not flip any bits
        if (!zeroPresent)
            return new int[]{};

        //initialize variables
        int l = 0;
        int r = 0;
        int maxSoFar = 0;
        int maxEndingHere = 0;
        int currL = 0;
        int currR = 0;

        //basic kadane's algorithm implementation
        for (int i = 0; i < arr.length; i++) {
            if (maxEndingHere + arr[i] >= 0) {
                maxEndingHere += arr[i];
                currR = i;
            } else {//maxEndingHere + arr[i] has gone negative
                maxEndingHere = 0;
                currL = i + 1;
            }

            // we found new max subarray sum
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                l = currL;
                r = currR;
            }
        }
        return new int[]{l + 1, r + 1};
    }

}