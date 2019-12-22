package HeapsAndMaps.Heaps;

/**
 * @author jakadam on 2019-12-22
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given two arrays A & B of size N each.
 * Find the maximum N elements from the sum combinations (Ai + Bj) formed from elements in array A and B.
 *
 * For example if A = [1,2], B = [3,4], then possible pair sums can be 1+3 = 4 , 1+4=5 , 2+3=5 , 2+4=6
 * and maximum 2 elements are 6, 5
 *
 * Example:
 *
 * N = 4
 * a[]={1,4,2,3}
 * b[]={2,5,1,6}
 *
 * Maximum 4 elements of combinations sum are
 * 10   (4+6),
 * 9    (3+6),
 * 9    (4+5),
 * 8    (2+6)
 */
public class NMaxPairCombo {
    public static void main(String[] args) {
        int N=4;
        ArrayList<Integer> A= new ArrayList<>(Arrays.asList(1,4,2,3));
        ArrayList<Integer> B= new ArrayList<>(Arrays.asList(2,5,1,6));
        System.out.println(Arrays.toString(solve(A,B).toArray()));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        /**
         *  1.  Sort both the arrays in descending order
         *  2.  Initialize a minHeap
         *  3.  add the sum of elements to heap one by one till size reaches n
         *  4.  return the result
         */

        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B, Collections.reverseOrder());
        int n = A.size();
        // initialize minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // generate all possible combinations of sum using nested for loops and push them into heap
        // until heap size reaches N
        for (int num1 : A)
            for (int num2 : B) {
                int sum = num1 + num2;

                if (minHeap.size() < n)
                    minHeap.add(sum);
                else {
                    if (minHeap.peek() < sum) {
                        minHeap.poll();
                        minHeap.add(sum);
                    } else {
                        //as the arrays are sorted in descending order, when we encounter first sum<heapRoot
                        // that means further we will not get any sum > heapRoot hence break
                        break;
                    }
                }
            }

        // convert heap to ArrayList
        // Collections.reverseOrder() returns a Comparator using the inverse natural order.
        // You can get an inverted version of your own comparator using Collections.reverseOrder(myComparator).

        ArrayList<Integer> res = new ArrayList<>(minHeap);
        Collections.sort(res, Collections.reverseOrder());

        return res;
    }
}
/**
 * Tested on InterviewBit
 * https://www.interviewbit.com/problems/n-max-pair-combinations/
 */