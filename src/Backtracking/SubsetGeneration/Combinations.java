package Backtracking.SubsetGeneration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author jakadam on 2019-12-23
 */

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.
 *
 * Make sure the combinations are sorted.
 *
 * To elaborate,
 *
 * Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
 * Entries should be sorted within themselves.
 * Example :
 * If n = 4 and k = 2, a solution is:
 *
 * [
 *   [1,2],
 *   [1,3],
 *   [1,4],
 *   [2,3],
 *   [2,4],
 *   [3,4],
 * ]
 *  Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
 * Example : itertools.combinations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 */

public class Combinations {
    public static void main(String[] args) {

        int n = 4;
        int k = 2;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        dfs(4, 2, 1, temp, res);
        // print subsets
        System.out.println(Arrays.toString(res.toArray()));

    }

    public static void dfs(int n, int k, int start, ArrayList<Integer> temp,
                           ArrayList<ArrayList<Integer>> res) {

        /**
         * Problem is very similar to Subsets, with additional invariant where we have to return subsets of only given size
         * So, we add a condition before the adding the current subset to the result list to check its size
         */

        // add the subset to the final list only if it is of the size =k
        if (temp.size() == k)
            res.add(new ArrayList<>(temp));

        for (int i = start; i <= n; i++) {
            //add the number to current subset
            temp.add(i);

            // call the function recursively after adding the number for remaining numbers
            dfs(n, k, i + 1, temp, res);

            // remove the number from the current subset, in the next iteration of the for it will generate a subset
            // without a adding current number, so this covers second case
            temp.remove(temp.size() - 1);
        }
    }
}

/**
 * https://www.interviewbit.com/problems/combinations/
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */