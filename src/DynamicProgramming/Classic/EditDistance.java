package DynamicProgramming.Classic;

/**
 * @author jakadam on 2019-12-18
 */


/**
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 * https://leetcode.com/problems/edit-distance/
 */
public class EditDistance {
    public static void main(String args[]) {
        String str1 = "azced";
        String str2 = "abcdef";
        EditDistanceSolver editDistance = new EditDistanceSolver();
        int result = editDistance.editDistanceIterative(str1.toCharArray(), str2.toCharArray());
        System.out.print(result);
    }
}

class EditDistanceSolver {
    public int editDistanceIterative(char[] str1, char[] str2) {
        int len1 = str1.length;
        int len2 = str2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = i;
                    continue;
                }

                if (str1[i - 1] == str2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else {
                    dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
                }
            }
        }
        printActualEdits(dp, str1, str2);
        return dp[len1][len2];
    }

    public int editDistanceRecursive() {
        return 0;
    }


    private int min(int a, int b, int c) {
        int l = Math.min(a, b);
        return Math.min(l, c);
    }

    /**
     * Prints the actual edits which needs to be done.
     */
    public void printActualEdits(int T[][], char[] str1, char[] str2) {
        int i = T.length - 1;
        int j = T[0].length - 1;
        while (true) {
            if (i == 0 || j == 0) {
                break;
            }
            if (str1[i - 1] == str2[j - 1]) {
                i = i - 1;
                j = j - 1;
            } else if (T[i][j] == T[i - 1][j - 1] + 1) {
                System.out.println("Edit " + str2[j - 1] + " in string2 to " + str1[i - 1] + " in string1");
                i = i - 1;
                j = j - 1;
            } else if (T[i][j] == T[i - 1][j] + 1) {
                System.out.println("Delete in string1 " + str1[i - 1]);
                i = i - 1;
            } else if (T[i][j] == T[i][j - 1] + 1) {
                System.out.println("Delete in string2 " + str2[j - 1]);
                j = j - 1;
            } else {
                throw new IllegalArgumentException("Some wrong with given data");
            }

        }
    }
}