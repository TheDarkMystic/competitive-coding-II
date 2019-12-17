package Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MaxConsecutiveGap {
    public static void main(String args[]) {
        List<Integer> nums= Arrays.asList(1,10,5);
        final MaxConsecutiveGapSolver solver= new MaxConsecutiveGapSolver();
        System.out.println(solver.solve(nums)) ;
    }
}

class MaxConsecutiveGapSolver{

    class Bucket{
        int low;
        int high;
        public Bucket(){
            low = -1;
            high = -1;
        }
    }
    // DO NOT MODIFY THE LIST
    public int solve(final List<Integer> a) {

        int[] num = new int[a.size()];
        for (int i = 0; i < num.length; i++) {
            num[i] = a.get(i);
        }

        if(num == null || num.length < 2){
            return 0;
        }

        int max = num[0];
        int min = num[0];
        for(int i=1; i<num.length; i++){
            max = Math.max(max, num[i]);
            min = Math.min(min, num[i]);
        }

        // initialize an array of buckets
        Bucket[] buckets = new Bucket[num.length+1]; //project to (0 - n)
        for(int i=0; i<buckets.length; i++){
            buckets[i] = new Bucket();
        }

        double gap = (double) (max - min) / num.length;
        //distribute every number to a bucket array
        for(int i=0; i<num.length; i++){
            int index = (int) ((num[i] - min)/gap);

            if(buckets[index].low == -1){
                buckets[index].low = num[i];
                buckets[index].high = num[i];
            }else{
                buckets[index].low = Math.min(buckets[index].low, num[i]);
                buckets[index].high = Math.max(buckets[index].high, num[i]);
            }
        }

        //scan buckets to find maximum gap
        int result = 0;
        int prev = buckets[0].high;
        for(int i=1; i<buckets.length; i++){
            if(buckets[i].low != -1){
                result = Math.max(result, buckets[i].low-prev);
                prev = buckets[i].high;
            }

        }

        return result;
    }

    public int solve1(final List<Integer> nums) {
        int n = nums.size();
        if (n < 2) return 0;
        Collections.sort(nums);
        int maxGap = 0;
        for (int i = 1; i < n; i += 1) {
            maxGap = Math.max(maxGap, nums.get(i) - nums.get(i - 1));
        }
        return maxGap;
    }
}