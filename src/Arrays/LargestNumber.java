package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/**
 * @author jakadam on 2020-01-06
 */

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * For example:
 *
 * Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 30, 34, 5, 9));
        System.out.println(largestNumber(list));
        //expected : 9534330
    }

    public static String largestNumber(final List<Integer> A) {
        /*
        This problem can be solved by sorting strings, not sorting integer. Define a
        comparator to compare strings by concat() right-to-left or left-to-right.
        */
        int len = A.size();
        String[] str = new String[len];

        // Convert Integer list to Array of String Objs
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(A.get(i));
        }

        //write comparator to sort the String obj array in descending order of the strings
        Arrays.sort(str, new Comparator<String>() {
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });

        // create string Builder from string array, we will perform some trimming operations
        // on the output before returning
        StringBuilder sb = new StringBuilder();
        for (String numStr : str) {
            sb.append(numStr);
        }

        // Remove the leading 0's
        while (sb.charAt(0) == '0' && sb.length() > 1)
            sb.deleteCharAt(0);

        // convert stringBuilder to string and return
        return sb.toString();
    }
}

/**
 Given a list of non negative integers, arrange them such that they form the largest number.

 For example:

 Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.
 */