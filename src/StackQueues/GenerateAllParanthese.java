package StackQueues;

/**
 * @author jakadam on 2019-12-19
 */


/**
 * https://www.interviewbit.com/problems/generate-all-parentheses/
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine
 * if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class GenerateAllParanthese {
    public static void main(String[] args) {
        System.out.println(isValid("\"()[]{}\""));
        System.out.println(isValid("([)]"));
    }

    public static int isValid(String a) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']', '[');
        for (Character c: a.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || !stack.peekLast().equals(map.get(c))) {
                    return 0;
                }
                stack.removeLast();
            } else {
                stack.add(c);
            }

        }
        return stack.isEmpty() ? 1: 0;
    }
}
