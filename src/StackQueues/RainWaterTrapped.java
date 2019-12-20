package StackQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jakadam on 2019-12-20
 */

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 *
 * Input Format
 *
 * The only argument given is integer array A.
 * Output Format
 *
 * Return the total water it is able to trap after raining..
 * For Example
 *
 * Input 1:
 *     A = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output 1:
 *     6
 * Explaination 1: <img src="http://i.imgur.com/0qkUFco.png">
 *
 *     In this case, 6 units of rain water (blue section) are being trapped.
 */

public class RainWaterTrapped {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static void main(String[] args) {
        List<Integer> A= new ArrayList<Integer>(Arrays.asList(0,1,0,2,1,0,1,3,2,1,2,1));
        System.out.println(trap(A));
    }
    public static int trap(final List<Integer> A) {

        //idea is to calculate water level above each individual wall
        //among rightmax or leftmax wall whichever is smaller use that as boundary

        int len= A.size();

        //Following 2 arrays track tallest to left and right of cur, respectively
        int[] tallestToLeft = new int[len];
        int[] tallestToRight = new int[len];

        //Tracking leftmax
        int maxToLeft=0;
        for(int i=0; i<len; i++){
            tallestToLeft[i]=maxToLeft;
            if(A.get(i)>maxToLeft)
                maxToLeft=A.get(i);
        }

        //Tracking rightMax
        int maxToRight=0;
        for(int i=len-1; i>=0; i--){
            tallestToRight[i]=maxToRight;
            if(A.get(i)>maxToRight)
                maxToRight=A.get(i);
        }

        //Calculating Water Content
        int waterQnt=0;
        for(int i=0; i<len; i++){
            // 0 in the Math.max is used to handle the case where both (i-1)th and (i+1)th walls
            //are shorter than the ith wall
            waterQnt=waterQnt+
                    Math.max(0, Math.min(tallestToRight[i],tallestToLeft[i]) - A.get(i));
        }


        return waterQnt;
    }
}