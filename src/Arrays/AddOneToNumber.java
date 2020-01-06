package Arrays;

/**
 * @author jakadam on 2020-01-05
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a non-negative number represented as an array of digits,
 *
 * add 1 to the number ( increment the number represented by the digits ).
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * Example:
 *
 * If the vector has [1, 2, 3]
 *
 * the returned vector should be [1, 2, 4]
 *
 * as 123 + 1 = 124.
 *
 *  NOTE: Certain things are intentionally left unclear in this question which you should
 *  practice asking the interviewer.
 * For example, for this problem, following are some good questions to ask :
 * Q : Can the input have 0’s before the most significant digit. Or in other words,
 * is 0 1 2 3 a valid input?
 * A : For the purpose of this question, YES
 * Q : Can the output have 0’s before the most significant digit? Or in other words,
 * is 0 1 2 4 a valid output?
 * A : For the purpose of this question, NO. Even if the input has zeroes before the most
 * significant digit.
 */
public class AddOneToNumber {

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(Arrays.toString(plusOne(nums).toArray()));
    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {

        ArrayList<Integer> res = new ArrayList<>();

        //remove all leading 0's from the input array
        while (A.size() > 0 && A.get(0) == 0) {
            A.remove(0);
        }

        /*
        1.init carry as 1, as we have to add 1 to the num
        2.keep adding the sum at the 0th location of the arrayList
        */
        int sum = 0, carry = 1;
        int lenA = A.size();
        for (int i = lenA - 1; i >= 0; i--) {
            sum = A.get(i) + carry;
            res.add(0, sum % 10);
            carry = sum / 10;
        }

        //if carry is 1, add 1 to the 0th position to the answer list
        if (carry == 1)
            res.add(0, carry);

        return res;
    }

}
