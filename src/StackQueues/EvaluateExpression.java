package StackQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author jakadam on 2019-12-19
 */

/**
 * https://www.interviewbit.com/problems/evaluate-expression/
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 *
 *
 * Input Format
 *
 * The only argument given is character array A.
 * Output Format
 *
 * Return the value of arithmetic expression formed using reverse Polish Notation.
 * For Example
 *
 * Input 1:
 *     A =   ["2", "1", "+", "3", "*"]
 * Output 1:
 *     9
 * Explaination 1:
 *     starting from backside:
 *     *: ( )*( )
 *     3: ()*(3)
 *     +: ( () + () )*(3)
 *     1: ( () + (1) )*(3)
 *     2: ( (2) + (1) )*(3)
 *     ((2)+(1))*(3) = 9
 *
 * Input 2:
 *     A = ["4", "13", "5", "/", "+"]
 * Output 2:
 *     6
 * Explaination 2:
 *     +: ()+()
 *     /: ()+(() / ())
 *     5: ()+(() / (5))
 *     1: ()+((13) / (5))
 *     4: (4)+((13) / (5))
 *     (4)+((13) / (5)) = 6
 */
public class EvaluateExpression {
    public static void main(String[] args) {
        ArrayList<String> str1 = new ArrayList<>(Arrays.asList("4", "13", "5", "/", "+"));
        ArrayList<String> str2 = new ArrayList<>(Arrays.asList("2", "1", "+", "3", "*"));
        System.out.println(evalRPN(str1));
        System.out.println(evalRPN(str2));

    }
    public static int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack= new Stack<>();
        int len =A.size();

        /*
        Idea is to keep pushing the elements to stack until we encounter an operator.
        Once operator is encountered, pop 2 times.
        Those are our 2 operands and perform the
        operation using the operator.
        Push the result back to stack.
        */


        String operators="+-/*";

        for(String ele: A){
            if(operators.contains(ele)==true){
                //notice the order of popping op1 and op2.

                int op2=stack.pop();
                int op1=stack.pop();

                switch(ele){
                    case "+": stack.push(op1+op2); break;
                    case "-": stack.push(op1-op2); break;
                    case "*": stack.push(op1*op2); break;
                    case "/": stack.push(op1/op2); break;
                }
            }
            else{
                stack.push(Integer.parseInt(ele));
            }
        }

        return stack.peek();

    }
}
