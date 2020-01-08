package TwoPointers;

/**
 * @author jakadam on 2020-01-07
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given with an array of 1s and 0s. And you are given with an integer M, which
 * signifies number of flips allowed.
 * Find the position of zeros which when flipped will produce maximum continuous series of 1s.
 *
 * For this problem, return the indices of maximum continuous series of 1s in order.
 *
 * Example:
 *
 * Input :
 * Array = {1 1 0 1 1 0 0 1 1 1 }
 * M = 1
 *
 * Output :
 * [0, 1, 2, 3, 4]
 *
 * If there are multiple possible solutions, return the sequence which has the minimum start index.
 */

/**
 * Approach 1: Generate all possible subaarays of the given array and find the longest subaaray having
 * less or m 0s. O(n^2)
 *
 * Approach 2: O(n) time, O(1) space
 * The idea is to use Sliding Window for the given array. The solution is taken from here.
 * Let us use a window covering from index wL to index wR. Let the number of zeros inside
 * the window be zeroCount. We maintain the window with at most m zeros inside.
 *
 * The main steps are:
 * – While zeroCount is no more than m: expand the window to the right (wR++) and update the
 *      count zeroCount.
 * – While zeroCount exceeds m, shrink the window from left (wL++), update zeroCount;
 * – Update the widest window along the way. The positions of output zeros are inside the
 *      best window.
 */
public class MaxContinuousSeriesOf1s {
    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>(Arrays.asList(1,1,0,1,1,0,0,1,1,1));
        System.out.println(Arrays.toString(solve(list,1).toArray()));
    }
    public static ArrayList<Integer> solve(ArrayList<Integer> A, int m){

        int len= A.size();
        //boundaries of the current windows
        int wL=0, wR=0;

        //boundary and size of the best window
        int bestL=0, bestWinSize=0;

        //number of zeros in the current window
        int zeroCount=0;

        // While right boundary of current window doesn't cross
        // right end
        while(wR<len){
            // If zero count of current window is less than m,
            // widen the window toward right
            if(zeroCount<=m){
                if(A.get(wR)==0)
                    zeroCount++;
                wR++;
            }
            // If zero count of current window is more than m,
            // reduce the window from left
            if(zeroCount>m){
                if(A.get(wL)==0)
                    zeroCount--;
                wL++;
            }
            // Update widest window if this window size is more
            if(wR-wL >bestWinSize){
                bestL=wL;
                bestWinSize=wR-wL;
            }
        }

        // Print positions of zeroes in the widest window
        ArrayList<Integer> ans= new ArrayList<>();
        for(int i=0; i<bestWinSize; i++){
            ans.add(bestL+i);
        }

        return ans;
    }
}
/**
 http://www.geeksforgeeks.org/find-zeroes-to-be-flipped-so-that-number-of-consecutive-1s-is-maximized/
 */