package StackQueues;

import java.util.Stack;

/**
 * @author jakadam on 2019-12-19
 */

/**
 * Given a string S, reverse the string using stack.
 *
 * Example :
 *
 * Input : "abc"
 * Return "cba"
 */

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString("abc"));
    }
    public static String reverseString(String A) {

        Stack<Character> stk = new Stack<Character>();
        for(int i=0;i<A.length();i++) {
            stk.push(A.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        while(!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        return sb.toString();

    }
}