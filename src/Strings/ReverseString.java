package Strings;

/**
 * @author jakadam on 2019-12-25
 */

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/reverse-the-string/
 * Given a string A.
 *
 * Return the string A after reversing the string word by word.
 *
 * NOTE:
 *
 * A sequence of non-space characters constitutes a word.
 *
 * Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
 *
 * If there are multiple spaces between words, reduce them to a single space in the reversed string.
 *
 *
 *
 * Input Format
 *
 * The only argument given is string A.
 * Output Format
 *
 * Return the string A after reversing the string word by word.
 * For Example
 *
 * Input 1:
 *     A = "the sky is blue"
 * Output 1:
 *     "blue is sky the"
 *
 * Input 2:
 *     A = "this is ib"
 * Output 2:
 *     "ib is this"
 */
public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseWords1("the sky is blue"));
        System.out.println(reverseWords1("this is ib"));
        System.out.println(reverseWords2("the sky is blue"));
        System.out.println(reverseWords2("this is ib"));
    }

    //solution1
    public static String reverseWords1(String s) {

        //1. Split the string on " "
        //2. append the returned array in reverse order

        String[] arr = s.split(" ");

        StringBuilder res = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {
            res.append(arr[i] + " ");
        }

        res.deleteCharAt(res.length() - 1);

        return res.toString();
    }

    //solution2
    public static String reverseWords2(String s) {
        int len = s.length();
        // trim leading spaces
        int i = 0;
        while (i < len && s.charAt(i) == ' ')
            i++;

        // process remaining part of the string
        ArrayList<StringBuffer> words = new ArrayList<>();
        StringBuffer wordSb = new StringBuffer();
        for (; i < len; i++) {

            if (s.charAt(i) != ' ') {
                wordSb.append(s.charAt(i));
            } else {
                words.add(wordSb);
                wordSb = new StringBuffer();
            }
        }
        // add the last word to the list
        words.add(wordSb);

        //concatenate all the words in reverse order for return value
        StringBuffer ansSb = new StringBuffer();
        for (int j = words.size() - 1; j >= 0; j--) {
            ansSb.append(words.get(j) + " ");
        }
        ansSb.deleteCharAt(ansSb.length() - 1);
        return ansSb.toString();
    }
}
