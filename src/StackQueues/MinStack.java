package StackQueues;

import java.util.Stack;

/**
 * @author jakadam on 2019-12-19
 */

/**
 * https://www.interviewbit.com/problems/min-stack/
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) – Push element x onto stack.
 * pop() – Removes the element on top of the stack.
 * top() – Get the top element.
 * getMin() – Retrieve the minimum element in the stack.
 * Note that all the operations have to be constant time operations.
 *
 * Questions to ask the interviewer :
 *
 * Q: What should getMin() do on empty stack?
 * A: In this case, return -1.
 *
 * Q: What should pop do on empty stack?
 * A: In this case, nothing.
 *
 * Q: What should top() do on empty stack?
 * A: In this case, return -1
 */


public class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    int min= Integer.MAX_VALUE;

    /*
    -    for all functions, ask the questioner, what should be the output if stack is empty.
    -    Ideas is - when we see that the next incoming ele is smaller than existing min,
                    we do 2 push operations.
                                - 1. push min on stack
                                - 2. push incoming ele
                    and then update the min variable with in coming ele.
    - Pushing 2 eles in above case helps us get the next minimum in stack, when we perform a pop()
      which causes the removal of current minimum from stack.
    */
    public void push(int x) {

        if(x<=min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.isEmpty()==true){
            //do nothing
        }
        else{
            int ele=stack.pop();
            if(ele==min)
                min=stack.pop();
        }
    }

    public int top() {
        if(stack.isEmpty()==true){
            return -1;
        }
        else{
            int top= stack.peek();
            return top;
        }
    }

    public int getMin() {
        if(stack.isEmpty()==true){
            return -1;
        }
        else{
            return min;
        }
    }
}
/**https://leetcode.com/problems/min-stack/discuss/49014/Java-accepted-solution-using-one-stack

 explanation in notebook

 alternate approach
 https://www.youtube.com/watch?v=8Ub73n4ySYk

 refer complete solution section for solution using 2 stacks
 */