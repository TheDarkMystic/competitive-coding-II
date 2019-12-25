package Strings;

/**
 * @author jakadam on 2019-12-25
 */

import java.math.BigInteger;

/**
 * https://www.interviewbit.com/problems/compare-version-numbers/
 * Compare two version numbers version1 and version2.
 *
 * If version1 > version2 return 1,
 * If version1 < version2 return -1,
 * otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level
 * revision of the second first-level revision.
 *
 * Here is an example of version numbers ordering:
 *
 * 0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
 */
public class CompareVersions {
    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.13.4"));
        System.out.println(compareVersion("4444444444444444444444444", "444444444444444444444444"));
    }

    public static int compareVersion(String A, String B) {
        //split the strings on .
        String[] str1 = A.split("\\.");
        String[] str2 = B.split("\\.");

        int len1 = str1.length;
        int len2 = str2.length;

        //find the longer version in size
        int longer = Math.max(len1, len2);

        for (int i = 0; i < longer; i++) {
            //check for arraySize and then extract one item from each array for comparison
            BigInteger i1 = i < len1 ? new BigInteger(str1[i]) : BigInteger.ZERO;
            BigInteger i2 = i < len2 ? new BigInteger(str2[i]) : BigInteger.ZERO;

            //compare the versions
            int v = i1.compareTo(i2);
            if (v != 0)
                return v;
        }
        return 0;
    }
}
/**
 https://discuss.leetcode.com/topic/8316/simple-java-solution/9

 https://www.tutorialspoint.com/java/math/biginteger_compareto.htm

 failed test cases for which BigInteger is used

 444444444444444444444444
 4444444444444444444444444
 **/