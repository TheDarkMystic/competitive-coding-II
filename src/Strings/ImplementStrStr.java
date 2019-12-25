package Strings;

/**
 * @author jakadam on 2019-12-25
 */

/**
 * https://www.interviewbit.com/problems/implement-strstr/
 *
 * Another question which belongs to the category of questions which are intentionally stated vaguely.
 * Expectation is that you will ask for correct clarification or you will state your assumptions before you
 * start coding.
 *
 * Implement strStr().
 *
 *  strstr - locate a substring ( needle ) in a string ( haystack ).
 *  Try not to use standard library string functions for this question.
 *
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * NOTE: Good clarification questions:
 * What should be the return value if the needle is empty?
 * What if both haystack and needle are empty?
 * For the purpose of this problem, assume that the return value should be -1 in both cases
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        String text="asb dfd ijijdfd l";
        String pattern="ijd";
        System.out.println(strStr1(text,pattern));
        System.out.println(strStr2(text,pattern));
    }
    //solution1
    public static int strStr1(final String text, final String pattern) {
        int start=0;// scans the text,used for tracking start of pattern in the given text
        int tempStart=start;// scans the text starting from start, used for matching pattern chars to text chars
        int patStart=0;

        while(tempStart<text.length() && patStart<pattern.length())
        {
            //text and pattern have the same characters
            if(text.charAt(tempStart)==pattern.charAt(patStart)){
                tempStart++;
                patStart++;
            }
            else{
                //text and pattern have characters mismatch
                start++;
                tempStart=start;
                patStart=0;
            }

            if(patStart==pattern.length())
                return start;
        }
        return -1;
    }

    //solution2
    public static int strStr2(final String text, final String pattern) {
        int lenText = text.length();
        int lenPat = pattern.length();

        char[] txt = text.toCharArray();
        char[] pat = pattern.toCharArray();

        for (int i = 0; i <= lenText - lenPat; i++) {

            int j = 0;
            while (j < lenPat && txt[i + j] == pat[j])
                j++;

            // pattern found
            if (j == lenPat)
                return i;
        }

        return -1;
    }

}
