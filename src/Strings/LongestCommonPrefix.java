package Strings;

/**
 * @author jakadam on 2019-12-25
 */

/**
 * https://www.interviewbit.com/problems/longest-common-prefix/
 * Given the array of strings A,
 * you need to find the longest string S which is the prefix of ALL the strings in the array.
 *
 * Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1
 * and S2.
 *
 * For Example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".
 *
 *
 *
 * Input Format
 *
 * The only argument given is an array of strings A.
 * Output Format
 *
 * Return longest common prefix of all strings in A.
 * For Example
 *
 * Input 1:
 *     A = ["abcdefgh", "aefghijk", "abcefgh"]
 * Output 1:
 *     "a"
 *     Explanation 1:
 *         Longest common prefix of all the strings is "a".
 *
 * Input 2:
 *     A = ["abab", "ab", "abcd"];
 * Output 2:
 *     "ab"
 *     Explanation 2:
 *         Longest common prefix of all the strings is "ab".
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] A = {"abcdefgh", "aefghijk", "abcefgh"};
        String[] B={"abab", "ab", "abcd"};
        System.out.println(longestCommonPrefix(A));
        System.out.println(longestCommonPrefix(B));
    }

    public static String longestCommonPrefix(String[] A) {
        int len=A.length;
        int minLength=findMinLength(A);
        StringBuffer commonPrefix=new StringBuffer();
        //run a loop till the length of shortest string from the array
        //if we consider the array of strings as 2D matrix outer loop goes column wise
        for(int i=0;i<minLength; i++){
            //in ith column check if all the strings have common character
            char curChar=A[0].charAt(i);
            int count=0;
            //if we consider the array of strings as 2D matrix outer loop goes row wise
            for(int j=0; j<len; j++){

                if(A[j].charAt(i)==curChar)
                    count++;
                else// character mismatch found, whatever we have collected in the commonPrefix that is the
                    // answer as further traversing is fruitless
                    return commonPrefix.toString();
            }
            // if character is commonPrefix in all strings, add it to return value
            if(count==len)
                commonPrefix.append(curChar);
        }

        return commonPrefix.toString();
    }

    /**
     * Calculates the length of shortest string out of array of Strings
     * @param A
     * @return
     */
    public static int findMinLength(String[] A){
        int minLength=Integer.MAX_VALUE;
        for(String str:A){
            minLength=Math.min(minLength,str.length());
        }
        return minLength;
    }
}
