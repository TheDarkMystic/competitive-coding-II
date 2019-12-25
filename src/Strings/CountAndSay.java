package Strings;

/**
 * @author jakadam on 2019-12-25
 */

/**
 * https://www.interviewbit.com/problems/count-and-say/
 * The count-and-say sequence is the sequence of integers beginning as follows:
 *
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as one 1 or 11.
 * 11 is read off as two 1s or 21.
 *
 * 21 is read off as one 2, then one 1 or 1211.
 *
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 *
 * Example:
 *
 * if n = 2,
 * the sequence is 11.
 */


public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSaySolver(5));
    }

    public static String countAndSaySolver(int n) {

        String curString = "1";
        //base case
        if (n == 0)
            return null;
        if (n == 1)
            return curString;

        for (int i = 0; i < n - 1; i++) { // we need to generate n sequences
            //initialize a new string which will act as input for next sequence
            StringBuffer nextString = new StringBuffer();
            //process current string to produce nextString/sequence
            int count = 1; // each character occurs at least once hence count starts from 1
            for (int j = 0; j < curString.length(); j++) {
                while (j < curString.length() - 1 && curString.charAt(j) == curString.charAt(j + 1)) {// count the repeating numbers
                    count++;
                    j++;
                }
                nextString.append(count).append(curString.charAt(j));
                count = 1;
            }
            curString = nextString.toString();

        }
        return curString;
    }
}
/**
 * http://www.programcreek.com/2014/03/leetcode-count-and-say-java/
 *
 * http://www.geeksforgeeks.org/look-and-say-sequence/
 */