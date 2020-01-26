package Greedy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author jakadam on 2020-01-25
 */

/**
 * Given an array A, of N integers A.
 *
 * Return the highest product possible by multiplying 3 numbers from the array.
 *
 * NOTE: Solution will fit in a 32-bit signed integer.
 *
 *
 *
 * Input Format:
 *
 * The first and the only argument is an integer array A.
 *
 * Output Format:
 *
 * Return the highest possible product.
 *
 * Constraints:
 *
 * 1 <= N <= 5e5
 *
 * Example:
 *
 * Input 1:
 * A = [1, 2, 3, 4]
 *
 * Output 1:
 * 24
 *
 * Explanation 1:
 * 2 * 3 * 4 = 24
 *
 * Input 2:
 * A = [0, -1, 3, 100, 70, 50]
 *
 * Output 2:
 * 350000
 *
 * Explanation 2:
 * 70 * 50 * 100 = 350000
 */


public class HighestProduct {
    //Approach 1: O(nlogn)
    public int maxp3(ArrayList<Integer> A) {
        /*
        Target is to find the largest 3 elements in the array.
        Array may contain negative elements
        sol:
        -Sort the array, calculate product of first 3 eles and last 3 eles
        -return the maximum.
        */

        Collections.sort(A);

        int firstThreeEleProd=A.get(0)*A.get(1)*A.get(A.size() - 1);
        int lastThreeEleProd=A.get(A.size() - 3)*A.get(A.size() - 2)*A.get(A.size() - 1);

        return Math.max(firstThreeEleProd,lastThreeEleProd);
    }


    //Approach 2:
    /*
    Approach 4: O(n) Time, O(1) Space

    Scan the array and compute Maximum, second maximum and third maximum element present in the array.
    Scan the array and compute Minimum and second minimum element present in the array.
    Return the maximum of product of Maximum, second maximum and third maximum and product of Minimum,
    second minimum and Maximum element.

    Note – Step 1 and Step 2 can be done in single traversal of the array.
    */
    public int maxp3Efficient(ArrayList<Integer> arr){
        int n= arr.size();
        // if size is less than 3, no triplet exists
        if (n < 3)
            return -1;

        // Initialize Maximum, second maximum and third
        // maximum element
        int maxA = Integer.MIN_VALUE, maxB = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE;

        // Initialize Minimum and second mimimum element
        int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++)
        {
            // Update Maximum, second maximum and third
            // maximum element
            if (arr.get(i) > maxA)
            {
                maxC = maxB;
                maxB = maxA;
                maxA = arr.get(i);
            }

            // Update second maximum and third maximum element
            else if (arr.get(i) > maxB)
            {
                maxC = maxB;
                maxB = arr.get(i);
            }

            // Update third maximum element
            else if (arr.get(i) > maxC)
                maxC = arr.get(i);

            // Update Minimum and second mimimum element
            if (arr.get(i) < minA)
            {
                minB = minA;
                minA = arr.get(i);
            }

            // Update second mimimum element
            else if(arr.get(i) < minB)
                minB =arr.get(i);
        }

        return Math.max(minA * minB * maxA,
                maxA * maxB * maxC);
    }



}

/**
 * https://www.interviewbit.com/problems/highest-product/
 * tested on interviewbit
 */