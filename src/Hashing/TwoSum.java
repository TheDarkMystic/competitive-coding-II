package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author jakadam on 2020-01-09
 */

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based.
 * Put both these numbers in order in an array and return the array from your function
 * ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.
 *
 * If multiple solutions exist, output the one where index2 is minimum.
 * If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.
 *
 * Input: [2, 7, 11, 15], target=9
 * Output: index1 = 1, index2 = 2
 */
public class TwoSum {
    public ArrayList<Integer> twoSum(final List<Integer> a, int b) {

        HashMap<Integer, Integer> map = new HashMap<>();

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            int curr = a.get(i);

            if (map.containsKey(b - curr)) {
                int index = map.get(b - curr);
                ans.add(index);
                ans.add(i + 1);
                return ans;
            }
            else if (!map.containsKey(curr)) {
                map.put(curr, i + 1);
            }
        }

        return ans;
    }
}


/**
 *
 * https://leetcode.com/problems/two-sum/#/solutions
 *
 * http://www.programcreek.com/2012/12/leetcode-solution-of-two-sum-in-java/
 *
 * hashmap duplicate key
 * http://javaworldwide.blogspot.in/2012/04/does-hashmap-allow-duplicate-key-or-how.html
 */