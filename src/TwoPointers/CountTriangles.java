package TwoPointers;

/**
 * @author jakadam on 2020-01-08
 */

import java.util.Arrays;

public class CountTriangles {
    public int nTriang(int[] A) {

        /**
         * The condition for the triplets (a, b, c)(a,b,c) representing
         * the lengths of the sides of a triangle, to form a valid
         * triangle, is that the sum of any two sides should always
         * be greater than the third side alone. i.e. a + b > ca+b>c,
         * b + c > ab+c>a, a + c > ba+c>b.
         *
         * As discussed in the last approach, once we sort the given numsnums array, we need to find the right limit of the index kk for a pair of indices (i, j)(i,j) chosen to find the countcount of elements satisfying nums[i] + nums[j] > nums[k]nums[i]+nums[j]>nums[k] for the triplet (nums[i], nums[j], nums[k])(nums[i],nums[j],nums[k]) to form a valid triangle.

         We can find this right limit by simply traversing the index kk's values starting from the index k=j+1k=j+1 for a pair (i, j)(i,j) chosen and stopping at the first value of kk not satisfying the above inequality. Again, the countcount of elements nums[k]nums[k] satisfying nums[i] + nums[j] > nums[k]nums[i]+nums[j]>nums[k] for the pair of indices (i, j)(i,j) chosen is given by k - j - 1k−j−1 as discussed in the last approach.

         Further, as discussed in the last approach, when we choose a higher value of index jj for a particular ii chosen, we need not start from the index j + 1j+1. Instead, we can start off directly from the value of kk where we left for the last index jj. This helps to save redundant computations.

         https://leetcode.com/articles/valid-triangle-number/
         */

        Arrays.sort(A);
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int sum = A[i] + A[j];
                for (int k = j + 1; k < A.length; k++) {
                    if (A[k] >= sum)
                        break;
                    ans++;
                }
                ans = ans % 1000000007;
            }
        }
        return ans;
    }
}

/**
 tested on Interviewbit
 https://www.interviewbit.com/problems/counting-triangles/
 */