package Strings;

/**
 * @author jakadam on 2019-12-25
 */

/**
 * You are given a string S, and you have to find all the amazing substrings of S.
 *
 * Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
 *
 * Input
 *
 * Only argument given is string S.
 * Output
 *
 * Return a single integer X mod 10003, here X is number of Amazing Substrings in given string.
 * Constraints
 *
 * 1 <= length(S) <= 1e6
 * S can have special characters
 * Example
 *
 * Input
 *     ABEC
 *
 * Output
 *     6
 *
 * Explanation
 * 	Amazing substrings of given string are :
 * 	1. A
 * 	2. AB
 * 	3. ABE
 * 	4. ABEC
 * 	5. E
 * 	6. EC
 * 	here number of substrings are 6 and 6 % 10003 = 6.
 */
public class AmazingSubarrays {
    public static void main(String[] args) {
        System.out.println(countAmazingSubarrays("ABEC"));
    }

    public static int countAmazingSubarrays(String s){
        int len=s.length();
        String vowel= "aeiouAEIOU";
        /**
         * Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
         * if we subtract the index of the occurrence of a vowel from the length of the string, we get the
         * number of substrings that can be generated starting from the index of vowel
         */
        int substringCount=0;
        for(int i=0; i<len; i++){
            if(vowel.contains(String.valueOf(s.charAt(i))))
                substringCount+=(len-i)%10003;

        }
        return substringCount%10003;

        /**
         * In this question, counting repeated substrings is allowed. If it was not allowed, we would have used a Set
         * to keep track of number of unique substrings
         */
    }
}
