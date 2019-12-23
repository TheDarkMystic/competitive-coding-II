package Backtracking.SubsetGeneration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author jakadam on 2019-12-23
 */

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C
 * where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The combinations themselves must be sorted in ascending order.
 * CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR …
 * (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
 * The solution set must not contain duplicate combinations.
 * Example,
 * Given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * <p>
 * [2, 2, 3]
 * [7]
 * Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
 * Example : itertools.combinations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 */

public class CombinationSumI {
    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 6, 7));
        int targetSum = 7;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        // sort the input array to generate the subsets in sorted order
        Collections.sort(nums);

        dfs(nums, targetSum, 0, temp, res);
        // print subsets
        System.out.println(Arrays.toString(res.toArray()));

    }

    public static void dfs(ArrayList<Integer> nums, int targetSum, int start, ArrayList<Integer> temp,
                           ArrayList<ArrayList<Integer>> res) {

        /**
         * Problem is very similar to Combinations, but here instead of a constraint on the subset size, we have of
         * constraint on the sum of the numbers of the subset. Here, we are NOT allowed to use the same number multiple
         * times to achieve the sum.
         * So, we check if the sum of the numbers is equal to given number before adding it to the result list
         */


        // return the control that is stop further expanding the tree as the input list is in sorted order
        // all the numbers in the list after the last added number are greater, hence targetSum will be exceeded
        // in call the cases
        if (targetSum < 0)
            return;

        // add the subset to the final list only if sum of the numbers in the subset is equal to given number
        // in the testcase
        if (targetSum == 0) {
            res.add(new ArrayList<>(temp));
            // return the control that is stop further expanding the tree as the input list is in sorted order
            // all the numbers in the list after the last added number are greater, hence targetSum will be exceeded
            // in call the cases
            return;
        }

        for (int i = start; i < nums.size(); i++) {
            //Duplicates in candidateList cause duplicate combinations in result,
            if (i > start && nums.get(i) == nums.get(i - 1))
                continue;

            //add the number to current subset
            temp.add(nums.get(i));

            // call the function recursively after adding the number for remaining numbers,
            // here we are allowed to use the same number multiple times to achieve the sum, hence next iteration
            // starts from i instead of i+1 unlike in combination problem
            dfs(nums, targetSum - nums.get(i), i, temp, res);

            // remove the number from the current subset, in the next iteration of the for it will generate a subset
            // without a adding current number, so this covers second case
            temp.remove(temp.size() - 1);


        }
    }
}

/**
 * https://www.interviewbit.com/problems/combination-sum/
 * https://www.youtube.com/watch?v=9lQnt4p7_nE
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */
