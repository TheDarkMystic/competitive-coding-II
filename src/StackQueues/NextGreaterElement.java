package StackQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * @author jakadam on 2019-12-19
 */

/**
 * Given an array, print the Next Greater Element (NGE) for every element.
 * The Next greater Element for an element x is the first greater element on the right
 * side of x in array. Elements for which no greater element exist, consider next greater
 * element as -1.
 *
 * Examples:
 *
 * For any array, rightmost element always has next greater element as -1.
 * For an array which is sorted in decreasing order, all elements have next greater element
 * as -1.
 * For the input array [4, 5, 2, 25}, the next greater elements for each element are as
 * follows.
 * Element       NGE
 *    4      -->   5
 *    5      -->   25
 *    2      -->   25
 *    25     -->   -1
 * d) For the input array [13, 7, 6, 12}, the next greater elements for each element are
 * as follows.
 *
 * https://www.geeksforgeeks.org/next-greater-element/
 */


public class NextGreaterElement {
    public static void main(String args[]) {
        NextGreaterElementSolver solver = new NextGreaterElementSolver();
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 6, 4, 10, 2, 5));
        ArrayList<Integer> nums1 = new ArrayList<>(Arrays.asList(1, 3, 0, 2, 5));
        System.out.println(Arrays.toString(solver.solve(nums).toArray()));
        System.out.println(Arrays.toString(solver.solve(nums1).toArray()));
    }
}

class NextGreaterElementSolver {
    public ArrayList<Integer> solve(ArrayList<Integer> nums) {
        int len = nums.size();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = len-1; i>=0; i--) {
            /**
             * while stack is not empty and the top of stack is greater or equal to current
             * number, keep popping the stack
             */
            while (stack.isEmpty() == false && stack.peek() <= nums.get(i)) {
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

        Collections.reverse(res);
        return res;
    }
}