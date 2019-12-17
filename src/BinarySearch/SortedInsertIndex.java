package BinarySearch;

import java.util.Arrays;
import java.util.List;


/*
Given a sorted array and a target value, return the index if the target is found. If not,
return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.

[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

/*
1. You need to return the index of least element >= x.
2. Note that this is classic binary search. Instead of looking for the element x,you are
looking for the least elements >= x.
 */

public class SortedInsertIndex {

    public static void main(String args[]) {

        List<Integer> arr = Arrays.asList(1, 3, 5, 6);
        int target = 5;
        // expected ans:2
        final SortedInsertIndexSolver solver = new SortedInsertIndexSolver();
        System.out.println(solver.solve(arr, target));
    }
}

class SortedInsertIndexSolver {
    public int solve(List<Integer> arr, int target) {
        int len = arr.size();
        int high = len - 1;
        int low = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midEle = arr.get(mid);
            if (midEle == target) {
                return mid;
            } else if (midEle < target)
                low = mid + 1;
            else//midEle>target)
                high = mid - 1;
        }

        return low;
    }
}