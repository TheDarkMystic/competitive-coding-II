package StackQueues;

/**
 * @author jakadam on 2019-12-19
 */

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 */

import java.util.*;


public class QueueUsingTwoStacks {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    /*
      Initialize the 2 stacks and the size of the queue
    */
    public QueueUsingTwoStacks() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    /*
      Push element to the pushStack and increase the size of the queue
      ...should be called something like "enqueue" but whatever
    */
    public void push(int item) {
        pushStack.push(item);
    }

    /*
      Get the element from the front of the queue...should be
      called "dequeue" but oh well (we are conforming to the naming
      from Leetcode)
    */
    public int pop() {

    /*
      If the stack we can pop items from is empty then we need
      to populate it.
      All we do is put all items from the pushStack into the
      popStack.
    */
        ensureThereAreItemsInPopStack();

    /*
      If we now have elements to pop then pop the item.
      
      If the popStack is empty by this point then the overarching
      queue is empty.
      Throw an exception seems to make the most sense. Returning
      -1 would be misleading since that is a valid return value.
    */
        if (!popStack.isEmpty()) {
            return popStack.pop();
        }

        // We assume all valid operations as the problem description says...
        // Here we would handle an empty queue...I wouldn't return -1 becuase
        // that'd be a misleading value since it is a valid int (and entries
        // could be negative)...but we have to since the function returns an int
        // and we can't compile without a default return statement
        return -1;
    }

    /*
      Peek the item at the front of the queue
    */
    public int peek() {

    /*
      Ensure that the pop stack has an item to peek
    */
        ensureThereAreItemsInPopStack();

    /*
      Peek the item if the queue is not empty
    */
        if (!popStack.isEmpty()) {
            return popStack.peek();
        }

        // Again...I'd throw an exception here. Returning -1 might be misleading.
        // But...we have to return -1 to compile
        return -1;
    }

    /*
      Is the queue empty?
    */
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    private void ensureThereAreItemsInPopStack() {
        if (popStack.isEmpty()) {
            populatePopStack();
        }
    }

    private void populatePopStack() {
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
    }

}

/**
 *
            n is the total items between the 2 stacks (in the overarching queue)

            Time: O( 1 ) - amortized (for enqueue and dequeue operations)
 *
 * Video- https://www.youtube.com/watch?v=Wg8IiY1LbII
 * 
 * https://www.geeksforgeeks.org/abstract-data-types/
 *
 * Abstract Data type (ADT) is a type (or class) for objects whose behaviour is defined by a set of
 * value and a set of operations.
 *
 * The definition of ADT only mentions what operations are to be performed but not how these
 * operations will be implemented. It does not specify how data will be organized in memory and what
 * algorithms will be used for implementing the operations. It is called “abstract” because it gives
 * an implementation-independent view. The process of providing only the essentials and hiding the
 * details is known as abstraction.
 *
 **/
