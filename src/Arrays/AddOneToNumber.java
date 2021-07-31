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

//first push from mac air
import java.util.*;
public class AddOneToNumber {

    public static void main(String []args){

        int[] arr={2, 3, 7, 11, 15};
        ArrayList<Integer> a = new ArrayList();
        for(int i=0;i <arr.length;i++){
            a.add(arr[i]);
        }
        int b=9;


        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        // int index=0;
        for(int i=0; i< a.size();i++){
            if(map.get(a.get(i)) != null){

            }
            else{
                map.put(a.get(i),i);
            }

        }
        // int in=0;
        for(int i=0; i< a.size();i++){
            if(map.containsKey(b-a.get(i))){
                System.out.print(i);
                System.out.print(map.get(b-a.get(i)));
            }
        }
    }

}
