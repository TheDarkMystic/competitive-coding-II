package TwoPointers;

/**
 * @author jakadam on 2019-12-16
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Remove Duplicates from Sorted Array
 *
 * Given a sorted array, remove the duplicates in place such that each element can appear atmost
 * twice and return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * Note that even though we want you to return the new length, make sure to change the original
 * array as well in place
 *
 * For example,
 * Given input array A = [1,1,1,2],
 *
 * Your function should return length = 3, and A is now [1,1,2].
 */
public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String args[]) {
        RemoveDuplicatesFromSortedArrayIISolver solver = new RemoveDuplicatesFromSortedArrayIISolver();

        //test1
        //ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5000, 5000, 5000));
        //test2
        //ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,1,2));
        //test3
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0, 0, 0, 1, 1, 2, 2, 3));
        System.out.println((solver.solve(A)));
    }

}

class RemoveDuplicatesFromSortedArrayIISolver {
    public int solve(ArrayList<Integer> arr) {
        //corner case
        //it is permitted to have 2 duplicates in array at most
        int n = arr.size();
        if (n <= 2)
            return n;

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i < n - 2 && arr.get(i).equals(arr.get(i+1)) && arr.get(i).equals( arr.get(i+2)))
                continue;
            else {
                arr.set(count,arr.get(i));
                count++;
            }
        }
        System.out.println(Arrays.toString(arr.toArray()));
        return count;
    }
}