package TwoPointers;

/**
 * @author jakadam on 2019-12-16
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given an array ‘A’ of sorted integers and another non negative integer k,
 * find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
 *
 *  Example: Input :
 *     A : [1 3 5]
 *     k : 4
 *  Output : YES as 5 - 1 = 4
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 *
 * Try doing this in less than linear space complexity.
 */
public class DiffK {
    public static void main(String args[]) {
        DiffKSolver solver = new DiffKSolver();

        //test1
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,3,5));
        int target=4;
        System.out.println((solver.solve(A,target)));
    }
}
class DiffKSolver{
    public int solve(ArrayList<Integer> A, int target){

        int len=A.size();
        int left=0;
        int right=1;

        while(left<len && right<len){
            int diff=A.get(right)-A.get(left);
            if(diff==target && left!=right)
                return 1;

            if(diff>target)
                left++;
            else
                right++;

        }
        return 0;
    }
}

/**
 * DiffkII: https://www.interviewbit.com/problems/diffk-ii/
 * Given an array A of integers and another non negative integer k,
 * find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
 *
 * Example :
 *
 * Input :
 *
 * A : [1 5 3]
 * k : 2
 * Output :
 *
 * 1
 * as 3 - 1 = 2
 *
 * Return 0 / 1 for this problem
 */

class Diff2Solver {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int diffPossible(final List<Integer> A, int B) {
        HashSet<Integer> set = new HashSet<>();

        for (Integer num : A) {
            if (set.contains(num + B) || set.contains(num - B))
                return 1;
            else
                set.add(num);
        }
        return 0;
    }
}

/*

Notes:
https://www.geeksforgeeks.org/find-a-pair-with-the-given-difference/
nested loops -O(n^2)
2 pointers approach -O(n)
Using BinarySearch -O(nLogn)

*/