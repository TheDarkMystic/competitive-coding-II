package Hashing;

/**
 * @author jakadam on 2019-12-23
 */

import java.util.*;

/**
 * Given an array of strings, return all groups of strings that are anagrams. Represent a group by a list of integers
 * representing the index in the original list. Look at the sample case for clarification.
 *
 *  Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp'
 *  Note: All inputs will be in lower-case.
 * Example :
 *
 * Input : cat dog god tca
 * Output : [[1, 4], [2, 3]]
 * cat and tca are anagrams which correspond to index 1 and 4.
 * dog and god are another set of anagrams which correspond to index 2 and 3.
 * The indices are 1 based ( the first element has index 1 instead of index 0).
 *
 *  Ordering of the result : You should not change the relative ordering of the words / phrases within the group.
 *  Within a group containing A[i] and A[j], A[i] comes before A[j] if i < j.
 */
public class Anagram {
    public static void main(String[] args) {
        List<String> A = new ArrayList<>(Arrays.asList("cat", "dog", "god", "tca"));
        System.out.println(Arrays.toString(anagrams(A).toArray()));
    }

    public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
         /*
             Maintain HashMap<String,ArrayList<Integer>)

            For each string in the given list
            1. Convert string to char array
            2. sort the char array
            3. convert char array again to string
            4. This String is now our key for hashMap
            5. If map contains the key, add the index of the string to the arrayList in map values
            6. else add key to map,initialize a new ArrayList<Integer> for values, add the index of the string
                to the arrayList
        */
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            String str = A.get(i);
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String key = new String(s);

            // map operation
            if (map.containsKey(key)) {
                ArrayList<Integer> values = map.get(key);
                values.add(i + 1);
                map.put(key, values);
            } else {
                map.put(key, new ArrayList<>(Arrays.asList(i + 1)));
            }
        }

        //convert map values lists to arrayLists of arrayList
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (ArrayList<Integer> list : map.values())
            res.add(new ArrayList<>(list));


        return res;
    }
}
/*
Link-https://www.interviewbit.com/problems/anagrams/
Notes-

Problem is not complex, but converting collections and handling them is a challenge here

1. How string is sorted
2. converting values set of a map to arraylist

*/
