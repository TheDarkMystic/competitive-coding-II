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

public class LongestCommonSubsequence {
    public static void main(String args[]) {
        LongestCommonSubsequenceSolver solver = new LongestCommonSubsequenceSolver();
        String str1=null, str2=null;

        //test1
        str1="abcde";
        str2="ace";

        //test2
        str1="abc";
        str2="abc";

        //test3
        str1="abc";
        str2="def";
        System.out.println((solver.solve(str1, str2)));
    }
}

class LongestCommonSubsequenceSolver{
    public int solve(String text1, String text2) {



        return 0;
    }

}