package StackQueues;

/**
 * @author jakadam on 2019-12-18
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array of integers, find the nearest smaller number for every element such that the smaller element is on left side.
 * Examples:
 *
 * Input:  arr[] = {1, 6, 4, 10, 2, 5}
 * Output:         {_, 1, 1,  4, 1, 2}
 * First element ('1') has no element on left side. For 6,
 * there is only one smaller element on left side '1'.
 * For 10, there are three smaller elements on left side (1,
 * 6 and 4), nearest among the three elements is 4.
 *
 * Input: arr[] = {1, 3, 0, 2, 5}
 * Output:        {_, 1, _, 0, 2}
 * Expected time complexity is O(n).
 *
 * https://www.interviewbit.com/problems/nearest-smaller-element/
 */
public class NearestSmallerElement {
    public static void main(String args[]) {
        NearestSmallerElementSolver solver = new NearestSmallerElementSolver();
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 6, 4, 10, 2, 5));
        ArrayList<Integer> nums1 = new ArrayList<>(Arrays.asList(1, 3, 0, 2, 5));
        System.out.println(Arrays.toString(solver.solve(nums).toArray()));
        System.out.println(Arrays.toString(solver.solve(nums1).toArray()));
    }
}

class NearestSmallerElementSolver {
    public ArrayList<Integer> solve(ArrayList<Integer> nums) {
        int len = nums.size();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            /**
             * while stack is not empty and the top of stack is greater or equal to current
             * number, keep popping the stack
             */
            while (stack.isEmpty() == false && stack.peek() >= nums.get(i)) {
                stack.pop();
            }
            // if stack is empty add -1 to res, as there is no smaller element on left side
            if (stack.isEmpty() == true)
                res.add(-1);
            else// stack top is the smaller element on left
                res.add(stack.peek());

            // add the current element to stack for future calculations
            stack.push(nums.get(i));
        }
        return res;
    }
}