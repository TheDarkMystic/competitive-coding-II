package StackQueues;

import java.util.Stack;

/**
 * @author jakadam on 2019-12-19
 */

/**
 * https://www.interviewbit.com/problems/simplify-directory-path/
 * Given a string A representing an absolute path for a file (Unix-style).
 *
 * Return the string A after simplifying the absolute path.
 *
 * Note:
 *
 * Absolute path always begin with ’/’ ( root directory ).
 *
 * Path will not have whitespace characters.
 *
 *
 *
 * Input Format
 *
 * The only argument given is string A.
 * Output Format
 *
 * Return a string denoting the simplified absolue path for a file (Unix-style).
 * For Example
 *
 * Input 1:
 *     A = "/home/"
 * Output 1:
 *     "/home"
 *
 * Input 2:
 *     A = "/a/./b/../../c/"
 * Output 2:
 *     "/c"
 */


public class SimplifyDirectoryPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/home/"));

    }
    public static String simplifyPath(String A) {

        if(A.equals("") || A.equals("."))
            return "/";

        Stack<String> stack = new Stack<String>();
        // explode the string based on "/" to get the segments
        String[] str= A.split("/");

        for(String ele: str){
            //we skip the blanks and 'current dir' symbols
            if(ele.equals(".") || ele.isEmpty())
                continue;

            // if get 'one up', pop the non-empty stack, is stack is empty, skip
            if(ele.equals("..")){
                //testcase: "/../"
                if(stack.isEmpty()==false)
                    stack.pop();
                else
                    continue;

            }
            else// for remaining cases, push to stack
                stack.push(ele);
        }

        // pop the stack to build the path
        StringBuilder sb= new StringBuilder();
        //for each in java works like array on stack
        //https://stackoverflow.com/questions/14900710/stack-foreach-wrong-order
        //hence need not reverse in the end
        for(String s: stack){
            sb.append("/");
            sb.append(s);
        }

        //if in the end stack is empty, we are in root directory
        if(sb.length()==0)
            sb.append("/");


        return sb.toString();

    }
}

/**
 * "/home//foo/"
 *
 * "/../"
 *
 * https://leetcode.com/problems/simplify-path/#/description
 *
 * http://www.java2s.com/Tutorial/Java/0140__Collections/Aneasywaytoinitializeasetwithoutmanuallyaddingeachelement.htm
 *
 * https://stackoverflow.com/questions/39059514/check-if-stringbuffer-is-empty
 *
 * http://www.programcreek.com/2014/04/leetcode-simplify-path-java/
 *
 *
 * Let's break it down to componenets:
 * / -> root
 * /a -> in (a)
 * . -> THIS dir path
 * /a/./ -> still in /a
 * /a/./b -> in /a/b
 * .. -> go "up" one level
 * /a/./b/.. -> /a/b/.. -> /a
 * /a/./b/../.. -> /a/.. -> /
 * /a/./b/../../c -> /c
 */
