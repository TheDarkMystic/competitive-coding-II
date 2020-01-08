package StackQueues;

/**
 * @author jakadam on 2019-12-19
 */
/**
 * Given an array of integers A. There is a sliding window of size B which
 * is moving from the very left of the array to the very right.
 * You can only see the w numbers in the window. Each time the sliding window moves
 * rightwards by one position. You have to find the maximum for each window.
 * The following example will give you more clarity.
 *
 * The array A is [1 3 -1 -3 5 3 6 7], and B is 3.
 *
 * Window position	Max
 * ———————————-	————————-
 * [1 3 -1] -3 5 3 6 7	3
 * 1 [3 -1 -3] 5 3 6 7	3
 * 1 3 [-1 -3 5] 3 6 7	5
 * 1 3 -1 [-3 5 3] 6 7	5
 * 1 3 -1 -3 [5 3 6] 7	6
 * 1 3 -1 -3 5 [3 6 7]	7
 * Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].
 *
 * Note: If B > length of the array, return 1 element with the max of the array.
 *
 *
 *
 * Input Format
 *
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 * Output Format
 *
 * Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1]
 * For Example
 *
 * Input 1:
 *     A = [1, 3, -1, -3, 5, 3, 6, 7]
 *     B = 3
 * Output 1:
 *     C = [3, 3, 5, 5, 6, 7]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {

        SlidingWindowMaximumSolver solver = new SlidingWindowMaximumSolver();

        System.out.println(Arrays.toString(solver.slidingMaximum(new ArrayList<>
                (Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 1)), 3).toArray()));
        //Ans:[3, 3, 4, 4, 5, 6, 6]
        System.out.println(Arrays.toString(solver.slidingMaximum(new ArrayList<>
                (Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)), 2).toArray()));
        //Ans: 10 9 8 7 6 5 4 3 2
    }
}

class SlidingWindowMaximumSolver {
    public ArrayList<Integer> slidingMaximum(final ArrayList<Integer> nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        if (nums == null || nums.size() == 0)
            return result;

        LinkedList<Integer> deque = new LinkedList<>();

        /**
         * deque is a DS which is implemented using doubly LL, it allows adding and removing nodes from both the ends
         * 1. we are pushing and popping indices in and out of the deque and not the elements
         * 2. we keep only those indices in the deque which are part of the current window of size k
         * 3. if the element corresponding to an index in the list is lesser than the current element, we remove that index because,
         * the element corresponding to this index can never be the maximum element in the current window or any subsequent window of size k
         */

        for (int i = 0; i < nums.size(); i++) {

            //remove element out of window
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                //System.out.print(i - k);

                deque.poll();
            }

            //System.out.println();
            // make sure deque is in descending order
            while (!deque.isEmpty() && nums.get(deque.peekLast()) < nums.get(i)) {
                deque.removeLast();
            }

            //push current element to deque
            deque.offer(i);

            if (i + 1 >= k)
                result.add(nums.get(deque.peek()));
        }
        return result;

        /**
         * 1. LinkedList.peekFirst() method retrieves, but does not remove, the first element of this list,
         *      or returns null if this list is empty.
         * 2. LinkedList.poll() method retrieves and removes the head (first element) of this list
         * 3. LinkedList.offer(E e) method adds the specified element as the tail (last element) of this list.
         * 4. LinkedList.removeLast() method removes and returns the last element from this list.
         */
    }
}

/**
 * https://www.youtube.com/watch?v=39grPZtywyQ
 * https://www.interviewbit.com/problems/sliding-window-maximum/
**/