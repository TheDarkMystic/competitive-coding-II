package Backtracking.SubsetGeneration;

/**
 * @author jakadam on 2019-12-23
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations
 * in C where the candidate numbers sums to T.
 *
 * Each number in C may only be used once in the combination.
 *
 *  Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * Example :
 *
 * Given candidate set 10,1,2,7,6,1,5 and target 8,
 *
 * A solution set is:
 *
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 *  Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
 * Example : itertools.combinations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 */
public class CombinationSumII {
    public static void main(String[] args) {


        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        //test1
        //ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(10, 1, 2, 7, 6, 1, 5));
        //int targetSum = 8;
        //test2
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(8, 10, 6, 11, 1, 16, 8));
        int targetSum = 28;
        // sort the input array to generate the subsets in sorted order
        Collections.sort(nums);

        dfs(nums, targetSum, 0, temp, res);
        // print subsets
        System.out.println(Arrays.toString(res.toArray()));

    }

    public static void dfs(ArrayList<Integer> nums, int targetSum, int start, ArrayList<Integer> temp,
                           ArrayList<ArrayList<Integer>> res) {

        /**
         * Problem is very similar to CombinationSumI, but here instead of a constraint on the subset size, we have of
         * constraint on the sum of the numbers of the subset
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
            // here we are NOT allowed to use the same number multiple times to achieve the sum, hence next iteration
            // starts from i+1 instead of i unlike in combinationSum problem
            // pls notice that the given number list may have duplicate numbers, but we can use them only as many
            // times as they occur
            dfs(nums, targetSum - nums.get(i), i + 1, temp, res);

            // remove the number from the current subset, in the next iteration of the for it will generate a subset
            // without a adding current number, so this covers second case
            temp.remove(temp.size() - 1);
        }
    }
}

/**
 * https://www.interviewbit.com/problems/combination-sum-ii/
 * https://www.youtube.com/watch?v=EYkV0OpIkgE
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */