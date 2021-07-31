package Strings;

import java.util.HashSet;


/**
 * @author jakadam on 2020-02-04
 */

/**
 * The above solution requires at most 2n steps. In fact, it could be optimized to
 * require only n steps. Instead of using a set to tell if a character exists or not,
 * we could define a mapping of the characters to its index. Then we can skip the characters
 * immediately when we found a repeated character.
 *
 * The reason is that if s[j]s[j] have a duplicate in the range [i, j)[i,j) with index j'j
 * ′
 *  , we don't need to increase ii little by little. We can skip all the elements in the range
 *  [i, j'][i,j
 * ′
 *  ] and let ii to be j' + 1j
 * ′
 *  +1 directly.
 *
 *  Example:
 * Input:
 * 2
 * abababcdefababcdab
 * geeksforgeeks
 *
 * Output:
 * 6
 * 7
 */

public class LongestSubstringWithoutRepeatingChar {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashSet<Character> set = new HashSet<>();
        int result = 1;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                result = Math.max(result, set.size());
            } else {
                while (i < j) {
                    if (s.charAt(i) == c) {
                        i++;
                        break;
                    }

                    set.remove(s.charAt(i));
                    i++;
                }
            }
        }

        return result;
    }
}
/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 */