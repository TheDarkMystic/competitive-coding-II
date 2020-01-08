package BitManipulation;

/**
 * @author jakadam on 2020-01-08
 */

import java.util.Arrays;
public class MinXORValue {

/**
 *
 *   Though it may not be intuitive at first look, but the solution is:

     Sort the array
     Calculate XOR for adjacent numbers and report the one with minimum value.

     Complexity: O(N log N) - Sorting + O(N) - Linear checking of XOR for
     adjacent numbers.

     Why this works ?

     Suppose A <= C <= B

     Then either A XOR C or C XOR B are smaller than A XOR B

     Proof:

     Let

     A=169, B=187, C=185

     A= 160 = 1010 1001
     B= 187 = 1011 1011
     C= 185 = 1011 1001

     Let i be the leftmost (biggest) index such that A[i] differs from B[i].
     There are 2 cases now:
     1) C[i] = A[i] = 0,
     then (A XOR C)[i] = 0 and (A XOR B)[i] = 1
     This implies (A XOR C) < (A XOR B)
     2) C[i] = B[i] = 1,
     then (B XOR C)[i] = 0 and (A XOR B)[i] = 1
     This implies (B XOR C) < (A XOR B)

    Explanation in plain English:

     Firstly, note that Minimum XOR value means that the first bit from the
     left where the two numbers differ has the least possible place value.
     Lets say the numbers begin with 1010..... and 1011.....
     Now if there is a number K in the list whose value lies between these
     two numbers, then the number shall begin with either 1010.... or
     1011.... Hence, then the XOR of K with one of these numbers shall lead
     to a lesser value. (A contradiction)
     */
    public int findMinXor(int[] A) {
        int len=A.length;
        Arrays.sort(A);

        int minXOR=Integer.MAX_VALUE;
        for(int i=0; i<len-1; i++){
            minXOR=Math.min(minXOR, A[i]^A[i+1]);
        }
        return minXOR;
    }
}


/**
 Tested on InterviewBit
 https://www.interviewbit.com/problems/min-xor-value/
 **/