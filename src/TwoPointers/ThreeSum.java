package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author jakadam on 2019-12-16
 */

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers.
 *
 * Assume that there will only be one solution
 *
 * Example:
 * given array S = {-1 2 1 -4},
 * and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 */
public class ThreeSum {
    public static void main(String args[]) {
        ThreeSumSolver solver = new ThreeSumSolver();

        //test1
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(-1,2,1,-4));
        int target=1;
        System.out.println((solver.solve(A,1)));
    }
}

class ThreeSumSolver{
    public int solve(ArrayList<Integer> A, int target){
        //sort the array
        Collections.sort(A);

        int len=A.size();
        int diff=Integer.MAX_VALUE;
        int ans=0;
        //we will use three pointers namely i, left and right to get the possible closest sum
        for(int i=0;i<len-2; i++){
            int left=i+1;
            int right=len-1;

            while(left<right){
                int sum=A.get(i)+A.get(left)+A.get(right);
                if(sum==target)
                    return target;
                else if(Math.abs(sum-target)<diff){
                    diff=Math.abs(sum-target);
                    ans=sum;
                }

                if(sum<target)
                    left++;
                else
                    right--;
            }
        }

        return ans;
    }
}
