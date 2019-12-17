package TwoPointers;

/**
 * @author jakadam on 2019-12-16
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find the intersection of two sorted arrays.
 * OR in other words,
 * Given 2 sorted arrays, find all the elements which occur in both the arrays.
 *
 * Example :
 *
 * Input :
 *     A : [1 2 3 3 4 5 6]
 *     B : [3 3 5]
 *
 * Output : [3 3 5]
 *
 * Input :
 *     A : [1 2 3 3 4 5 6]
 *     B : [3 5]
 *
 * Output : [3 5]
 *  NOTE : For the purpose of this problem ( as also conveyed by the sample case ),
 *  assume that elements that appear more than once in both arrays should be included
 *  multiple times in the final output.
 */


public class IntersectionOfSortedArrays {
    public static void main(String args[]) {
        IntersectionOfSortedArraysSolver solver = new IntersectionOfSortedArraysSolver();

        //test1
        //ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,3,3,4,5,6));
        //ArrayList<Integer> B = new ArrayList<>(Arrays.asList(3,3,5));

        //test2
        //ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,3,3,4,5,6));
        //ArrayList<Integer> B = new ArrayList<>(Arrays.asList(3,5));

        //test3
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(100000));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(100000));

        System.out.println(Arrays.toString(solver.solve(A, B).toArray()));
    }

}

class IntersectionOfSortedArraysSolver {
    public ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {
        int lenA = A.size();
        int lenB = B.size();
        int ptrA = 0, ptrB = 0;

        ArrayList<Integer> ansList = new ArrayList<>();

        while (ptrA < lenA && ptrB < lenB) {
            int valA = A.get(ptrA);
            int valB = B.get(ptrB);
            if (valA == valB) {
                ansList.add(valA);
                ptrA++;
                ptrB++;
            } else {
                if (valA < valB)
                    ptrA++;
                else
                    ptrB++;
            }
        }

        return ansList;
    }
}