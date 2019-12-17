package BinarySearch;

import java.util.Arrays;
import java.util.List;

public class CountOccurSortedArray {

    public static void main(String args[]) {

        List<Integer> arr = Arrays.asList(5, 7, 7, 8, 8, 10);
        int target = 8;
        // expected ans:2

        //test 2:
        //List<Integer> arr= Arrays.asList(4, 7, 7, 7, 8, 10, 10 );
        //int target=3;
        // expected ans:0

        final CountOccurSortedArraySolver solver = new CountOccurSortedArraySolver();

        System.out.println(solver.solve(arr, target));
    }
}

class CountOccurSortedArraySolver {
    public int solve(List<Integer> arr, int target) {
        int firstOccurrence = binarySearch(arr, target, true);
        int lastOccurrence;
        if (firstOccurrence != -1) {
            lastOccurrence = binarySearch(arr, target, false);
            return (lastOccurrence - firstOccurrence + 1);
        } else
            return 0;


    }

    public int binarySearch(List<Integer> arr, int target, boolean searchFirst) {
        int len = arr.size();
        int high = len - 1;
        int low = 0;
        int result = -1;


        while (low <= high) {
            int mid = (low + high) / 2;
            int midEle = arr.get(mid);
            if (midEle == target) {
                result = mid;
                if (searchFirst == true)// search FirstOccurrence
                    high = mid - 1;
                else                //  search LastOccurrence
                    low = mid + 1;
            } else if (midEle < target)
                low = mid + 1;
            else//midEle>target)
                high = mid - 1;
        }

        return result;
    }

}


