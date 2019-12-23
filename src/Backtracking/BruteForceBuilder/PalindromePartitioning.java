package Backtracking.BruteForceBuilder;

/**
 * @author jakadam on 2019-12-23
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a string s, partition s such that every string of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return
 *
 *   [
 *     ["a","a","b"]
 *     ["aa","b"],
 *   ]
 *  Ordering the results in the answer : Entry i will come before Entry j if :
 * len(Entryi[0]) < len(Entryj[0]) OR
 * (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
 * *
 * *
 * *
 * (len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
 * In the given example,
 * ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")
 */

public class PalindromePartitioning {
    public static void main(String[] args) {
        String str = "aaba";
        int len = str.length();
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        ArrayList<String> tempList = new ArrayList<>();
        int start = 0;
        dfs(res, tempList, str, start);

        System.out.println(Arrays.toString(res.toArray()));

    }

    /**
     * palindrome partition
     *
     * @param list
     * @param tempList
     * @param s
     * @param start
     */
    public static void dfs(ArrayList<ArrayList<String>> list, ArrayList<String> tempList, String s, int start) {
        //when the start reaches the end of the given string, we have processed the entire string and
        // generated the palindromes, add it to the result
        if (start == s.length())
            list.add(new ArrayList<>(tempList));
        else {
            // at each character slice the string from [start to i] , check if the slice is palindrome or not
            //if the slice is palindrome, add it to current list of partition, and recurse for the remaining
            // part of the string

            // it is very similar to the subset problem with palindrome condition

            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    tempList.add(s.substring(start, i + 1));//start inclusive, end exclusive
                    dfs(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    /**
     * Checks if the slice of input string is palindrome or not
     *
     * @param str
     * @param start
     * @param end
     * @return
     */
    public static boolean isPalindrome(String str, int start, int end) {

        while (start < end) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else
                return false;
        }
        return true;
    }
}

/**
 * https://www.interviewbit.com/problems/palindrome-partitioning/
 * https://www.youtube.com/watch?v=4ykBXGbonlA
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 *
 * Optional Comments:
 * https://discuss.leetcode.com/topic/46161/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/2
 *
 * same as combination sum i
 * and ii
 * only following line changed
 *
 * tempList.add(str.substring(start, i+1));
 */