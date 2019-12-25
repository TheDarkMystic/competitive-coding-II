package Strings;

/**
 * @author jakadam on 2019-12-25
 */

/**
 * https://www.interviewbit.com/problems/length-of-last-word/
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Given s = "Hello World",
 *
 * return 5 as length("World") = 5.
 *
 * Please make sure you try to solve this problem without using library functions.
 * Make sure you only traverse the string once.
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lastWordLen("Hello World"));
        System.out.println(lastWordLen("Hello World       "));
    }
    public static int lastWordLen(String str){
        int len=str.length();

        /**
         * start from the end of string and keep traversing the string backwards,
         * until we find first non-space character
         */
        int i=len-1;
        while(i>=0 && str.charAt(i)==' ')
            i--;

        /**
         * from first non-space character from end of string, keep  traversing string backward,
         * until we find next space, keep counting number of characters
         */
        int lastWordLen=0;
        while(i>=0 && str.charAt(i)!=' '){
            i--;
            lastWordLen++;

        }

        return lastWordLen;
    }
}

