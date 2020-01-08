package TwoPointers;

/**
 * @author jakadam on 2020-01-08
 */

import java.util.ArrayList;

/**
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: Using library sort function is not allowed.
 *
 * Example :
 *
 * Input : [0 1 2 0 1 2]
 * Modify array so that it becomes : [0 0 1 1 2 2]
 */

/**
 * The problem is similar to our old post Segregate 0s and 1s in an array, and both of these problems are variation of famous Dutch national flag problem.
 *
 * The problem was posed with three colours, here `0′, `1′ and `2′. The array is divided into four sections:
 *
 * a[1..Lo-1] zeroes (red)
 * a[Lo..Mid-1] ones (white)
 * a[Mid..Hi] unknown
 * a[Hi+1..N] twos (blue)
 * The unknown region is shrunk while maintaining these conditions
 *
 * Lo := 1; Mid := 1; Hi := N;
 * while Mid <= Hi do
 * Invariant: a[1..Lo-1]=0 and a[Lo..Mid-1]=1 and a[Hi+1..N]=2; a[Mid..Hi] are unknown.
 * case a[Mid] in
 * 0: swap a[Lo] and a[Mid]; Lo++; Mid++
 * 1: Mid++
 * 2: swap a[Mid] and a[Hi]; Hi--
 */
public class SortByColor {
    public void sortColors(ArrayList<Integer> a) {

        int len= a.size();

        int lo=0, mid=0, hi=len-1;

        int temp=0;//for swapping
        while(mid<=hi){ //condition is important
            int key=a.get(mid);

            switch(key){
                case 0:
                    temp=a.get(lo);
                    a.set(lo,a.get(mid));
                    a.set(mid,temp);
                    lo++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp=a.get(hi);
                    a.set(hi,a.get(mid));
                    a.set(mid, temp);
                    hi--;
                    break;
            }
        }
    }
}

/**
 AKA Dutch flag problem

 Best Explanation
 http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/


 //Alternative approaches
 //1. Sort array -> O(nLogn) time
 //2. create 3 seperate arrays and merge-> O(n) time and space
 */