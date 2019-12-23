package Backtracking.SubsetGeneration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author jakadam on 2019-12-23
 */

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 *
 *  Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * The subsets must be sorted lexicographically.
 * Example :
 * If S = [1,2,2], the solution is:
 *
 * [
 * [],
 * [1],
 * [1,2],
 * [1,2,2],
 * [2],
 * [2, 2]
 * ]
 */
public class SubsetsII {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 2));

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
         * Problem is very similar to Subsets, with additional scenario that we may have duplicate numbers in the given set
         *
         * we scan the list of given numbers, to generate all possible subsets of the given set, we have to make
         * a decision at every number that is to either include the number into the current subset or not. These
         * are 2 choices at each number so it causes 2^n possible solutions.
         *
         * If we include the number we call the dfs function recursively on the remaining numbers from given set
         * and if we do not include the number in the subset then also we call the dfs recursively on remaining numbers
         * to generate all possible subsets.
         *
         * At the start of each dfs call we will have a possible subset, we include it in the result list.
         *
         * for Duplicate handling:
         * If the current number is identical to the previous number in the given array, expanding the tree starting from that it will
         * result in duplicate subsets hence we add a condition to the inside the for loop
         *
         */

        // for first call it will add empty set to the result list, which is a valid subset and
        // for subsequent calls it will keep adding new subsets to result list
        res.add(new ArrayList<>(temp));

        for (int i = start; i < nums.size(); i++) {
            //skip the iteration because it will generate duplicate subsets
            if(i>0 && nums.get(i)==nums.get(i-1))
                continue;

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
 *  https://www.interviewbit.com/problems/subsets-ii/
 *  https://www.youtube.com/watch?v=0ElTC4XiDvc&t=1s
 *  https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */