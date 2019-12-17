package DynamicProgramming.Classic;

/**
 * @author jakadam on 2019-12-17
 */

/**
 * Given two strings text1 and text2, return the length of their longest common sub-sequence.
 *
 * A sub-sequence of a string is a new string generated from the original string with some
 * characters(can be none) deleted without changing the relative order of the remaining characters.
 * (eg, "ace" is a sub-sequence of "abcde" while "aec" is not). A common subsequence of two strings
 * is a sub-sequence that is common to both strings.
 *
 *
 *
 * If there is no common sub-sequence, return 0.
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 *
 * Constraints:
 *
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * The input strings consist of lowercase English characters only.
 */


/*
  This is what the DP table looks like filled out for the 2 strings
  "AGGTAB" and "GXTXAYB".
     ""  A  G  G  T  A  B
  ""  0  0  0  0  0  0  0
  G   0  0  1  1  1  1  1
  X   0  0  1  1  1  1  1
  T   0  0  1  1  2  2  2
  X   0  0  1  1  2  2  2
  A   0  1  1  1  2  3  3
  Y   0  1  1  1  2  3  3
  B   0  1  1  1  2  3  4

*/


public class LongestCommonSubsequence {
    public static void main(String args[]) {
        LongestCommonSubsequenceSolver solver = new LongestCommonSubsequenceSolver();
        String str1 = null, str2 = null;

        //test1
        str1 = "abcde";
        str2 = "ace";

        //test2
        str1 = "abc";
        str2 = "abc";

        //test3
        str1 = "abc";
        str2 = "def";

        //test4
        str1 = "AGGTAB";
        str2 = "GXTXAYB";
        System.out.println("LCS String => " + (solver.printLCSLength(str1, str2)));
    }
}

class LongestCommonSubsequenceSolver {
    // method to calculate the length LCS string
    public int printLCSLength(String text1, String text2) {
    /*
      Base Case
      lcs("", anything...) == 0
      lcs(anything..., "") == 0
      lcs("", "") == 0
      A subproblem where either string is empty will have a result
      of 0. There can be nothing in common with an empty string and
      anything else.
    */
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();

        int lenStr1 = str1.length;
        int lenStr2 = str2.length;

        //initialize the DP table, one additional row and column will be added to accommodate the case of empty strings
        int[][] dp = new int[lenStr1 + 1][lenStr2 + 1];

        //populate the DP table, we are starting from index 1 for i and j as according to base case 1st row and
        //1st column will be always 0 as they show the result of comparison of empty strings with other strings
        // in java by default int array will have 0 value after initialization, hence need not initialize explicitly
        for (int i = 1; i < lenStr1 + 1; i++) {
            for (int j = 1; j < lenStr2 + 1; j++) {
                //characters match, trim both and find ans to lcs of trimmed strings, add 1 to it
                if (str1[i - 1] == str2[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else {
                    //characters do not match, take the max of lcs obtained by trimming either of the characters
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        // dp[lenStr1+][lenStr2] will hold the length of the lcs, return it
        int lcsLength = dp[lenStr1][lenStr2];

        //Optional : print the actual LCS string
        System.out.println("LCS String => " + printLCSString(str1, str2, dp, lcsLength));

        return dp[lenStr1][lenStr2];
    }

    // method to calculate the actual LCS string
    public String printLCSString(char[] str1, char[] str2, int[][] dp, int lcsLength) {

        int i = dp.length - 1;    //rows in dp table
        int j = dp[0].length - 1; //cols in dp table

        StringBuilder lcsString = new StringBuilder();

        // Start from the right-most-bottom-most corner of dp table and
        // one by one store characters in lcsString
        while (i > 0 && j > 0) {
            // If current character in str1[] and str2[] are same, then
            // current character is part of LCS
            if (str1[i - 1] == str2[j - 1]) {
                lcsString.append(str1[i - 1]);
                // reduce values of i, j , move diagonally up in the dp table
                i--;
                j--;

            } else {
                // If not same, then find the larger of two and
                // go in the direction of larger value
                if (dp[i - 1][j] > dp[i][j - 1])
                    i--;
                else
                    j--;
            }

        }
        return new String(lcsString.reverse());
    }


}




/*
    Link-
        https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence/problem
        https://leetcode.com/problems/longest-common-subsequence/
    Notes-
        LCS Video Explanation
        https://www.youtube.com/watch?v=ASoaQq66foQ

        https://www.geeksforgeeks.org/printing-longest-common-subsequence/
        5:25 onwards
        https://www.youtube.com/watch?time_continue=425&v=HgUOWB0StNE&feature=emb_logo

        All possible ways to solve LCS (w/ O(n) sol)
        https://leetcode.com/problems/delete-operation-for-two-strings/solution/

    */