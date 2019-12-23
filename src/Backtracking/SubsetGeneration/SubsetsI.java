package Backtracking.SubsetGeneration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author jakadam on 2019-12-23
 */

/**
 * Given a set of distinct integers, S, return all possible subsets.
 *
 *  Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * Also, the subsets should be sorted in ascending ( lexicographic ) order.
 * The list is not necessarily sorted.
 * Example :
 *
 * If S = [1,2,3], a solution is:
 *
 * [
 *   [],
 *   [1],
 *   [1, 2],
 *   [1, 2, 3],
 *   [1, 3],
 *   [2],
 *   [2, 3],
 *   [3],
 * ]
 */
public class SubsetsI {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3));

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        // sort the input array to generate the subsets in sorted order
        Collections.sort(nums);
        dfs(nums, 0, temp, res);
        // print subsets
        System.out.println(Arrays.toString(res.toArray()));

    }

    public static void dfs(ArrayList<Integer> nums, int start, ArrayList<Integer> temp,
                           ArrayList<ArrayList<Integer>> res) {

        /**
         * we scan the list of given numbers, to generate all possible subsets of the given set, we have to make
         * a decision at every number that is to either include the number into the current subset or not. These
         * are 2 choices at each number so it causes 2^n possible solutions.
         *
         * If we include the number we call the dfs function recursively on the remaining numbers from given set
         * and if we do not include the number in the subset then also we call the dfs recursively on remaining numbers
         * to generate all possible subsets.
         *
         * At the start of each dfs call we will have a possible subset, we include it in the result list.
         */

        // for first call it will add empty set to the result list, which is a valid subset and
        // for subsequent calls it will keep adding new subsets to result list
        res.add(new ArrayList<>(temp));

        for (int i = start; i < nums.size(); i++) {
            //add the number to current subset
            temp.add(nums.get(i));

            // call the function recursively after adding the number for remaining numbers
            dfs(nums, i + 1, temp, res);

            // remove the number from the current subset, in the next iteration of the for it will generate a subset
            // without a adding current number, so this covers second case
            temp.remove(temp.size() - 1);
        }
    }
}
/**
 *  https://www.interviewbit.com/problems/subset/
 *  https://www.youtube.com/watch?v=MsHFNGltIxw
 *  https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */