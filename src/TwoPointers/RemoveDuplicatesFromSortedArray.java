package TwoPointers;

/**
 * @author jakadam on 2019-12-16
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Remove duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.
 *
 * Note that even though we want you to return the new length, make sure to change the original array as well in place
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 *  Example:
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String args[]) {
        RemoveDuplicatesFromSortedArraySolver solver = new RemoveDuplicatesFromSortedArraySolver();

        //test1
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5000, 5000, 5000));
        //test2
        //ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,1,2));
        System.out.println((solver.solve(A)));
    }



}

class RemoveDuplicatesFromSortedArraySolver{
    public int solve(ArrayList<Integer> arr) {
        //corner case
        if(arr==null || arr.size()<1)
            return 0;

        int n=arr.size();

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && arr.get(i).equals(arr.get(i+1)))
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