package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jakadam on 2019-12-16
 */

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 *
 *  Note: You have to modify the array A to contain the merge of A and B. Do not output anything
 *  in your code.
 * TIP: C users, please malloc the result into a new array and return the result.
 * If the number of elements initialized in A and B are m and n respectively, the resulting size
 * of array A after your code is executed should be m + n
 *
 * Example :
 *
 * Input :
 *          A : [1 5 8]
 *          B : [6 9]
 *
 * Modified A : [1 5 6 8 9]
 */
public class MergeTwoSortedListsII {

    public static void main(String args[]) {
        MergeTwoSortedListsIISolver solver = new MergeTwoSortedListsIISolver();

        //test1
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,5,8));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(6,9));

        System.out.println(Arrays.toString(solver.solve(A, B).toArray()));
    }
}

class MergeTwoSortedListsIISolver {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        //int lenA = A.size();
        //int lenB = B.size();
        int ptrA = 0, ptrB = 0;

        /**
         * Idea here is to weave elements from list B into list A. As we are not allowed to use extra
         * space, we will take advantage of the ArrayList in-built functions to add elements from B at
         * appropriate locations in A using A.add(index, element)
         */

        // once we have added all numbers from B into A, we are done. hence below condition

        while (ptrB < B.size()) {
            //scan the list A until we encounter a number which is greater or equal B.get(ptrB)
            while (ptrA < A.size() && A.get(ptrA) <= B.get(ptrB)) {
                ptrA++;
            }

            // insert B.get(ptrB) at the ptrA and progress in list B
            A.add(ptrA, B.get(ptrB));
            ptrB++;
        }
        return new ArrayList<Integer>(A);
    }
}