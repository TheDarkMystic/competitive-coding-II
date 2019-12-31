package DynamicProgramming.Classic;

/**
 * @author jakadam on 2019-12-31
 */

/**
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
 * Examples :
 *
 * Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
 * Output : 5
 * The longest common substring is “Geeks” and is of length 5.
 *
 * Input : X = “abcdxyz”, y = “xyzabcd”
 * Output : 4
 * The longest common substring is “abcd” and is of length 4.
 *
 * Input : X = “zxabcdezy”, y = “yzabcdezx”
 * Output : 6
 * The longest common substring is “abcdez” and is of length 6.
 * longest-common-substring
 */
public class LongestCommonSubstring {

    public static void main(String[] args) {
        System.out.println(longestCommonSubstring("zxabcdezy", "yzabcdezx"));
    }
    /**
     * Approach:
     *
     * Naive Approach:
     *
     * Check all the substrings from first string with second string anxd keep track of the maximum.
     *
     * Time Complexity: O(n2*m), O(n2) for the substring and O(m) for check all the substrings with
     * second string.
     *
     * Better Solution: Dynamic Programming–
     *
     * Earlier we have seen how to find “Longest Common Subsequence” in two given strings. Approach in
     * this problem will be quite similar to that.
     *
     * we will solve this problem in bottom-up manner. Create a matrix of size of m*n and store the
     * solutions of substrings to use them later.
     *
     * Base Cases: If any of the string is null then LCS will be 0.
     *
     * Check if ith character in one string A is equal to jth character in string B
     *
     * Case 1: both characters are same
     *
     * LCS[i][j] = 1 + LCS[i-1][j-1] (add 1 to the result and remove the last character from both the
     * strings and check the result for the smaller string.)
     *
     * Case 2: both characters are not same.
     *
     * LCS[i][j] = 0
     *
     * At the end, traverse the matrix and find the maximum element in it, This will the length of Longest
     * Common Substring.
     *
     * https://www.youtube.com/watch?v=5td2QH-x5ck
     */

    public static int longestCommonSubstring(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();

        int[][] dp = new int[lenA + 1][lenB + 1];
        int maxLen = 0;
        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else
                    dp[i][j] = 0; // here lc substring differs from lc sub sequence
            }
        }
        return maxLen;
    }
}
