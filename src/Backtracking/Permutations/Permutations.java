package Backtracking.Permutations;

/**
 * @author jakadam on 2019-12-23
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a collection of numbers, return all possible permutations.
 *
 * Example:
 *
 * [1,2,3] will have the following permutations:
 *
 * [1,2,3]
 * [1,3,2]
 * [2,1,3]
 * [2,3,1]
 * [3,1,2]
 * [3,2,1]
 *  NOTE
 *  No two entries in the permutation sequence should be the same.
 *  For the purpose of this problem, assume that all the numbers in the collection are unique.
 *  Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
 *
 * Example : next_permutations in C++ / itertools.permutations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 */

public class Permutations {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<Integer> temp= new ArrayList<>();
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();

        dfs(nums,temp,res);

        System.out.println(Arrays.toString(res.toArray()));
    }


    public static void dfs(ArrayList<Integer> nums, ArrayList<Integer> temp,
                           ArrayList<ArrayList<Integer>> res){

        /**
         * This problem is similar to Subset problem but there are a couple of differences
         * 1. in subset problem we generate subsets which may or may not have all the numbers from input list
         *      but permutations are all about the order of numbers, we must have ll the numbers from input
         *      for a permutation to be complete hence we add the size condition before adding the tempList to res
         * 2. in each iteration we process all the elements from the input hence we pass the entire nums list to next dfs call
         * instead of passing start index like we do in subset problem, which excludes elements before i th index
         * from processing
         */

        if(temp.size()==nums.size())
            res.add(new ArrayList<>(temp));

        for(int i=0;i<nums.size(); i++){
            // if the number is already in the current permutation, we cannot add it again, skip it
            if(temp.contains(nums.get(i)))
                continue;

            // else add the number to current permutation and recurse for remaining element
            temp.add(nums.get(i));
            dfs(nums, temp, res);
            temp.remove(temp.size()-1);
        }

    }
}
/**
 * https://www.interviewbit.com/problems/permutations/
 * https://www.youtube.com/watch?v=8t7bIHIr9JY&t=340s
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */