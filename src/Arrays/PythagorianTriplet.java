package Arrays;

/**
 * @author jakadam on 2020-01-31
 */
/**
 * A Pythagorean triplet is a set {a, b, c} such that a^2 = b^2+ c^2a
 * ​2
 * ​​ =b
 * ​2
 * ​​ +c
 * ​2
 * ​​ . The user is provided with an array of integers and has to identify all the possible sets of
 * Pythagorean triplets.
 *
 * Algorithm
 * The naive approach here would be to run three nested for loops to try all possible triplets in
 * an array. However, the complexity of such a solution would be O(n^3)O(n
 * ​3
 * ​​ ).
 *
 * Instead, we can solve the problem in O(n^2)O(n
 * ​2
 * ​​ ) by sorting the array in ascending order, first.
 *
 * The steps involved would be:
 *
 * Square every element in the input array and then sort it in ascending order.
 * Since the array now contains squares, the new equation for triplet becomes a = b + ca=b+c.
 * Fix a to be the last element of this sorted array, since a will always have the largest value
 * of the three numbers.
 *
 * Fix b as the first element of the sorted array and c as the element right before element a.
 * Since numbers are positive and the array is sorted, b < ab<a and c < ac<a. To find triplets,
 * run a loop that increases b from 11 to nn, and decreases c from nn to 11 at the same time until
 * they meet.
 *
 * Increase the position of b if b + c < ab+c<a.
 * Decrease the position of c if b + c > ab+c>a .
 * If the sum is equal to a, then print the square root of the three numbers, increment b,
 * and decrement c.
 *
 * Repeat the last step for each element a in the array.
 * The following slides help us to visualize this algorithm:​
 */

import java.util.*;
import java.lang.Math;

class PythagoreanTriplet {
    static void findTriplet(int arr[], int n)
    {
        // Step1
        for (int i = 0; i < n; i++)
            arr[i] = arr[i] * arr[i];
        Arrays.sort(arr);

        // Step2 and Step 3
        for (int i = n - 1; i >= 2; i--) {  // Fix a
            int b = 0; // Fix b
            int c = i - 1; // Fix c
            while (b < c) {
                // A triplet found
                if (arr[b] + arr[c] == arr[i]) {
                    System.out.printf("Triplets: %f, %f, %f\n",
                            new Object[] {Math.sqrt(arr[b]), Math.sqrt(arr[c]), Math.sqrt(arr[i])});
                    b++;
                    c--;
                }
                if (arr[b] + arr[c] < arr[i])
                    b++;
                else
                    c--;
            }
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        int arr[] = { 3, 1, 4, 6, 5 };
        int arr_size = arr.length;
        findTriplet(arr, arr_size);
    }
}

/**
 *https://www.geeksforgeeks.org/find-pythagorean-triplet-in-an-unsorted-array/
 *https://www.educative.io/edpresso/how-to-find-pythagorean-triplets-in-an-array
 */