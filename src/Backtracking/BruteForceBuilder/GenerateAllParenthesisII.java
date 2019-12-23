package Backtracking.BruteForceBuilder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jakadam on 2019-12-23
 */

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed
 * parentheses of length 2*n.
 *
 * For example, given n = 3, a solution set is:
 *
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * Make sure the returned list of strings are sorted.
 */
public class GenerateAllParenthesisII {
    public static void main(String[] args) {
        ArrayList<String>res=new ArrayList<>();
        String tempStr="";
        int open=0,  close=0;
        dfs(3,res,tempStr, 0,0);
        System.out.println(Arrays.toString(res.toArray()));

    }

    public static void dfs(int n,ArrayList<String>res, String tempStr, int open, int close) {
        // if the length of temp string is 2*n, we have consumed all the opening and closing brackets and
        // we can say the combination is balanced as we allow closing bracket to be added only if we have
        // corresponding open bracket already added
        if(tempStr.length()==2*n){
            res.add(tempStr);
            //return control as we have consumed all the opening and closing brackets
            return;
        }

        // if we still have opening brackets left which can be added, then add a new opening bracket
        if(open<n)
            dfs(n,res,tempStr+"(",open+1, close);
        // add a closing bracket only if an extra opening bracket is present in the tempString
        if(close<open)
            dfs(n,res, tempStr+")",open, close+1);


    }
}

/**
 * https://www.interviewbit.com/problems/generate-all-parentheses-ii/
 * https://www.youtube.com/watch?v=sz1qaKt0KGQ
 *
 * Optional:
 *
 * https://www.tutorialspoint.com/java/lang/stringbuffer_setlength.htm
 * https://discuss.leetcode.com/topic/8724/easy-to-understand-java-backtracking-solution/13
 * https://www.youtube.com/watch?v=sz1qaKt0KGQ
 *
 * Other ways:
 * https://leetcode.com/problems/generate-parentheses/solution/
 */
