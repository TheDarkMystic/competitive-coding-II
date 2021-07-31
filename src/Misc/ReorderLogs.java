package Misc;

/**
 * @author jakadam on 2020-04-14
 */
/**
 * You have an array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 *
 *     Each word after the identifier will consist only of lowercase letters, or;
 *     Each word after the identifier will consist only of digits.
 *
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log
 * has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered
 * lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should
 * be put in their original order.
 *
 * Return the final order of the logs.
 *
 *
 *
 * Example 1:
 *
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 *
 *
 *
 * Constraints:
 *
 *     0 <= logs.length <= 100
 *     3 <= logs[i].length <= 100
 *     logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */

/**
 * Updating this with non-bs variable names because once you get hired you will absolutely hate people who use cryptic names.
 *
 * my solution takes advantage of what we're guaranteed in the problem:
 *
 *     guaranteed to have a word following an identifier (allows me to use indexOf ' ' freely).
 *     letter logs need to be ordered lexicographically, so we can use built in compare function when we know we have two.
 *     number logs need to be sorted naturally, so we just say they're all "equal" to each other and trust java's built in sort feature to be stable.
 *     number logs need to be after letter logs, so once we find out they're different, we return one of the other and short-circuit.
 */

import java.util.Arrays;
class ReorderLogs {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if(!isDigit1 && !isDigit2) {
                // both letter-logs.
                int comp = split1[1].compareTo(split2[1]);
                if (comp == 0) return split1[0].compareTo(split2[0]);
                else return comp;
            } else if (isDigit1 && isDigit2) {
                // both digit-logs. So keep them in original order
                return 0;
            } else if (isDigit1 && !isDigit2) {
                // first is digit, second is letter. bring letter to forward.
                return 1;
            } else {
                //first is letter, second is digit. keep them in this order.
                return -1;
            }
        });
        return logs;
    }
}