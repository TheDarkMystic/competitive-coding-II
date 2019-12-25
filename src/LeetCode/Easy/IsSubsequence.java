package LeetCode.Easy;

/**
 * @author jakadam on 2019-12-25
 */

/**
 * Given a string s and a string t, check if s is subsequence of t.
 *
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Example 1:
 * s = "abc", t = "ahbgdc"
 *
 * Return true.
 *
 * Example 2:
 * s = "axc", t = "ahbgdc"
 *
 * Return false.
 *
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
 *
 * Credits:
 * Special thanks to @pbrother for adding this problem and creating all test cases.
 */

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("bcd",
                "uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu" +
                        "uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu" +
                        "uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuubcd"));

        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));


    }

    public static boolean isSubsequence(String s, String t) {

        // empty string is a subsequence of all the strings
        if (s == null || s.length() == 0)
            return true;

        // s will be subsequence of t if the relative order of appearance of    characters in s is same as that of in t
        int index = 0;
        for (int i = 0; i < t.length(); i++) {// traverses given text
            // if characters match in text and pattern, increment pattern tracker
            if (s.charAt(index) == t.charAt(i)) {
                index++;
            }
            // if pattern tracker reached end of pattern, we have found all the
            // characters in pattern to be present in text in relative order
            if (index == s.length())
                return true;
        }
        return false;

    }
}
/**
 * Companies: Google
 * https://leetcode.com/problems/is-subsequence/
 * https://www.youtube.com/watch?v=UulHAjxjZ4o
 */