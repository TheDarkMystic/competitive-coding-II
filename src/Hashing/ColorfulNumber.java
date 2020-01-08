package Hashing;

import java.util.HashSet;

/**
 * @author jakadam on 2020-01-08
 */

/**
 * For Given Number N find if its COLORFUL number or not
 *
 * Return 0/1
 *
 * COLORFUL number:
 *
 * A number can be broken into different contiguous sub-subsequence parts.
 * Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
 * And this number is a COLORFUL number, since product of every digit of a contiguous
 * subsequence is different
 * Example:
 *
 * N = 23
 * 2 3 23
 * 2 -> 2
 * 3 -> 3
 * 23 -> 6
 * this number is a COLORFUL number since product of every digit of a sub-sequence are
 * different.
 *
 * Output : 1
 */

public class ColorfulNumber {
    public int colorful(int A) {

        /**
         * instead of using a string we can use while loop to seperate out digits of the number
         *          while(A!=0){
         *             nums.add(A%10);
         *             A=A/10;
         *         }
         *
         *         where nums is the ArrayList of integers
         *
         */
        String num= String.valueOf(A);
        HashSet<Long> set= new HashSet<>();

        for(int i=0; i<num.length(); i++){
            long prod=1;
            for(int j=i; j<num.length(); j++){
                prod*=(num.charAt(j)-'0');

                if(set.contains(prod))
                    return 0;
                else
                    set.add(prod);
            }
        }

        return 1;


    }
}

/*
Links:
https://www.interviewbit.com/problems/colorful-number/
 */