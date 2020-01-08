package BitManipulation;

/**
 * @author jakadam on 2020-01-08
 */

/**
 Given an array of integers, every element appears twice except for one. Find that single one.

 Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 Input Format:

 First and only argument of input contains an integer array A
 Output Format:

 return a single integer denoting single element
 Constraints:

 2 <= N <= 2 000 000
 0 <= A[i] <= INT_MAX
 For Examples :

 Example Input 1:
 A = [1, 2, 2, 3, 1]
 Example Output 1:
 3
 Explanation:
 3 occurs only once
 Example Input 2:
 A = [1, 2, 2]
 Example Output 2:
 1
 */


public class SingleNumberI {
    /**
     * Concept
     *
     * If we take XOR of zero and some bit, it will return that bit
     * a \oplus 0 = aa⊕0=a
     * If we take XOR of two same bits, it will return 0
     * a \oplus a = 0a⊕a=0
     * a \oplus b \oplus a = (a \oplus a) \oplus b = 0 \oplus b = ba⊕b⊕a=(a⊕a)⊕b=0⊕b=b
     * So we can XOR all bits together to find the unique number.
     * @param A
     * @return
     */
    public int singleNumber(final int[] A) {
        int n = A.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= A[i];
        }
        return result;
    }


    /**
     * tested on InterviewBit
     * https://leetcode.com/problems/single-number/#/solutions
     * Optional :
     * Approach 1: Using Math
     *              2∗(a+b+c)−(a+a+b+b+c)=c
     * Approach 2: Using HashMap/ HashSet
     *
     */
}

