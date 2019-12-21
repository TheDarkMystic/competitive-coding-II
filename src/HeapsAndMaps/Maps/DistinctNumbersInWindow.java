package HeapsAndMaps.Maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jakadam on 2019-12-21
 */

/**
 * You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of
 * count of distinct numbers in all windows of size K.
 *
 * Formally, return an array of size N-K+1 where i’th element in this array contains number
 * of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.
 *
 * Note:
 *
 *  If K > N, return empty array.
 *  A[i] is a signed integer
 * For example,
 *
 * A=[1, 2, 1, 3, 4, 3] and K = 3
 *
 * All windows of size K are
 *
 * [1, 2, 1]
 * [2, 1, 3]
 * [1, 3, 4]
 * [3, 4, 3]
 *
 * So, we return an array [2, 3, 3, 2].
 */
public class DistinctNumbersInWindow {
    public static void main(String[] args) {
        DistinctNumbersInWindowSolver solver = new DistinctNumbersInWindowSolver();

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 3));
        int windowSize = 3;

        System.out.println(Arrays.toString(solver.solve(A, windowSize).toArray()));

    }
}

class DistinctNumbersInWindowSolver {

    public ArrayList<Integer> solve(ArrayList<Integer> A, int windowSize) {
         /*
        Idea is
        1. Initialize a map of size= window size
        2. Keep sliding the window (add new ele to map, remove last ele from map)
            and count the distinct keys in map.
        */


        int len = A.size();
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        //corner case: window size is bigger than the size of arrayList, return empty list
        if (windowSize > len)
            return res;

        //initialize the map with elements of first window
        for (int i = 0; i < windowSize; i++) {
            addToMap(map, A.get(i));
        }

        //initialize the window boundaries
        int startOfWindow = 0;
        int endOfWindow = startOfWindow + windowSize - 1;
        int incomingEle = 0;
        int outgoingEle = 0;

        while (true) {
            // add the distinct elements in the window to the result list
            res.add(numOfkeysInMap(map));

            //slide the start of the window and remove the previous element from window
            outgoingEle = A.get(startOfWindow);
            removeFromMap(map, outgoingEle);
            startOfWindow++;

            //slide the end of the window add the new element to the window
            endOfWindow++;
            if (endOfWindow < len) {
                incomingEle = A.get(endOfWindow);
                addToMap(map, incomingEle);
            } else //reached end of list
                break;
        }
        return res;
    }

    /**
     * Adds a key,count to map
     *
     * @param map
     * @param key
     */
    public void addToMap(Map<Integer, Integer> map, int key) {
        if (map.containsKey(key) == false) {
            map.put(key, 1);
        } else {
            int count = map.get(key);
            map.put(key, count + 1);
        }
    }

    /**
     * Removes a key from key if only count is 1 else decrements the count
     *
     * @param map
     * @param key
     */
    public void removeFromMap(Map<Integer, Integer> map, int key) {
        if (map.containsKey(key) == true) {
            int count = map.get(key);
            if (count > 1)
                map.put(key, count - 1);
            else
                map.remove(key);
        }
    }

    /**
     * Returns the number of distinct keys in the map
     *
     * @param map
     * @return
     */
    public int numOfkeysInMap(Map<Integer, Integer> map) {
        return map.keySet().size();
    }
}

/**
 * tested on interviewbit
 * https://www.interviewbit.com/problems/distinct-numbers-in-window/
 */
